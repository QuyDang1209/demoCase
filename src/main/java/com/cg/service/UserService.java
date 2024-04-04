package com.cg.service;

import com.cg.model.ECategory;
import com.cg.model.ERole;
import com.cg.model.User;
import com.cg.utils.DateUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    @Override
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("./data/users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                // line : 1,Iphone 11,1000000,IPHONE
                String[] items = line.split(",");
                User u = new User();
                u.setId(Integer.parseInt(items[0]));
                u.setName(items[1]);
                u.setPassword(items[2]);
                u.setDob(DateUtils.parse(items[3]));
                u.setRole(ERole.findERoleBy(items[4]));
                users.add(u);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return users;
    }
}
