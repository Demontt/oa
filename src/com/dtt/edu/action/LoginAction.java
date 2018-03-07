package com.dtt.edu.action;

import com.dtt.edu.dbutil.*;
import com.dtt.edu.entity.*;
import com.dtt.edu.util.EntityUtil;
import com.opensymphony.xwork2.ActionContext;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginAction {
    //f用来确定是从登录页面提交的登录请求，还是从主页的左侧页面提交的登录请求
    public int f;
    public User user;
    public List<User> wfhbus;
    public String hbmesg;
    public Map session= ActionContext.getContext().getSession();
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<User> getWfhbus() {return wfhbus;}
    public void setWfhbus(List<User> wfhbus) { this.wfhbus = wfhbus;}
    public String getHbmesg() {
        return hbmesg;
    }
    public void setHbmesg(String hbmesg) {
        this.hbmesg = hbmesg;
    }
    //主页面上查询员工通讯录
    public String findygtxl(){
       User user = UserDBUtil.findUserByNameORGH(hbmesg);
        if(hbmesg.equals("请输入员工姓名或工号")){
            session.put("users",pjyhtxl());
            return "success";
        }
        if(user.getId()==0){
            session.put("users",null);
        }
        else{
            user = pjyhtxl(user);
            List<User> users = new ArrayList<>();
            users.add(user);
            session.put("users",users);
        }
        return "success";
    }


    private User pjyhtxl(User us){
        BuMen bm= BuMenDBUtil.findByID(us.getBm_id());
        us.setBm_name(bm.getName());
        return us;
    }

    public String listwf(){
        //System.out.println("LoginAction"+hbmesg+":listwf");
        if(hbmesg.equals("请输入员工姓名或工号")){
            //直接转发到登录请求
            session.put("wfhbus",wfhbus());
            return "success";
        }
        User user = UserDBUtil.findUserByNameORGH(hbmesg);
        if(user.getId()==0){
            session.put("wfhbus",null);
        }
        else{
            List<HuiBao> hbs = HuiBaoDBUtil.findHuiBaoByUserIdAndST(user.getId(),0);
            List<User> users = new ArrayList<>();
            for(int i=0;i<hbs.size();i++){
                User us = new User();
                us.setUsername(user.getUsername());
                us.setGh(user.getGh());
                if(hbs.get(i).getTy()==0){
                    us.setTy("周报");
                }
                if(hbs.get(i).getTy()==1){
                    us.setTy("月报");
                }
                if(hbs.get(i).getTy()==2){
                    us.setTy("年报");
                }
                us.setZyy(hbs.get(i).getZyys());
                users.add(us);
            }
            session.put("wfhbus",users);
        }

        return "success";
    }
    public String login()
    {
        if(f==1){
           return "success";
        }
        User us = UserDBUtil.findByGH(user.getGh());
        /*
         * 因为用户名可能会重复导致系统会在这里崩溃
         */
        //系统会在这里出现奔溃
        if((user.pwd).equals(us.getPwd())){
            //1.随时清空session
            session.put("name",us.getUsername());
            //2.随时清空session
            session.put("pow", us.getPow());
            //3.随时清空session
            session.put("users", pjyhtxl());
            //4.随时清空session
            session.put("gh",user.getGh());

            //自动更新当前用户上周期数据
            if(us.getPow()!=2){
                //自动更新周报
                updatewf(us,0,EntityUtil.weekNum-1);
                //自动更新月报
                updatewf(us,1,EntityUtil.parseMonth()-1);
                //自动更新年报
                updatewf(us,2,EntityUtil.parseYear()-1);
            }
            //在exit中清空session

            //上一周期未发汇报的员工
            session.put("wfhbus",wfhbus());

            return "success";
        }
        //登录失败
        return "error";
    }

    private void updatewf(User user,int ty,int zyys){
        HuiBao hb = HuiBaoDBUtil.findHuiBaoByIdAndTYAndST(user.getId(),ty,zyys);
        if(hb.getId()==0){
            //表示上周期周报未发
            hb = new HuiBao();
            hb.setTy(ty);
            String bm_name = BuMenDBUtil.findByID(user.getBm_id()).getName();
            hb.setBm_name(bm_name);
            String m_name = UserDBUtil.findById(user.getManager_id()).getUsername();
            hb.setM_name(m_name);
            hb.setSt(0);
            hb.setUser_id(user.getId());
            hb.setZyys(zyys);
            HuiBaoDBUtil.insertHuiBao(hb);
        }
    }

    private List<User> wfhbus(){
        List<User> users = new ArrayList<User>();
        //1.查出上周周报未发的员工
        //ty=0,weekNum,st=0
        //可以用组合查询
        wf(0,EntityUtil.weekNum-1,users);
        //2.查出上月月报未发的员工
        wf(1,EntityUtil.parseMonth()-1,users);
        //3.查出上年年报未发的员工
        wf(2,EntityUtil.parseYear()-1,users);
        return users;
    }

    private  void wf(int ty,int zyys,List<User> users){
        List<HuiBao> hbs = HuiBaoDBUtil.FindWFHB(ty,zyys,0);
        for(int i=0;i<hbs.size();i++){
            User user = UserDBUtil.findById(hbs.get(i).getUser_id());
            if(ty==0){
                user.setTy("周报");
            }
            if(ty==1){
                user.setTy("月报");
            }
            if(ty==2){
                user.setTy("年报");
            }
            user.setZyy(zyys);
            users.add(user);
        }

    }

    //退出系统
    public String exit(){
        //清空所有的session值即可
        session.put("name",null);
        session.put("pow",null);
        session.put("users",null);
        session.put("gh",null);
        return "success";
    }
    /**
     * 拼接主页面上用户通讯录
     */
    private List<User> pjyhtxl(){
        //得到数据库中的所有用户，拼接成页面上显示需要
        List<User> users = UserDBUtil.findAllUsers();
        //根据数据库返回的用户信息，拼接页面上显示需要的用户信息
        for(int i=0;i<users.size();i++){
            //得到用户
            User user = users.get(i);
            //拼接页面上需要显示的用户信息
            pjyhtxl(user);
        }
        return users;

    }
}


