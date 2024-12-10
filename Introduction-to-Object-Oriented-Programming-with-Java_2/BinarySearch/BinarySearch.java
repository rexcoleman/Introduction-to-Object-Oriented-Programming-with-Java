import java.util.Random;
import java.util.Arrays;

public class BinarySearch {

    public static <T extends Comparable<T>> int binarySearch(T[] list, T target) {
        int start = 0, end = list.length - 1, mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            if (list[mid].compareTo(target) ==0)
                return mid;
            else if (target.compareTo(list[mid]) < 0)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[1000000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }
        
        Arrays.sort(numbers);
        Integer target = rand.nextInt(1000000);
        int result = binarySearch(numbers, target);
        if (result != -1) {
            System.out.println("Successfully found " + target + " at index " + result);
            // Verify our result is correct
            System.out.println("Verification: number at index " + result + " is " + numbers[result]);
        } else {
            System.out.println("Did not find " + target + " in the array");
        }

    }

    
}