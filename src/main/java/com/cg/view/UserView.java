package com.cg.view;

import com.cg.model.User;
import com.cg.service.IUserService;
import com.cg.service.UserService;
import com.cg.utils.DateUtils;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private Scanner scanner = new Scanner(System.in);
    private IUserService userService;

    public UserView(){
        userService = new UserService();
    }
    public void launcher(){
        System.out.println("Menu quản lý user: ");
        System.out.println("Nhập 1. Xem danh sách ");
        System.out.println("Nhập 2. Thêm user");
        System.out.println("Nhập 3. Sửa user");
        System.out.println("Nhập 4. Xóa user theo ID");
        System.out.println("Nhập 5: Sắp xếp theo (Vào trong chọn thêm menu: tên/tuổi/giới tính/dob + TĂNG DẦN/GIẢM DẦN) ");
        System.out.println("Nhập 6: Tìm kiếm theo ");
        

        int actionMenu = Integer.parseInt(scanner.nextLine());
        switch (actionMenu) {
            case 1:
                showUsers();
                break;
            case 2:
                
        }
    }

    private void showUsers() {
        System.out.printf("%10s | %20s | %10s | %20s \n", "ID", "Name", "DOB", "ROLE");
        List<User> users = userService.getAllUsers();
        for (User u : users) {
            System.out.printf("%10s | %20s | %10s | %20s \n",
                    u.getId(), u.getName(), DateUtils.formatDate(u.getDob()), u.getRole());
        }
    }
}
