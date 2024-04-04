package com.cg.service;

import com.cg.model.ECategory;
import com.cg.model.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("./data/products.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                // line : 1,Iphone 11,1000000,IPHONE
                String[] items = line.split(",");
                Product p = new Product();
                p.setId(Integer.parseInt(items[0]));
                p.setName(items[1]);
                p.setPrice(Double.parseDouble(items[2]));
                p.setCategory(ECategory.findECategoryBy(items[3]));
                products.add(p);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return products;
    }
}
