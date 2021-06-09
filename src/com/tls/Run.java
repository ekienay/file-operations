package com.tls;

import com.tls.Implements.UserServiceImpl;
import com.tls.model.User;
import com.tls.service.CRUD;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Run extends Thread {

    public static void main(String[] args) {

        //CRUD operations..
        CRUD<User,Long> crud = new UserServiceImpl();
        User user = new User( 5L,"artem","1");
        User user1 = new User(6L,"alex","2");
        crud.create(user);
        crud.create(user1);
        Collection<User> collection = crud.findAll();
        List<User> userList = new ArrayList<>(collection);

        //Input data to file.txt..
        try{
          FileOutputStream fos = new FileOutputStream("text.txt",true);
          OutputStreamWriter writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
          PrintWriter out = new PrintWriter(writer);
            for (User j : userList) {
                out.println(j);
            }
            out.close();

            // Get data from file.txt
            System.out.println(Files.readString(Paths.get("text.txt")));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
