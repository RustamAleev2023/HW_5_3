import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
        task8();
    }

    //Task1
    public static void task1() {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * i;
            System.out.print(numbers[i] + " ");
        }
    }

    //Task2
    public static void task2() {
        int[] numbers = new int[20];
        int sum = 0;
        Random random = new Random();
        int indexOfFirstNegativeNumber = 0;


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-10, 30);
            System.out.println(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                indexOfFirstNegativeNumber = i;
                break;
            }
        }

        for (int i = indexOfFirstNegativeNumber + 1; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("Сумма = " + sum);

    }

    //Task3
    public static void task3() {
        int[] numbers = new int[200];
        Random random = new Random();
        int digit1 = 0;
        int digit2 = 0;
        int digit3 = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(200);
            System.out.println(numbers[i]);
            if (numbers[i] / 100 != 0) {
                digit3++;
            } else if (numbers[i] / 10 != 0) {
                digit2++;
            } else {
                digit1++;
            }
        }

        System.out.println("digit 1 = " + digit1);
        System.out.println("digit 2 = " + digit2);
        System.out.println("digit 3 = " + digit3);
    }

    //Task4
    public static void task4() {
        int[] numbers = new int[100];
        Random random = new Random();


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-300, 555);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int[] result = new int[100];

        int count = 0;

        int k1 = 0;
        while (k1 < numbers.length) {
            if (numbers[k1] > 0) {
                result[count] = numbers[k1];
                count++;
            }
            k1++;
        }

        int k2 = 0;
        while (k2 < numbers.length) {
            if (numbers[k2] == 0) {
                result[count] = numbers[k2];
                count++;
            }
            k2++;
        }
        int k3 = 0;
        while (k3 < numbers.length) {
            if (numbers[k3] < 0) {
                result[count] = numbers[k3];
                count++;
            }
            k3++;
        }
        for (int i1 = 0; i1 < result.length; i1++) {
            System.out.print(result[i1] + " ");
        }
    }

    public static void task5() {

        int indexStartBest = -1;
        int lengthBest = 0;
        int indexStartCurrent = -1;
        int lengthCurrent = 0;

        int[] numbers = new int[20];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-10, 20);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (lengthCurrent == 0)
                    indexStartCurrent = i;
                lengthCurrent++;
            }

            if (numbers[i] <= 0 || i == numbers.length - 1) {
                if (lengthCurrent > lengthBest) {
                    indexStartBest = indexStartCurrent;
                    lengthBest = lengthCurrent;
                }
                lengthCurrent = 0;
            }
        }

        System.out.println("Максимальная длина = " + lengthBest);

        int[] result = new int[lengthBest];
        int count = 0;
        for (int i = indexStartBest; i < indexStartBest + lengthBest; i++) {
            result[count] = numbers[i];
            System.out.print(result[count] + " ");
            count++;
        }
        System.out.println();
    }

    //Task6
    public static void task6() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввести размер квадратного массива");
        int n = scanner.nextInt();
        int min = 0;
        int max = 0;

        Random random = new Random();
        int[][] numbers = new int[n][n];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                numbers[i][j] = random.nextInt();
                System.out.print(numbers[i][j] + " ");
                if (numbers[i][j] < min) {
                    min = numbers[i][j];
                }
                if (numbers[i][j] > max) {
                    max = numbers[i][j];
                }
            }
            System.out.println();
        }

        int temp = numbers[0][0];

        long startTime = System.nanoTime();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] < min) {
                    min = numbers[i][j];
                }
                if (numbers[i][j] > max) {
                    max = numbers[i][j];
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (!(i == 0 && j == 0)) {
                    if (numbers[i][j] == temp) {
                        System.out.println("Строка: " + i + " Столбец: " + j);

                    }
                }
            }
        }

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);

        long finishTime = System.nanoTime();

        System.out.println("Время выполнения поиска = " + (finishTime - startTime) + "нс");

    }

    //Task7
    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввести размер квадратного массива");
        int n = scanner.nextInt();
        int[][] numbers = new int[n][n];

        //нечетные строки - обратный порядок заполнения
        for (int i = 0, m = n * n; i < m; ) {
            int row = i / n;
            int col = row % 2 == 0 ? i % n : n - 1 - i % n;
            numbers[row][col] = ++i;
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Task8
    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввести размер квадратного массива");
        int n = scanner.nextInt();
        int[][] numbers = new int[n][n];
        //очерчиваем прямоугольники, каждый их которых на единицу меньше с каждой стороны
        int iStart = 0;
        int iEnd = 0;
        int jStart = 0;
        int jEnd = 0;
        int i = 0;
        int j = 0;
        int counter = 1;

        while (counter <= n * n) {
            numbers[i][j] = counter;
            if (i == iStart && j < (n - jEnd - 1)) {
                ++j;
            } else if (j == (n - jEnd - 1) && i < (n - iEnd - 1)) {
                ++i;
            } else if (i == (n - iEnd - 1) && j > jStart) {
                --j;
            } else {
                --i;
            }
            if ((i == iStart + 1) && (j == jStart) && (jStart != (n - jEnd - 1))) {
                ++iStart;
                ++iEnd;
                ++jStart;
                ++jEnd;
            }
            ++counter;
        }
        for (int i1 = 0; i1 < numbers.length; i1++) {
            for (int j1 = 0; j1 < numbers[0].length; j1++) {
                System.out.print(numbers[i1][j1] + "\t");
            }
            System.out.println();
        }
    }

}