package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class zadanie1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp1251");

        System.out.println("Введите количество товаров: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Info[] products = new Info[count];
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

        //Товары с максимальным количесвтом едениц
        Info maxQuantity = products[0];
        for (Info currentProduct : products) {
            if (maxQuantity.GetQuantity()<currentProduct.GetQuantity())
                maxQuantity = currentProduct;
        }
        System.out.println("\nПоследний товар с максимальным количеством единиц товаров:");
        System.out.println(maxQuantity);

        //Определить среднюю цену товаров и количество товарова с ценой ниже средней
        double priceAccumulator = 0;
        for (Info currentProduct : products) {
            priceAccumulator += currentProduct.GetPrice();
        }
        double averagePrice = priceAccumulator/products.length;
        int belowAverageCount = 0;
        for (Info currentProduct : products) {
            if (currentProduct.GetPrice() < averagePrice) {
                belowAverageCount++;
            }
        }
        System.out.println("\nСредняя цена товаров:");
        System.out.println(averagePrice);
        System.out.println("\nКоличество товаров с ценой ниже среднего");
        System.out.println(belowAverageCount);

        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j].GetPrice() < products[j + 1].GetPrice()) {
                    Info temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
        System.out.println("\nОтсортированный список по цене:");
        for (Info currentProduct : products) {
            System.out.println(currentProduct.toString());
        }

        System.out.println("\nВведите название искомого товара => ");
        String name = scanner.nextLine();
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
