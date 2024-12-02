package com.example.java_lab8;

public class ShopAPP {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        productDAO.addProduct("", 4000.50, 7);

        productDAO.getProductById(1);

        productDAO.updateProduct(1, "Iphone X pro", 5000.99, 12);

        productDAO.deleteProduct(1);
    }
}