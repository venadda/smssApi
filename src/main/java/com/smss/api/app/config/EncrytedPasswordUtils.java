package com.smss.api.app.config;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    public static boolean checkPwd(String ppwd,String hpwd){
        return BCrypt.checkpw(ppwd,hpwd);
    }

    public static void main(String[] args) {
        String password = "welcome1";
        String encrytedPassword = encrytePassword(password);
        if(checkPwd(password,"$2a$10$1G3ci8gMZIht8esQYEXCPOWby/hB9Ug3eBt1bBbYZDbvTMShdu2j2"))
            System.out.println("ok venkat");
        System.out.println("Encryted Password: " + encrytedPassword);
    }

}
