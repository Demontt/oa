package com.dtt.edu.test;

import com.dtt.edu.dbutil.UserDBUtil;
import com.dtt.edu.entity.User;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        UserDBUtil userdb = new UserDBUtil();
        User user=new User();
        Scanner sc = new Scanner(System.in);
        user.setGh(sc.next());
        user.setUsername(sc.next());
        user.setPwd(sc.next());
        user.setPhone(sc.next());
        user.setPow(sc.nextInt());
        user.setManager_id(sc.nextInt());
        user.setBm_id(sc.nextInt());
        userdb.insertUser(user);
    }
}
