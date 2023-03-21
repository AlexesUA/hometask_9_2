
//Завдання 2
//
//Використовуючи IntelliJ IDEA, створіть клас CustomerArray.
//Створити масив розміру N-елементів, заповнити його довільними цілими значеннями
//(розмір масиву задає користувач). Вивести на екран: найбільше значення масиву,
//найменше значення масиву, загальну суму всіх елементів, середнє арифметичне всіх елементів, вивести всі непарні значення.

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scInput = new Scanner(System.in);


        int arrayCount;
        do{
            System.out.print("Введіть розмір масива: ");
            arrayCount = scInput.nextInt();
            if(arrayCount<=0) System.out.println("Розмір масива не може бути менше або дорівнювати 0.");
            else break;

        }while(true);

        int[] arrayNumbers = CreateArray(arrayCount);

        PrintArray(arrayNumbers);

        System.out.println("Найбільше значення масиву: " + FindMaxNumbers(arrayNumbers));

        System.out.println("Найменше значення масиву: " + FindMinNumbers(arrayNumbers));

        System.out.println("Сумма всіх елементів масиву: " + SummAllElementsArray(arrayNumbers));

        System.out.println("Середнє арифметичне всіх елементів масиву: " +
                ArithmeticMeansArray(SummAllElementsArray(arrayNumbers), arrayCount));

        PrintOddElements(arrayNumbers);
    }

    static void PrintArray(int[] arrayNumbers){
        int clock = 10;
        System.out.println("Масив: ");
        for (int i = 0; i < arrayNumbers.length; i++){
            System.out.print(arrayNumbers[i] + " ");
            clock--;
            if(clock<=0) {clock = 10; System.out.println();}

        }
        System.out.println();
    }
    static int[] CreateArray(int arrayCount){
        Random rndNumber = new Random();
        int[] tempArrayNumbers = new int[arrayCount];

        for (int i=0; i<arrayCount; i++){
            tempArrayNumbers[i] = rndNumber.nextInt(1,100);
        }

        return tempArrayNumbers;
    }

    static int FindMinNumbers(int[] arrayNumbers){
        int minNum = arrayNumbers[0];
        for(int i = 1; i < arrayNumbers.length; i++){
            if(minNum > arrayNumbers[i]) minNum = arrayNumbers[i];
        }

        return minNum;
    }

    static int FindMaxNumbers(int[] arrayNumbers){
        int maxNum = arrayNumbers[0];
        for(int i = 1; i < arrayNumbers.length; i++){
            if(maxNum < arrayNumbers[i]) maxNum = arrayNumbers[i];
        }

        return maxNum;
    }

    static int SummAllElementsArray(int[] arrayNumbers){
        int sumElements = arrayNumbers[0];
        for(int i = 1; i < arrayNumbers.length; i++){
            sumElements += arrayNumbers[i];
        }
        return  sumElements;
    }

    static double ArithmeticMeansArray(int summAllElements, int arrayCount) {
        return  (double)summAllElements / arrayCount;
    }

    static void PrintOddElements(int[] arrayNumbers){
        int clock = 10;
        System.out.println("Всі непарні елементи масива: ");
        for (int i = 1; i < arrayNumbers.length; i+=2){
            System.out.print(arrayNumbers[i] + " ");
            clock--;
            if(clock<=0) {clock = 10; System.out.println();}
        }

        System.out.println();
    }

}