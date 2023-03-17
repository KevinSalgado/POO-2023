package mx.uv.fiee.iinf.poo.collections;

public class Main {

    public static void main(String [] args) {
        var filmVector = new Film [10];
        var myCol = new MyMarvelCollection (filmVector);

        var iterator = myCol.iterator ();
        while (iterator.hasNext ()) {
            System.out.println (iterator.next ());
        }

        for (var film: myCol) {
            System.out.println (film);
        }
    }

}
