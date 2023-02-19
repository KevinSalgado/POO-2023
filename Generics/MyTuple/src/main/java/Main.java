public class Main {

    public static void main (String [] args) {
        var tuple = new MyTuple (1, 2);

        System.out.printf ("Item -> %s%n", tuple.getItem1 ());
        System.out.printf ("Item -> %s%n", tuple.getItem2 ());
    }

}
