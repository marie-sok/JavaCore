package org.skypro.skyshop;

import org.skypro.skyshop.cart.Cart;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Cart.addProduct(new Product("Milk", 98));
        Cart.addProduct(new Product("Sugar", 54));
        Cart.addProduct(new Product("Eggs", 130));

        System.out.println("Add product to full cart");
        Cart.addProduct(new Product("Coffee", 597));
        Cart.printCart();
        line();

        System.out.println("Printing the contents with a few products");
        Cart.printCart();
        line();

        System.out.println("The amount of the check of the cart with a few products");
        System.out.println("Final costs of: " + Cart.getSumOfProducts());

        System.out.println("Search for a product in the cart");
        String name = "Milk";
        System.out.println(name + " " + cart.checkProduct(name));
        line();

        System.out.println("Printing the contents before erase");
        cart.printCart();
        cart.eraseCart();
        line();

        System.out.println("Printing of the empty cart");
        cart.printCart();
        line();

        System.out.println("Price of the empty cart");
        cart.printCart();
        System.out.println("Final costs of the cart: " + Cart.getSumOfProducts());
        line();

        System.out.println("Search for a product in the empty cart");
        name = "Soda";

        System.out.println(name + " " + cart.checkProduct(name));

    }

    public static void line() {
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

    }
}
