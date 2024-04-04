package com.cg.view;

import com.cg.model.Product;
import com.cg.service.IProductService;
import com.cg.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    private IProductService productService;

    public ProductView(){
        productService = new ProductService();
    }
    public void launcher(){
        System.out.println("Menu quản lý Sản phẩm: ");
        System.out.println("Nhập 1. Xem danh sách ");
        System.out.println("Nhập 2. Thêm product");
        System.out.println("Nhập 3. Sửa product");
        System.out.println("Nhập 4. Xóa product theo ID");
        System.out.println("Nhập 5: Sắp xếp theo (Vào trong chọn thêm menu: tên/giá/category + TĂNG DẦN/GIẢM DẦN) ");
        System.out.println("Nhập 6: Tìm kiếm theo tên");

        int actionMenu = Integer.parseInt(scanner.nextLine());
        switch (actionMenu) {
            case 1: {
                showProduct();
                break;
            }
            case 2: {
//                addProduct();
                break;
            }
        }
    }

    private void showProduct() {
        List<Product> products = productService.getAllProducts();
        System.out.printf("%10s | %20s | %30s | %20s | %10s \n", "ID", "Name", "DESCRIPTION", "PRICE", "CATEGORY");
        for (Product p : products) {
            System.out.printf("%10s | %20s | %30s | %20s | %10s \n",
                    p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getCategory());
        }
    }
}
