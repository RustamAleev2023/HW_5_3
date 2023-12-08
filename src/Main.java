import java.util.*;


public class Main {
    public static void main(String[] args) {

//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
//        task12();

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
        System.out.println("Введите размер квадратного массива");
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
        System.out.println("Введите размер квадратного массива");
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
        System.out.println("Введите размер квадратного массива");
        int n = scanner.nextInt();
        int[][] numbers = new int[n][n];

        int iStart = 0;
        int iEnd = 0;
        int jStart = 0;
        int jEnd = 0;
        int i = 0;
        int j = 0;
        int counter = 1;

        //очерчиваем прямоугольники, каждый из которых на единицу меньше с каждой стороны
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

    //Task9
    public static void task9() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите высоту массива");
        int n = scanner.nextInt();
        System.out.println("Введите ширину массива");
        int m = scanner.nextInt();

        int[][] numbers = new int[n][m];

        int value = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                numbers[i][j] = value++;
            }
        }

//        printArray(numbers);
//        System.out.println();
        printArray(diagonal(numbers));

    }

    static int[][] diagonal(int[][] input) {

        final int numRows = input.length;
        final int numColumns = input[0].length;
        int[][] result = new int[numRows][numColumns];

        int rowIndex = 0;
        int columnIndex = 0;

        int currentRow = 0;
        int currentColumn = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                result[currentRow][currentColumn] = input[i][j];
                //если наша текущая строка находится внизу, мы должны проверить,
                // следует ли нам перейти наверх или пройти вправо
                if (currentRow == numRows - 1) {

                    if (numRows < numColumns && columnIndex < numColumns - 1) {
                        //передвигаем текущую строку вниз на линию
                        currentRow = 0;
                        //сбрасываем столбцы направо
                        currentColumn = ++columnIndex;
                    }

                    //если квадратный массив, то используем rowIndex
                    else {
                        //передвигаем текущую строку вниз на линию
                        currentRow = ++rowIndex;
                        //сбрасываем столбцы направо
                        currentColumn = numColumns - 1;
                    }
                }
                //проверяем что достигли левого края
                else if (currentColumn == 0) {
                    //можем переместить columnIndex правее
                    if (columnIndex < numColumns - 1) {
                        currentRow = rowIndex;
                        currentColumn = ++columnIndex;
                    }

                    //мы у правого края поэтому перемещаемся ниже
                    else {
                        currentColumn = columnIndex;
                        currentRow = ++rowIndex;
                    }
                }
                //иначе мы дем вниз и налево по диагонали
                else {
                    currentRow++;
                    currentColumn--;
                }

            }
        }
        return result;
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Task10
    public static void task10() {
        Scanner scanner = new Scanner(System.in);
//        int n = 4;
//        int m = 6;
        System.out.println("Введите кол-во рядов");
        int n = scanner.nextInt();
        System.out.println("Введите кол-во мест в ряду");
        int m = scanner.nextInt();

        System.out.println("Введите кол-во билетов (не более " + m + ")");
        int k = scanner.nextInt();

        int[][] numbers = new int[n][m];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                numbers[i][j] = random.nextInt(2);
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("===========================================");

        if (!isAvailable(k, numbers)) {
            System.out.println("Вы не сможете сесть рядом ни в одном ряду");
        }

    }

    public static boolean isAvailable(int k, int[][] numbers) {
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            if (rowHasNextKFreePlaces(k, numbers[i], i + 1)) {
                result = true;
            }
        }
        return result;
    }

    public static boolean rowHasNextKFreePlaces(int k, int[] numbers, int row) {
        int count = 0;
        int groupCount = 0;
        int start = -1;
        int end = -1;
        boolean result = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
                if (count == k) {
                    groupCount++;
                    start = i - (k - 1);
                    end = i;
                    result = true;
                }
                if (count > k) {
                    end = i;
                }
            } else {
                count = 0;
            }
        }
        if (groupCount != 0) {
            System.out.println("В " + row + " ряду вы можете занять места с " + (start + 1) + " по " + (end + 1));
        }
        return result;
    }

    //Task11
    public static String zero = "ноль";
    public static String[] dig1 = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    public static String[] dig10  = {"десять","одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    public static String[] dig20  = {"двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    public static String[] dig100 = {"","сто","двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    public static String[] dig1000 = {"тысяч", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч"};
    public static String million = "один миллион";

    public static void task11() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число в диапазоне от 0 до 1 000 000 включительно");
        int number = scanner.nextInt();

        if (number == 1_000_000) {
            System.out.println(million);
        } else if (number == 0) {
            System.out.println(zero);
        } else {
            System.out.println(generate(number).trim());
        }


    }

    //конвертируем в текст с помощью рекурсии
    public static String generate(int number) {
        if (number > 0 && number < 100) {
            return generate1To99(number);
        } else if (number >= 100 && number < 1000) {
            return dig100[number / 100] + " " + generate1To99(number % 100);
        } else if (number >= 1000 && number < 10_000) {
            return dig1000[number / 1000] + " " + generate(number % 1000);
        } else if (number >= 10_000 && number < 20_000) {
            return generate(number / 1_000) + " тысяч " + generate(number % 1000);
        } else if (number >= 20_000 && number < 100_000) {
            return dig20[number / 10_000 - 2] + " " + dig1000[(number % 10_000) / 1_000] + " " + generate(number % 1000);
        } else if (number >= 100_000) {
            if (((number / 1_000) % 100) / 10 >= 2) {//(20_000-99_999)+(100_000 - 900_000)
                return dig100[number / 100_000] + " " + dig20[((number / 1_000) % 100) / 10 - 2]
                        + " " + dig1000[((number / 1_000) % 100) % 10] + " " + generate(number % 1000);
            } else if (((number / 1_000) % 100) / 10 == 1) {//(10_000-19_999)+(100_000 - 900_000)
                return dig100[number / 100_000] + " " + dig10[((number / 1_000) % 100) % 10] + " тысяч " + generate(number % 1000);
            } else {//(0-9_999)+(100_000 - 900_000)
                return dig100[number / 100_000] + " " + dig1000[(number % 10_000) / 1_000] + " " + generate(number % 1000);
            }

        } else return generate1To99(number);

    }

    public static String generate1To99(int number) {
        if (number == 0) {
            return "";
        }
        if (number <= 9) {
            return dig1[number - 1];
        } else if (number <= 19) {
            return dig10[number % 10];
        } else {
            return dig20[number / 10 - 2] + " " + generate1To99(number % 10);
        }
    }



    //Task12

    //Комбинации возможных вариантов хода "конем"
    public static int[] row = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
    public static int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
    public static int n;

    public static void task12(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Программа выводит в консоль все возможные варианты перемещения, \n" +
                "все они начинаются с позиции(0,0), но далее могут идти по разным путям." +
                "\nПоэтому чем длиннее сторона поля - тем больше возможных комбинаций " +
                "\nи тем больше времени потребуется на перебор и вывод всех вариантов\n");
        System.out.println("Введите размер стороны поля");
        n = scanner.nextInt();

        //создаем поле
        int[][] map = new int[n][n];

        //заполняем поле нулями
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }
        //начинаем заполнять с 1
        int count = 1;

        //начинаем заполнение с ячейки (0, 0)`
        move(map, 0, 0, count);
    }

    // Проверяем, что координаты попадают внутрь поля
    private static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n){
            return false;
        }

        return true;
    }

    //Метод вывода в консоль
    private static void print(int[][] map){
        for (var r: map) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
    }


    //Рекурсивный метод передвижения "ходом коня" c использованием возврата при занятой следующей(следующих) ячейки
    public static void move(int[][] map, int x, int y, int count){
        // заполняем текущую ячейку текущим значением счетчика
        map[x][y] = count;

        // если все ячейки заполнены - печатаем массив
        if (count >= n * n) {
            print(map);
//            map[x][y] = 0;
//            return;
        }

        //последовательно перебираем все восемь возможных "ходов конем" на их валидность
        for (int k = 0; k < 8; k++){

            //получаем координаты следующей ячейки
            int newX = x + row[k];
            int newY = y + col[k];

            //проверяем, что следующая ячейка находится в поле и она не заполнена
            if (isValid(newX, newY) && map[newX][newY] == 0) {
                move(map, newX, newY, count + 1);
            }
        }

        //откатываемся назад из текущего положения
        map[x][y] = 0;
    }

}