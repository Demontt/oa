package com.dtt.edu.action;

import com.dtt.edu.dbutil.*;
import com.dtt.edu.entity.*;
import com.dtt.edu.util.EntityUtil;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static java.lang.Math.min;

public class HuiBaoAction {
    public String rq;
    public int zyy;
    public HuiBao hb;
    public BuMen bm;
    public int hb_id;
    public Map session= ActionContext.getContext().getSession();
    public PiWen pt;
//    public List<NowTask> nowTasks;


    public int getHd_id() {
        return hb_id;
    }

    public void setHd_id(int hb_id) {
        this.hb_id = hb_id;
    }

    public PiWen getPt() {
        return pt;
    }

    public void setPt(PiWen pt) {
        this.pt = pt;
    }

    public int getZyy() {
        return zyy;
    }

    public void setZyy(int zyy) {
        this.zyy = zyy;
    }

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }

    //本周起承担任务
    public String[] cdtask;
    //本周起下达日期
    public String[] xdrq;
    //本周起完成日期
    public String[] wcrq;

    //下周承担任务
    public String[] nextTask;
    //下周预计完成日期
    public String[] nextWCDate;
    //备注
    public String[] nextbz;

    //问题
    //承担任务
    public String[] wtrenwu;
    //主要问题
    public String[] wtwt;
    //对策和建议
    public String[] wtdc;

    //序号
    public List<Integer> xuhao;

    public String[] getWtrenwu() {
        return wtrenwu;
    }
    public void setWtrenwu(String[] wtrenwu) {
        this.wtrenwu = wtrenwu;
    }
    public String[] getWtwt() {
        return wtwt;
    }
    public void setWtwt(String[] wtwt) {
        this.wtwt = wtwt;
    }
    public String[] getWtdc() {
        return wtdc;
    }
    public void setWtdc(String[] wtdc) {
        this.wtdc = wtdc;
    }
    public String[] getNextTask() {
        return nextTask;
    }
    public void setNextTask(String[] nextTask) {
        this.nextTask = nextTask;
    }
    public String[] getNextWCDate() {
        return nextWCDate;
    }
    public void setNextWCDate(String[] nextWCDate) {
        this.nextWCDate = nextWCDate;
    }

    public String[] getNextbz() {
        return nextbz;
    }
    public void setNextbz(String[] nextbz) {
        this.nextbz = nextbz;
    }
    public String[] getCdtask() {
        return cdtask;
    }
    public void setCdtask(String[] cdtask) {
        this.cdtask = cdtask;
    }
    public String[] getXdrq() {
        return xdrq;
    }
    public void setXdrq(String[] xdrq) {
        this.xdrq = xdrq;
    }
    public String[] getWcrq() {
        return wcrq;
    }
    public void setWcrq(String[] wcrq) {
        this.wcrq = wcrq;
    }
    public HuiBao getHb() {
        return hb;
    }
    public void setHb(HuiBao hb) {
        this.hb = hb;
    }
    public BuMen getBm() {
        return bm;
    }
    public void setBm(BuMen bm) {
        this.bm = bm;
    }

    //待发汇报
    public String daiHB(){
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        List<HuiBao> hbs=HuiBaoDBUtil.findHuiBaoByUserIdAndTYAndST(user.getId(),hb.ty,2);
        session.put("hbs",hbs);
        int zyy=-1;
        if(hb.ty==0){
            zyy=EntityUtil.weekNum;
            session.put("zyy",zyy);
            return "zb";
        }
        if(hb.ty==1){
            zyy=EntityUtil.parseMonth();
            session.put("zyy",zyy);
            return "yb";
        }
        if(hb.ty==2){
            zyy=EntityUtil.parseYear();
            session.put("zyy",zyy);
            return "nb";
        }
        return "success";
    }

    //待发汇报的发送
    public String fasongHB(){
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        HuiBaoDBUtil hbdb = new HuiBaoDBUtil();

        HuiBao xx= hbdb.findHuiBaoByIdAndZyysAndSTAndTy(user.getId(),zyy,2,hb.ty);
        hbdb.updateHuiBaoByIdSetST(xx.getId(),1);
        return "success";
    }

    //待发汇报的删除
    public String deleteHB(){
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        HuiBaoDBUtil hbdb = new HuiBaoDBUtil();
        //System.out.println(user.getId()+zyy);
        HuiBao xx= hbdb.findHuiBaoByIdAndZyysAndSTAndTy(user.getId(),zyy,hb.st,hb.ty);
        System.out.println(xx.getId());
        hbdb.deleteHuiBaoById(xx.getId());
        NowTaskDBUtil nt= new NowTaskDBUtil();
        nt.deleteNowTaskByHbId(xx.getId());
        NextTaskDBUtil nxt = new NextTaskDBUtil();
        nxt.deleteNextTaskByHbId(xx.getId());
        WenTiDBUtil wt = new WenTiDBUtil();
        wt.deleteWenTiByHbId(xx.getId());
        return "success";
    }


    //待发汇报的编辑
    public String bianji(){
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        bm = BuMenDBUtil.findByID(user.getBm_id());
        hb.setBm_name(bm.getName());
        hb.setRq(EntityUtil.parseTimex());
        hb.setM_name(UserDBUtil.findById(user.getManager_id()).getUsername());

        HuiBaoDBUtil hbdb = new HuiBaoDBUtil();
        System.out.println(zyy);
        HuiBao xx= hbdb.findHuiBaoByIdAndZyysAndSTAndTy(user.getId(),zyy,2,hb.ty);


        NowTaskDBUtil nt= new NowTaskDBUtil();
        List<NowTask> nts = nt.findNowTaskByHbId(xx.getId());

        NextTaskDBUtil nxt = new NextTaskDBUtil();
        List<NextTask> nxts = nxt.findNextTaskByHbId(xx.getId());

        WenTiDBUtil wt = new WenTiDBUtil();
        List<WenTi> wts = wt.findNextTaskByHbId(xx.getId());

        session.put("nts",nts);
        session.put("nxts",nxts);
        session.put("wts",wts);
        List<User> users=new ArrayList<User>();
        users=UserDBUtil.findUserByBm_ID(user.getBm_id());
        List<BuMen> bms=BuMenDBUtil.findAllBuMen();
        session.put("users",users);
        session.put("bms",bms);
        if(hb.ty==0){
            hb.setZyys(EntityUtil.weekNum);
            return "zb";
        }
        if(hb.ty==1){
            hb.setZyys(EntityUtil.parseMonth());
            return "yb";
        }
        if(hb.ty==2){
            hb.setZyys(EntityUtil.parseYear());
            return "nb";
        }
        return "success";
    }

    //待发汇报的编辑
    public String watch(){
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        bm = BuMenDBUtil.findByID(user.getBm_id());

        hb.setBm_name(bm.getName());
        hb.setRq(EntityUtil.parseTimex());
        hb.setM_name(UserDBUtil.findById(user.getManager_id()).getUsername());

        HuiBaoDBUtil hbdb = new HuiBaoDBUtil();
        //System.out.println("**********"+zyy);
        //System.out.println(hb.ty);
        HuiBao xx= hbdb.findHuiBaoByIdAndZyysAndSTAndTy(user.getId(),zyy,3,hb.ty);

        pt = PiWenDBUtil.findPiWenByHbId(xx.getId());

        NowTaskDBUtil nt= new NowTaskDBUtil();
        List<NowTask> nts = nt.findNowTaskByHbId(xx.getId());

        NextTaskDBUtil nxt = new NextTaskDBUtil();
        List<NextTask> nxts = nxt.findNextTaskByHbId(xx.getId());

        WenTiDBUtil wt = new WenTiDBUtil();
        List<WenTi> wts = wt.findNextTaskByHbId(xx.getId());

        session.put("nts",nts);
        session.put("nxts",nxts);
        session.put("wts",wts);
        List<User> users=new ArrayList<User>();
        List<BuMen> bms=new ArrayList<BuMen>();
        User us1 = new User();
        BuMen bm1=new BuMen();
        for (int i = 0; i <nxts.size() ; i++) {
            us1.setUsername(nxts.get(i).getZr());
            users.add(us1);
            bm1.setName(nxts.get(i).getXtbm());
            bms.add(bm1);
        }
        session.put("users",users);
        session.put("bms",bms);

        PiWen spw = PiWenDBUtil.findPiWenByHbId(xx.getId());
        pt.setM_bm(spw.getM_bm());
        pt.setM_name(spw.getM_name());
        pt.setDes(spw.getDes());
        pt.setSj(spw.getSj());
        if(hb.ty==0){
            hb.setZyys(EntityUtil.weekNum);
            return "zb";
        }
        if(hb.ty==1){
            hb.setZyys(EntityUtil.parseMonth());
            return "yb";
        }
        if(hb.ty==2){
            hb.setZyys(EntityUtil.parseYear());
            return "nb";
        }
        return "success";
    }

    public String upsashb(){
        xuhao=new ArrayList<Integer>();
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        HuiBaoDBUtil hbdb = new HuiBaoDBUtil();
        HuiBao xx= hbdb.findHuiBaoByIdAndZyysAndSTAndTy(user.getId(),hb.zyys,2,hb.ty);
        hb.setCsren(name);
        hb.setUser_id(user.getId());
        //System.out.println("汇报"+user.getId()+" "+hb.zyys+" ");
        //System.out.println("汇报"+xx.getId());
        int autoid = xx.getId();
        System.out.println(autoid);
        List<NowTask> nts = NowTaskDBUtil.findNowTaskByHbId(autoid);
        int len1=nts.size();
        System.out.println("第一个长度"+len1);
        for (int i = 0; i <len1; i++) {
            xuhao.add(nts.get(i).getId());
        }
        NowTaskDBUtil ntdb = new NowTaskDBUtil();
        NextTaskDBUtil nxtdb=new NextTaskDBUtil();
        WenTiDBUtil wtdb=new WenTiDBUtil();

        int len2=cdtask.length;
        System.out.println("第一个长度"+len1);
        System.out.println("第二个长度"+len2);
        if(len1>len2){
            for(int i=len2;i>len1;i++){
                ntdb.deleteNowTaskById(xuhao.get(i));
            }
        }
        else if(len1<len2){
            for(int i=len1;i<len2;i++){
                NowTask nt = new NowTask();
                nt.setCdtask(cdtask[i]);
                nt.setXdrq(xdrq[i]);
                nt.setWcrq(wcrq[i]);
                nt.setHb_id(autoid);
                //把nt插入数据库
                ntdb.insertNowTask(nt);
            }
        }
        for (int i = 0; i < min(len2,len1); i++) {
            NowTask nt = new NowTask();
            nt.setCdtask(cdtask[i]);
            nt.setXdrq(xdrq[i]);
            nt.setWcrq(wcrq[i]);
            //把nt插入数据库
            ntdb.updateNowTask(nt,xuhao.get(i));
        }
        xuhao.clear();

        List<NextTask> nxts = NextTaskDBUtil.findNextTaskByHbId(xx.getId());
        for (int i = 0; i <nxts.size() ; i++) {
            xuhao.add(nxts.get(i).getId());
        }

        //下周工作总结
        HttpServletRequest hsr = ServletActionContext.getRequest();
        String[] nextzrren=hsr.getParameterValues("nextzrren");
        String[] nextczbm= hsr.getParameterValues("nextczbm");
        len1= nxts.size();
        //下周总结
        len2=nextTask.length;
        if(len1>len2){
            for(int i=len2;i>len1;i++){
                nxtdb.deleteNextTaskById(xuhao.get(i));
            }
        }
        else if(len1<len2){
            for (int i=len1;i<len2;i++) {
                NextTask nxt = new NextTask();
                nxt.setCdtask(nextTask[i]);
                nxt.setRq(nextWCDate[i]);
                nxt.setZr(nextzrren[i]);
                nxt.setXtbm(nextczbm[i]);
                nxt.setBz(nextbz[i]);
                nxt.setHb_id(autoid);
                //把nxt插入数据库
                nxtdb.insertNextTask(nxt);
            }
        }
        for (int i = 0; i < min(len1,len2); i++) {
            NextTask nxt = new NextTask();
            nxt.setCdtask(nextTask[i]);
            nxt.setRq(nextWCDate[i]);
            nxt.setZr(nextzrren[i]);
            nxt.setXtbm(nextczbm[i]);
            nxt.setBz(nextbz[i]);
            //把nxt插入数据库
            nxtdb.updateNextTask(nxt,xuhao.get(i));
        }
        xuhao.clear();

        //问题

        List<WenTi> wts = WenTiDBUtil.findNextTaskByHbId(xx.getId());
        for (int i = 0; i <wts.size() ; i++) {
            xuhao.add(wts.get(i).getId());
        }
        len1=wts.size();
        len2=wtrenwu.length;
        if(len1>len2){
            for(int i=len2;i>len1;i++){
                wtdb.deleteWenTiById(xuhao.get(i));
            }
        }
        else if(len1<len2){
            for (int i=len1;i<len2;i++) {
                WenTi wt = new WenTi();
                wt.setCdtask(wtrenwu[i]);
                wt.setZywt(wtwt[i]);
                wt.setDcjjy(wtdc[i]);
                wt.setHb_id(autoid);
                //把wt插入数据库
                wtdb.insertWenti(wt);
            }
        }
        for (int i = 0; i < min(len1,len2); i++) {
            WenTi wt = new WenTi();
            wt.setCdtask(wtrenwu[i]);
            wt.setZywt(wtwt[i]);
            wt.setDcjjy(wtdc[i]);
            //把wt插入数据库
            wtdb.updateWenTi(wt,xuhao.get(i));
        }

        xuhao.clear();
        List<HuiBao> hbs=HuiBaoDBUtil.findHuiBaoByUserIdAndST(user.getId(),2);
        session.put("hbs",hbs);
        int zyy=-1;
        if(hb.ty==0){
            zyy=EntityUtil.weekNum;
            session.put("zyy",zyy);
            return "zb";
        }
        if(hb.ty==1){
            zyy=EntityUtil.parseMonth();
            session.put("zyy",zyy);
            return "yb";
        }
        if(hb.ty==2){
            zyy=EntityUtil.parseYear();
            session.put("zyy",zyy);
            return "nb";
        }

        return "success";
    }

    public String saveHB(){
        String name = session.get("name").toString();
        List<HuiBao> hbs=HuiBaoDBUtil.findHuiBaoByMnameAndTYAndST(name,hb.ty,1);
//        System.out.println("hbs.size::::"+hbs.size());
        session.put("hbs",hbs);
        return "success";
    }
    public String saveall(){
        String name = session.get("name").toString();
        List<HuiBao> wfzbs=HuiBaoDBUtil.findHuiBaoByMnameAndTYAndST(name,0,1);
        List<HuiBao> wfybs=HuiBaoDBUtil.findHuiBaoByMnameAndTYAndST(name,1,1);
        List<HuiBao> wfnbs=HuiBaoDBUtil.findHuiBaoByMnameAndTYAndST(name,2,1);
        session.put("wfzbs",wfzbs);
        session.put("wfybs",wfybs);
        session.put("wfnbs",wfnbs);

        return "success";
    }
    public String yiHB(){
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        List<HuiBao> hbs=HuiBaoDBUtil.findHuiBaoByUserIdAndTYAndORST(user.getId(),hb.ty,1,3);
        session.put("hbs",hbs);
        int zyy=-1;
        System.out.println("hb.ty"+hb.ty);
        if(hb.ty==0){
            zyy=EntityUtil.weekNum;
            session.put("zyy",zyy);
            return "zb";
        }
        if(hb.ty==1){
            zyy=EntityUtil.parseMonth();
            session.put("zyy",zyy);
            return "yb";
        }
        if(hb.ty==2){
            zyy=EntityUtil.parseYear();
            session.put("zyy",zyy);
            return "nb";
        }
        return "success";
    }

    public String newHB(){
        String name = session.get("name").toString();
        //根据用户名得到用户
        User user = UserDBUtil.findUserByName(name);
        //验证确实从数据库得到用户信息
        bm = BuMenDBUtil.findByID(user.getBm_id());
        //确定数据库中唯一一条汇报数据需要：用户id,汇报类型ty,周数weekNum
        //汇报类型。0-周报 ； 1-月报 ； 2-年报
        hb.setBm_name(bm.getName());
        hb.setRq(EntityUtil.parseTimex());
        hb.setM_name(UserDBUtil.findById(user.getManager_id()).getUsername());

        List<User> users=new ArrayList<User>();
        users=UserDBUtil.findUserByBm_ID(user.getBm_id());

        List<BuMen> bms=BuMenDBUtil.findAllBuMen();
        session.put("users",users);
        session.put("bms",bms);
        if(hb.ty==0){
            hb.setZyys(EntityUtil.weekNum);
            return "zb";
        }
        if(hb.ty==1){
            hb.setZyys(EntityUtil.parseMonth());
            return "yb";
        }
        if(hb.ty==2){
            hb.setZyys(EntityUtil.parseYear());
            return "nb";
        }
        return "success";
    }
    public String sashb(){
        //本周工作总结
        /*System.out.println(Arrays.toString(cdtask));
        System.out.println(Arrays.toString(xdrq));
        System.out.println(Arrays.toString(wcrq));*/
        String name = session.get("name").toString();
        User user = UserDBUtil.findUserByName(name);
        hb.setCsren(name);
        hb.setUser_id(user.getId());
        //插入数据库
        //插入新汇报表
        HuiBaoDBUtil hbdb=new HuiBaoDBUtil();
        int autoid = hbdb.getHuiBaoId(hb);
        //页面
        NowTaskDBUtil ntdb = new NowTaskDBUtil();
        for (int i = 0; i < cdtask.length; i++) {
            NowTask nt = new NowTask();
            nt.setCdtask(cdtask[i]);
            nt.setXdrq(xdrq[i]);
            nt.setWcrq(wcrq[i]);
            nt.setHb_id(autoid);
            //把nt插入数据库
            ntdb.insertNowTask(nt);
        }

        //下周工作总结
        HttpServletRequest hsr = ServletActionContext.getRequest();
        String[] nextzrren=hsr.getParameterValues("nextzrren");
        String[] nextczbm= hsr.getParameterValues("nextczbm");
        //System.out.println(array);
        NextTaskDBUtil nxtdb=new NextTaskDBUtil();
        for (int i = 0; i < nextTask.length; i++) {
            NextTask nxt = new NextTask();
            nxt.setCdtask(nextTask[i]);
            nxt.setRq(nextWCDate[i]);
            nxt.setZr(nextzrren[i]);
            nxt.setXtbm(nextczbm[i]);
            nxt.setBz(nextbz[i]);
            nxt.setHb_id(autoid);
            //把nxt插入数据库
            nxtdb.insertNextTask(nxt);
        }

        //问题
        WenTiDBUtil wtdb = new WenTiDBUtil();
        for (int i = 0; i < wtrenwu.length; i++) {
            WenTi wt = new WenTi();
            wt.setCdtask(wtrenwu[i]);
            wt.setZywt(wtwt[i]);
            wt.setDcjjy(wtdc[i]);
            wt.setHb_id(autoid);
            //把wt插入数据库
            wtdb.insertWenti(wt);
        }
        session.put("hb",hb);

        return "success";
    }

    public String pifu(){
        String name = hb.csren;
        User user = UserDBUtil.findUserByName(name);
        bm = BuMenDBUtil.findByID(user.getBm_id());

        hb.setBm_name(bm.getName());
        hb.setRq(EntityUtil.parseTimex());
        hb.setM_name(UserDBUtil.findById(user.getManager_id()).getUsername());

        HuiBaoDBUtil hbdb = new HuiBaoDBUtil();
        HuiBao xx= hbdb.findHuiBaoByIdAndZyysAndSTAndTy(user.getId(),zyy,1,hb.ty);
        hb.setId(xx.getId());
        NowTaskDBUtil nt= new NowTaskDBUtil();
        List<NowTask> nts = nt.findNowTaskByHbId(xx.getId());

        NextTaskDBUtil nxt = new NextTaskDBUtil();
        List<NextTask> nxts = nxt.findNextTaskByHbId(xx.getId());

        WenTiDBUtil wt = new WenTiDBUtil();
        List<WenTi> wts = wt.findNextTaskByHbId(xx.getId());

        session.put("nts",nts);
        session.put("nxts",nxts);
        session.put("wts",wts);
        List<User> users=new ArrayList<User>();
        List<BuMen> bms=new ArrayList<BuMen>();
        User us1 = new User();
        BuMen bm1=new BuMen();
        for (int i = 0; i <nxts.size() ; i++) {
            us1.setUsername(nxts.get(i).getZr());
            users.add(us1);
            bm1.setName(nxts.get(i).getXtbm());
            bms.add(bm1);
        }
        session.put("users",users);
        session.put("bms",bms);


        if(hb.ty==0){
            hb.setZyys(EntityUtil.weekNum);
            return "zb";
        }
        if(hb.ty==1){
            hb.setZyys(EntityUtil.parseMonth());
            return "yb";
        }
        if(hb.ty==2){
            hb.setZyys(EntityUtil.parseYear());
            return "nb";
        }
        return "success";
    }


    public String back(){
        saveHB();
        return "success";
    }

    public String pwfs(){
        HuiBao hb12 =HuiBaoDBUtil.findHuibaoById(hb_id);
        //System.out.println("Huibao:::"+hb_id);
        pt.setM_bm(hb12.bm_name);
        pt.setM_name(hb12.m_name);
        pt.setHb_id(hb12.id);
        pt.setSj(hb12.rq);
        //System.out.println("批文：：：："+pt.getDes());
        PiWenDBUtil.insertNextTask(pt);
        HuiBaoDBUtil.updateHuiBaoByIdSetST(hb12.id,3);
        saveHB();
        return "success";
    }
}
