package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private static final Product [] basket = new Product[3];
    public static String getSumOfProducts;

    public static void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }

        System.out.println("Unable to add product to cart");

    }

    public static double getSumOfProducts() {
        double sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public static boolean productInBasket() {
        for (Product product : basket) {
            if (product != null) {
                return true;
            }
        }
        return false;
    }
    public static void printProductBasket(){
        if(productInBasket()){
            for (Product product : basket){
                if (product != null) {
                    System.out.println(getSumOfProducts());
                } else {
                    System.out.println("The cart is empty");
                }
            }
        }
    }


    public boolean checkProduct(String name){
        for(Product product : basket){
            if(product != null && Objects.equals(product.getName(),name)){
                return true;
            }
        }
        return false;
    }
    public void cleanBasket(){
        if(!productInBasket()){
            System.out.println("The basket is empty");
            return;
            }
        for(Product product: basket){
            if (product != null){
                System.out.println(getSumOfProducts());
            }
        }
    }
}

