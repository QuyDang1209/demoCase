package com.cg;

import com.cg.view.ProductView;
import com.cg.view.UserView;

public class ShoppingApp {
    public static void main(String[] args) {
//        ProductView productView = new ProductView();

        UserView userView = new UserView();
        userView.launcher();

        long currentId = System.currentTimeMillis() % 100000;

    }
}
