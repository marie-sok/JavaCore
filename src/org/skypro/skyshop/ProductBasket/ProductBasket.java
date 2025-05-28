package org.skypro.skyshop.ProductBasket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;


public class ProductBasket {
    private final Product[] basket = new Product[3];

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Unable to add product to basket - basket is full");
    }

    public double getSumOfProducts() {
        double sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    private boolean basketIsNotEmpty() {
        for (Product product : basket) {
            if (product != null) {
                return true;
            }
        }
        return false;
    }

    public void printProductBasket() {
        int specialGoods = 0;
        double sum = 0;
        boolean isEmpty = true;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                isEmpty = false;
                sum += product.getPrice();
                if (product.isSpecial()) {
                    specialGoods++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("The basket is empty");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.printf("Total: %.2f ₽\n", sum);
            System.out.printf("Special goods: %d\n", specialGoods);
        }
    }

    public boolean checkProduct(String name) {
        for (Product product : basket) {
            if (product != null && Objects.equals(product.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        if (!ProductInBasket()) {
            System.out.println("The basket is empty");
            return;
        }
        for (Product product : basket) {
            if (product != null) {
                System.out.println(getSumOfProducts());
            }
        }
    }

    private boolean ProductInBasket() {
        return false;
    }
}
