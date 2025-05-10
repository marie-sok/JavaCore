package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        productBasket.addProduct(new SimpleProduct("Milk", 98));
        productBasket.addProduct(new FixPriceProduct("Sugar"));
        productBasket.addProduct(new DiscountedProduct("Eggs", 130, 30));
        printSeparator();

        System.out.println("Add product to full cart");
        productBasket.addProduct(new SimpleProduct("Coffee", 597));
        printSeparator();

        System.out.println("Printing the contents with a few products");
        productBasket.printProductBasket();
        printSeparator();

        System.out.println("The amount of the check of the cart with a few products");
        System.out.println("Final costs of: " + productBasket.getSumOfProducts());
        System.out.println("Search for a product in the cart");
        String name = "Milk";
        System.out.println(name + " " + productBasket.checkProduct(name));
        printSeparator();

        System.out.println("Printing the contents before erase");
        productBasket.printProductBasket();
        productBasket.cleanBasket();
        printSeparator();

        System.out.println("Printing of the empty cart");
        productBasket.printProductBasket();
        printSeparator();

        System.out.println("Price of the empty cart");
        productBasket.printProductBasket();
        System.out.println("Final costs of the cart: " + productBasket.getSumOfProducts());
        printSeparator();

        System.out.println("Search for a product in the empty cart");
        name = "Soda";
        System.out.println(name + " " + productBasket.checkProduct(name));
    }

    public static void printSeparator() {
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
    }
}