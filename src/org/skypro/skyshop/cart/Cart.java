package org.skypro.skyshop.cart;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class Cart {
    private static final org.skypro.skyshop.product.Product[] cart = new Product[3];
    public static String getSumOfProducts;

    public static void addProduct(Product product) {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) {
                cart[i] = product;
                return;
            }
        }

        System.out.println("Unable to add product to cart");

    }

    public static double getSumOfProducts() {
        double sum = 0;
        for (Product product : cart) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    private static boolean productInCart() {
        for (Product product : cart) {
            if (product != null) {
                return true;
            }
        }
        return false;
    }
    public static void printCart(){
        if(productInCart()){
            for (Product product : cart){
                if (product != null) {
                    System.out.println(getSumOfProducts());
                } else {
                    System.out.println("The cart is empty");
                }
            }
        }
    }
    public boolean checkProduct(String name){
        for(Product product : cart){
            if(product != null && Objects.equals(product.getName(),name)){
                return true;
            }
        }
        return false;
    }
    public void eraseCart(){
        for (int i = 0; i < cart.length;i++){
            if(cart[i] != null){
                cart[i] = null;
            }
        }
    }
}




