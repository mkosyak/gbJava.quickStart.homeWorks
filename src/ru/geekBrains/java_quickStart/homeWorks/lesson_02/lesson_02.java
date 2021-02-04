package ru.geekBrains.java_quickStart.homeWorks.lesson_02;

import java.util.Scanner;

public class lesson_02 {
    public static void main(String[] args) {
// Step 1
//	    System.out.println("Введите числоЖ");
//        Scanner scanner = new Scanner(System.in);
//	    int a = scanner.nextInt();
//        System.out.println("a = " + a);
//

// Step 2. Simple calculator:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Простейший калькулятор 2-х целых чисел:");
        System.out.println("    1 = Сложение");
        System.out.println("    2 = Вычитание");
        System.out.println("    3 = Умножение");
        System.out.println("    4 = Деление");
        System.out.println("-- Введите код действия:");
        int oper = scanner.nextInt();
        int result;

        if (oper <= 4){
            System.out.println("-- Введите первое число:");
            int a = scanner.nextInt();

            System.out.println("-- Введите второе число:");
            int b = scanner.nextInt();

            if (oper == 1) {
                result = a + b;
            }
            else if (oper == 2) {
                result = a - b;
            }
            else if (oper == 3 ) {
                result = a * b;
            }
            else if (oper == 4 ) {
                result = a / b;
            }
            else {
                System.out.println("Несуществущий код операции: '" + oper +"'");
                return;
            }
        }
        else{
            System.out.println("Несуществущий код операции: '" + oper +"'");
            return;
        }

        System.out.println( "=== result = " + result);
    }
}
