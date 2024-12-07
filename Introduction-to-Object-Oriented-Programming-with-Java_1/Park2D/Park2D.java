public class Park2D {

    public static void main(String[] args) {
        double[][] array2D = {{80, 70, 75}, 
                              {69, 72, 74}};
        final double MIN_TEMP = 75;
        final double MAX_TEMP = 90;
        for (int row = 0; row < array2D.length; row++) {
            for (int col = 0; col < array2D[row].length; col++) {
                if ((array2D[row][col] >= MIN_TEMP) 
                    && (array2D[row][col] <= MAX_TEMP)) {
                        System.out.println("Go to the park.");
                }
            }
        }
    }
}