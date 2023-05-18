package mx.uv.fiee.iinf.poo.demos.concurrentcollections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/***
 * only locks certain methods like add, avoiding 2 threads can insert items at same time,
 * but no sync iterator
 */
public class Wrappers {
    private List<Integer> list = Collections.synchronizedList (new ArrayList<> ());
    
    public Wrappers () {
        for (int i = 0; i < 100_000; i++) {
            list.add (i);
        }
    }
    
    public void update () {
        Thread t1 = new Thread (() -> {
            for (int i = 100_000; i < 200_000; i++) {
                list.add (i);
            }
        });
        
        t1.start ();
    }
    
    public void runIterator () {
        Thread t2 = new Thread (() -> {
            //synchronized (list) {
                ListIterator<Integer> iterator = list.listIterator ();

                while (iterator.hasNext ()) {
                    Integer number = (Integer) iterator.next ();
                    System.out.println (number);
                };
            //}
        });
        
        t2.start ();
    }
    
    public static void main (String [] args) {
        System.out.println ("Wrappers");

        Wrappers m = new Wrappers ();
        m.update ();
        m.runIterator ();
    }
    
}