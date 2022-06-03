package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

   public Properties pro;

    public Readconfig()
    {
        File src = new File("C:\\Users\\GURNIWAAZ\\IdeaProjects\\InetBankingV1\\src\\configuration\\config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL()
    {
        String url= pro.getProperty("baseURL");
        return url;
    }

    public String getUsername()
    {
        String username=pro.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }
}
