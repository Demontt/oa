package com.dtt.edu.entity;

public class User {
    public int id;
    public String gh;
    public String username;
    public String pwd;
    public String phone;
    public int pow;
    public int manager_id;
    public int bm_id;
    public String bm_name;

    //未发汇报员工中使用
    public String ty;
    public int zyy;

    public String getTy() {
        return ty;
    }

    public void setTy(String ty) {
        this.ty = ty;
    }

    public int getZyy() {
        return zyy;
    }

    public void setZyy(int zyy) {
        this.zyy = zyy;
    }

    public String getBm_name() {
        return bm_name;
    }

    public void setBm_name(String bm_name) {
        this.bm_name = bm_name;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getBm_id() {
        return bm_id;
    }

    public void setBm_id(int bm_id) {
        this.bm_id = bm_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
