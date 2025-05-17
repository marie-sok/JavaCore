package org.skypro.skyshop;

import org.skypro.skyshop.ProductBasket.ProductBasket;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("PopSocket", 530);
        Product product2 = new FixPriceProduct("USB-C Cable", 800);
        Product product3 = new DiscountedProduct("Earphones", 4500, 30);

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        printSeparator();

        System.out.println("Add product to full cart");
        productBasket.addProduct(new SimpleProduct("PopSocket", 530));
        printSeparator();

        System.out.println("Printing the contents with a few products");
        productBasket.printProductBasket();
        printSeparator();

        System.out.println("The amount of the check of the cart with a few products");
        System.out.println("Final costs of: " + productBasket.getSumOfProducts());
        System.out.println("Search for a product in the cart");

        String name = "HDMI Cable";
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
        name = "Keyboard";
        System.out.println(name + " " + productBasket.checkProduct(name));
        printSeparator();

        Article article1 = new Article("PopSocket.", "This is universal phoneholder that allows you to comfortably hold your device in your hand and it's also a stylish accessory.");
        Article article2 = new Article("USB-C Cable.","No one has ever tied you to the power supply as much as I have.");
        Article article3 = new Article("Earphones.", "The new noise cancellation function isolates you into space from the surrounding world.");


        SearchEngine searchEngine = new SearchEngine(6);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        String query = "Earphones";
        Searchable[] searchResults = searchEngine.search(query);
        System.out.println("Search Results " + query + ": " + Arrays.toString(searchResults));

        query = "Keyboard";
        searchResults = searchEngine.search(query);
        System.out.println("Search Results " + query + ": " + Arrays.toString(searchResults));

        query = "Case";
        searchResults = searchEngine.search(query);
        System.out.println("Search Results " + query + ": " + Arrays.toString(searchResults));

        query = "Sticker";
        searchResults = searchEngine.search(query);

        System.out.println("Search Results " + query + ": " + Arrays.toString(searchResults));

        System.out.println();

        System.out.println("Search result by name: ");

        for (Searchable searchResult : searchResults) {
            if (searchResult != null) {
                System.out.println("Name searchable: " + searchResult.getStringRepresentation());
            }
        }
    }

    public static void printSeparator() {
    }
}

