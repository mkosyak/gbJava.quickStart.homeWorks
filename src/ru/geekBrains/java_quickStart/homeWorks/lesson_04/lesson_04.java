package ru.geekBrains.java_quickStart.homeWorks.lesson_04;

import java.util.Scanner;

public class lesson_04 {

    //  initialization global variables
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//
        System.out.println("--== Игра 'Угадай чило' ==--");
        System.out.println("Ваша задача угадать число.'");

        int range = 30;
        int number = (int) (Math.random() * range);

        guessNum(range, number); // Run the guessing

        scanner.close();
    }

    private static void guessNum(int ii_range, int ii_number) {
        while (true) {
            System.out.println("Веедите число от '0' до '" + ii_range + "'");
            int input_number = scanner.nextInt();
            if (input_number == ii_number) {
                System.out.println(" ==== Вы Угадали !!!! =====");
                return;
            } else if (input_number < ii_number) {
                System.out.println("введенное значение меньше загаданного...");
            } else {
                System.out.println("введенное значение больше загаданного...");
            }

        }

    }
}
