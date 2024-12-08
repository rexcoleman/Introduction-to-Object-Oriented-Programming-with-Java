public class Insect {

    // instance variables
    private double weight;
    private int x;
    private int y;

    // constructor
    public Insect(double initWeight, int initX, int initY) {
        weight = initWeight;
        x = initX;
        y = initY;
    }

    // test method
    public static void main(String[] args) {
        Insect buzz1 = new Insect();
        Insect buzz2 = new Insect();
    }
}