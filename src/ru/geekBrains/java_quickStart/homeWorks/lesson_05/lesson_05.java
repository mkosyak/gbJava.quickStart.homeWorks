package ru.geekBrains.java_quickStart.homeWorks.lesson_05;

import java.util.Scanner;

public class lesson_05 {


    //  initialization global variables
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--== Игра 'Угадай чило' ==--");
        System.out.println("Ваша задача угадать число.'");

        for (int i = 10; i <= 30; i += 10) {

            guessNum(i); // Run the guessing

        }
        scanner.close();
    }

    private static void guessNum(int ii_range) {

        System.out.println('\n' + "УРОВЕНЬ " + ii_range / 10);
        System.out.println("---------------------------");

        int number = (int) (Math.random() * ii_range);

        while (true) {
            System.out.println("Веедите число от '0' до '" + ii_range + "'");
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println(" ==== Вы Угадали !!!! =====");
                return;
            } else if (input_number < number) {
                System.out.println("введенное значение меньше загаданного...");
            } else {
                System.out.println("введенное значение больше загаданного...");
            }

        }

    }

}
