package mx.uv.fiee.iinf.poo.demos.wildcardsusecase;

import java.util.ArrayList;

/***
 * 
 * @author Gonzalo
 */
public class Utils {
    /***
     * Copy all items cointained in source list into destiny list
     * @param <T> define type for the lists and variables
     * @param source contains items to insert
     * @param destiny destination list where insert item into
     */
    public static <T> void insertList (ArrayList<? extends T> source, ArrayList<? super T> destiny) {
        for (T item: source) {
            destiny.add (item);
        }
    }
    
//    /***
//     * 
//     * this previous version works with any type, but casting in every operation (read and write)
//     * 
//     */
//    public static void insertList (ArrayList<Object> source, ArrayList<Object> destiny) {
//        for (Object item: source) {
//            destiny.add (item);
//        }
//    }
    
//    /***
//     * 
//     * this previous version works ONLY with lists with items of Number class and subclasses type
//     *     
//     */
//    public static void insertList (ArrayList<Number> source, ArrayList<Number> destiny) {
//        for (Number item: source) {
//            destiny.add (item);
//        }
//    }
    
//    /**
//     * 
//     * this previous version works inserting items of Numbers class type as source but it requires to call
//     * doubleValue () function to formatting each item to Double
//     * 
//     */
//    public static void insertList (ArrayList<Number> source, ArrayList<Double> destiny) {
//        for (Number item: source) {
//            destiny.add (item.doubleValue ());
//        }
//    }
    
    
}
