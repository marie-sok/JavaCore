
package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        productBasket.addProduct(new Product("Milk", 98));
        productBasket.addProduct(new Product("Sugar", 54));
        productBasket.addProduct(new Product("Eggs", 130));

        System.out.println("Add product to full basket");
        productBasket.addProduct(new Product("Coffee", 597));
        line();

        System.out.println("Printing the contents with a few products");
        productBasket.printProductBasket();
        line();

        System.out.println("The amount of the check of the basket with a few products");
        System.out.println("Final costs of: " + productBasket.getSumOfProducts());
        line();

        System.out.println("Search for a product in the basket");
        String name = "Milk";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        line();

        System.out.println("Printing the contents before clean");
        productBasket.printProductBasket();
        productBasket.cleanBasket();
        line();

        System.out.println("Printing of the empty basket");
        productBasket.printProductBasket();
        line();

        System.out.println("Price of the empty basket");
        System.out.println("Final costs of the products: " + productBasket.getSumOfProducts());
        line();

        System.out.println("Search for a product in the empty basket");
        name = "Soda";
        System.out.println(name + " - " + productBasket.checkProduct(name));
    }

    public static void line() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
    }
}