public class HelloWorldLoop {
    public static void main(String[] args) {
        int lineNum = 1;
        do {
            System.out.println("Hello, World! " + lineNum);
            lineNum ++;
        } while (lineNum <= 10); 
    }
}