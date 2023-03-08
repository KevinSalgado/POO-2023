package mx.uv.fiee.iinf.poo;

public class Main {

    public static void main (String [] args) {
        Circle circle1 = new Circle (10, 10, 20);
        Circle circle2 = new Circle (15, 15, 21);
        
        int resultCircles = circle1.compareTo (circle2);
        
        Rectangle rec1 = new Rectangle (10, 10, 20, 20);
        Rectangle rec2 = new Rectangle (30, 30, 50, 50);
        
        int resultRecs = rec1.compareTo (rec2);
    }

}







