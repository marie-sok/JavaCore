package org.skypro.skyshop;

import org.skypro.skyshop.ProductBasket.ProductBasket;
import org.skypro.skyshop.BestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.*;
import org.skypro.skyshop.SearchEngine.SearchEngine;

import java.util.List;


public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("PopSocket", 530);
        Product product2 = new FixPriceProduct("USB-C Cable");
        Product product3 = new DiscountedProduct("Earphones", 4500, 30);
        Product product4 = new SimpleProduct("Adapter", 700);

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product3);
        printSeparator();

        System.out.print(new StringBuilder()
                .append("Delete basket\n")
                .append("Print the content\n\n"));
        productBasket.printProductBasket();


        System.out.println(new StringBuilder("\nDelete Product - PopSocket"));
        productBasket.deleteProductsByName("PopSocket");
        productBasket.printDeletedProducts();
        System.out.println();
        productBasket.printProductBasket();

        System.out.println(new StringBuilder("\nDelete product - Tralalelo Tralala"));
        productBasket.deleteProductsByName("Delete product - Tralalelo Tralala");
        productBasket.printDeletedProducts();
        System.out.println();
        productBasket.printProductBasket();
        printSeparator();

        System.out.println(new StringBuilder("Print the contents with a few product"));
        productBasket.printProductBasket();
        printSeparator();

        System.out.println(new StringBuilder()
                .append("The costs of the basket with a few product\n")
                .append("Total price of the basket: ")
                .append(productBasket.getSumOfProducts()));
        printSeparator();


        String name = "HDMI Cable";
        System.out.println(new StringBuilder()
                .append("Search product that is in the basket\n")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();

        name = "Apple";
        System.out.println(new StringBuilder()
                .append("Search product that is not in the basket \n")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();

        System.out.println(new StringBuilder("Printing the contents before erase"));
        productBasket.printProductBasket();
        productBasket.cleanBasket();
        printSeparator();

        System.out.println(new StringBuilder("Printing of the empty cart"));
        productBasket.printProductBasket();
        printSeparator();

        System.out.println(new StringBuilder()
                .append("Price of the empty\n")
                .append("Total price of basket: ")
                .append(productBasket.getSumOfProducts()));
        printSeparator();

        name = "Keyboard";
        System.out.println(new StringBuilder()
                .append("Search a product by the name in the empty cart\n")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();


        System.out.println("The amount of the check of the cart with a few products");
        System.out.println("Final costs of: " + productBasket.getSumOfProducts());
        System.out.println("Search for a product in the cart");
        printSeparator();


        Article article1 = new Article("PopSocket.", "This is universal phoneholder that allows you to comfortably hold your device in your hand and it's also a stylish accessory.");
        Article article2 = new Article("USB-C Cable.", "No one has ever tied you to the power supply as much as I have.");
        Article article3 = new Article("Earphones.", "The new noise cancellation function isolates you into space from the surrounding world.");


        SearchEngine searchEngine = new SearchEngine();

        try {

            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(product3);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);
        } catch (IllegalArgumentException ex) {

            System.out.println(new StringBuilder("Error: " + ex.getMessage()));
            return;
        }

        String query = "Earphones";

        System.out.println(new StringBuilder()
                .append("Search Results ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));


        query = "Keyboard";
        System.out.println(new StringBuilder()
                .append("Search Results ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        query = "Case";
        System.out.println(new StringBuilder()
                .append("Search Results ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        query = "Sticker";
        System.out.println(new StringBuilder()
                .append("Search Results ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));


        System.out.println(new StringBuilder("Search result by name: "));

        List<Searchable> searchResults = searchEngine.search(query);
        for (Searchable searchResult : searchResults) {
            if (searchResult != null) {
                System.out.println(new StringBuilder()
                        .append("Name searchable: ")
                        .append(searchResult.getStringRepresentation()));
            }
        }


        System.out.println(new StringBuilder("Create no name SimpleProduct:"));
        try {
            Product product10 = new SimpleProduct(" ", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Error: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println("Create no name SimpleProduct :");
        try {
            Product product10 = new SimpleProduct("Popsocket", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        System.out.println(new StringBuilder("Create FixPriceProduct with incorrect name:"));
        try {
            Product product10 = new FixPriceProduct("  ");
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Error: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Create DiscountedProduct with incorrect name:"));
        try {
            Product product10 = new DiscountedProduct(" ", 500, 20);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Error: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Create DiscountedProduct with incorrect price:"));
        try {
            Product product10 = new DiscountedProduct("Earphones", 3300, 40);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Error: ")
                    .append(ex.getMessage())
                    .append("\n"));

        }
        System.out.println(new StringBuilder("Create DiscountedProduct with an incorrect discount: "));
        try {
            Product product10 = new DiscountedProduct("Earphones", 4500, 200);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Error: ")
                    .append(ex.getMessage())
                    .append("\n"));

        }

        printSeparator();


        Searchable bestResult;

        query = "riddle erudite";
        System.out.println(new StringBuilder()
                .append("Search of the best results for ")
                .append(query)
                .append("..."));
        try {
            bestResult = searchEngine.searchMostRelevant(query);
            System.out.println(new StringBuilder()
                    .append("Search results ")
                    .append(query)
                    .append(": ")
                    .append(bestResult));

        } catch (BestResultNotFound ex) {

            System.out.println(new StringBuilder()
                    .append("Error: ")
                    .append(ex.getMessage())
                    .append("\n"));

            query = "They say the cows were kidnapped by UFOs";
            System.out.println(new StringBuilder()
                    .append("Search of the best results for ")
                    .append(query)
                    .append(" "));
        }
        try {
            bestResult = searchEngine.searchMostRelevant(query);
            System.out.println(new StringBuilder()
                    .append("Search results ")
                    .append(query)
                    .append(": ")
                    .append(bestResult));
        } catch (BestResultNotFound ex) {
            System.out.println(new StringBuilder()
                    .append("Error: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }
    }

    public static void printSeparator() {

        System.out.println(new StringBuilder("\n____________________________________________________________________________\n"));

    }
}





