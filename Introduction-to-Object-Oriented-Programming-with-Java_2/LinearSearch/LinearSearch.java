import java.util.Random;

public class LinearSearch {
    public static <T extends Comparable<T>> int linearSearch(T target, T[] list) {
        int index = 0;
        while (index < list.length) {
            if (list[index].compareTo(target) == 0)
                return index;
            else
                index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[1000000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }
        
        Integer target = numbers[500000];
        int result = linearSearch(target, numbers);
        System.out.println("Found " + target + " at index " + result);
    }
}