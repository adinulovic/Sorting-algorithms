import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static Scanner inputReader = new Scanner(System.in);

    static int parseStringToInt(String inputString) {
        int outputInt = 0;
        boolean flag = false;
        while(!flag) {
            try
            {
                outputInt = Integer.parseInt(inputString);
                flag = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(inputString + " is not a valid integer. Please try again: ");
                inputString = inputReader.nextLine();
            }
        }
        return outputInt; //to-do: check if not 0
    }

    public static void main(String[] args) {
        System.out.println("Bubblesort");

        System.out.println("Enter array size (int): ");
        int arraySize = parseStringToInt(inputReader.nextLine());

        System.out.println("Enter bottom of range (int): ");
        int rangeBottom = parseStringToInt(inputReader.nextLine());

        System.out.println("Enter top of range (int): ");
        int rangeTop = parseStringToInt(inputReader.nextLine());

        //fill array with random numbers
        Random rnd = new Random();
        int[] numbers = new int[arraySize];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = rnd.nextInt((rangeTop - rangeBottom) + rangeBottom);
            }
            System.out.println("Your random array: " + Arrays.toString(numbers));

            boolean swapped = true;
            int slot = 0;
            long startTime = System.nanoTime();
            while(swapped) {
                swapped = false;
                for(int i = 0; i < numbers.length-1; i++) {
                    if (numbers[i] > numbers[i+1]) {
                        slot = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = slot;
                        swapped = true;
                    }
                }
            }
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Your sorted array: " + Arrays.toString(numbers));
            System.out.println("Time elapsed: " + duration/1000000 + "ms" + "/" + duration + "ns");
    }
}
