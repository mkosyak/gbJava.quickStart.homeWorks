package ru.geekBrains.java_quickStart.homeWorks.lesson_03;

import java.util.Scanner;

public class lesson_03 {
    public static void main(String[] args) {
//  initialization
        Scanner scanner = new Scanner(System.in);
//
        System.out.println("--== Игра 'Угадай чило' ==--");
        System.out.println("Ваша задача угадать число.'");

        int range = 30;
        int number = (int) (Math.random() * range);
        while( true ) {
            System.out.println("Веедите число от '0' до '" + range + "'");
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println(" ==== Вы Угадали !!!! =====");
                break;
            }
            else if ( input_number < number) {
                System.out.println("введенное значение меньше...");
            }
            else {
                System.out.println("введенное значение больше...");
            }

        }
        scanner.close();
    }

}
