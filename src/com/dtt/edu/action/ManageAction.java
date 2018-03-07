package com.dtt.edu.action;

import com.dtt.edu.dbutil.BuMenDBUtil;
import com.dtt.edu.dbutil.UserDBUtil;
import com.dtt.edu.entity.BuMen;
import com.dtt.edu.entity.User;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManageAction {
    public User user;

    public Map session= ActionContext.getContext().getSession();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String Mstaff(){
        String name = session.get("name").toString();
        List<User> users= new ArrayList<User>();
        UserDBUtil udb = new UserDBUtil();
        User user = udb.findUserByName(name);
        System.out.println("管理员ID" + user.getId());
        users=udb.findByM_id(user.getId());
        session.put("users",users);
        return "success";
    }
    public String Mbm(){
        String name = session.get("name").toString();
        List<BuMen> bms = BuMenDBUtil.findAllBuMen();
        session.put("bms",bms);
        return "success";
    }

    public String change(){
        String name = session.get("name").toString();
        User us=UserDBUtil.findUserByName(name);

        session.put("us",us);
        return "success";
    }

    public String update(){
        int f=1;
        System.out.println("update+更新员工信息");
        UserDBUtil udb = new UserDBUtil();
        User us = udb.findUserByNameORGH(user.username);
        session.put("user",us);
        List<BuMen> bms = BuMenDBUtil.findAllBuMen();
        session.put("bms",bms);
        session.put("f",f);
        return "success";
    }


}
