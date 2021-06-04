package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class zadanie2 {
    private static Scanner scanner = new Scanner(System.in, "cp1251");
    private static Info[] products = null;

    public static void main(String[] args) {
        InitProducts();

        System.out.println("\nПоследний товар с максимальным количеством единиц товаров:");
        System.out.println(GetMaxQuantity());

        System.out.println("\nСредняя цена товаров:");
        System.out.println(GetAverage());

        System.out.println("\nКоличество товаров с ценой ниже среднего");
        System.out.println(GetBelowAverageCount());

        Sort();
        System.out.println("\nОтсортированный список по цене:");
        for (Info currentProduct : products) {
            System.out.println(currentProduct.toString());
        }

        System.out.println("\nВведите название искомого товара => ");
        String name = scanner.nextLine();
        FindAndEdit(name);
    }

    private static void InitProducts() {
        System.out.println("Введите количество товаров: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        products = new Info[count];
        for (int i=0; i<count; i++)
            products[i] = new Info();

        System.out.println("Введите информацию о товаре: ");

        for (Info currentInfo : products) {
            System.out.println("Название товара: ");
            currentInfo.SetName(scanner.nextLine());
            System.out.println("Производитель товара: ");
            currentInfo.SetManufacturer(scanner.nextLine());
            System.out.println("Количество едениц: ");
            currentInfo.SetQuantity(scanner.nextInt());
            scanner.nextLine();
            System.out.print("\n");
            System.out.println("Цена товара: ");
            currentInfo.SetPrice(scanner.nextInt());
            scanner.nextLine();
            System.out.print("\n");
        }
    }

    private static Info GetMaxQuantity() {
        Info maxQuantity = products[0];
        for (Info currentProduct : products) {
            if (maxQuantity.GetQuantity() < currentProduct.GetQuantity())
                maxQuantity = currentProduct;
        }
        return maxQuantity;
    }
    private static double GetAverage() {
        double priceAccumulator = 0;
        for (Info currentProduct : products) {
            priceAccumulator += currentProduct.GetPrice();
        }
        return priceAccumulator / products.length;
    }
    private static double GetBelowAverageCount() {
        int belowAverageCount = 0;
        double averagePrice = GetAverage();
        for (Info currentProduct : products) {
            if (currentProduct.GetPrice() < averagePrice) {
                belowAverageCount++;
            }
        }
        return belowAverageCount;
    }

    private static void Sort() {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j].GetPrice() < products[j + 1].GetPrice()) {
                    Info temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }

    private static void FindAndEdit(String name) {
        int nom = -1; // -1 – товар с искомым названием отсутствует

        for (int i = 0; i < products.length; i++)
            if (name.equalsIgnoreCase(products[i].GetName()))
                nom = i;

        if (nom != -1) {
            System.out.println("Такой товар есть в списке. Это " + products[nom]);
            System.out.println("Введите новое количество товаров => ");
            products[nom].SetQuantity(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Новая информация по изменённому товару: " + products[nom]);
        } else {
            System.out.println("Такого товара нет в списке");
        }
    }
}
