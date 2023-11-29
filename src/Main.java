import java.util.Random;

public class Main {
    public static void main(String[] args) {

//        task1();
//        task2();
//        task3();
        task4();
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
    public static void task4(){
        int[] numbers = new int[10];
        Random random = new Random();


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-300, 555);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int[] result = new int[10];

        int count = 0;

        int k1 = 0;
        while(k1 < numbers.length){
            if(numbers[k1] > 0){
                result[count] = numbers[k1];
                count++;
            }
            k1++;
        }

        int k2 = 0;
        while(k2 < numbers.length){
            if(numbers[k2] == 0){
                result[count] = numbers[k2];
                count++;
            }
            k2++;
        }
        int k3 = 0;
        while(k3 < numbers.length){
            if(numbers[k3] < 0){
                result[count] = numbers[k3];
                count++;
            }
            k3++;
        }
        for (int i1 = 0; i1 < result.length; i1++) {
            System.out.print(result[i1] + " ");
        }

    }

}