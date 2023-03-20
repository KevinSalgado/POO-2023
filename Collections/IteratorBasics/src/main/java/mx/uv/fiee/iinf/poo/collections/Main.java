package mx.uv.fiee.iinf.poo.collections;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String [] args) {
        var filmVector = new Film [10];

        var myCol = new MyMarvelCollection (filmVector);
        myCol.add (new Film ("Ironman", 2008));
        myCol.add (new Film ("Captain America", 2010));
        myCol.add (new Film ("The Avengers", 2012));

        try {
            for (int i = 0; i < myCol.size (); i++) {
                System.out.println (myCol.get (i).toString ());
            }
        } catch (ArrayIndexOutOfBoundsException | NoSuchElementException ex) {}
    }

}
