package mx.uv.fiee.iinf.poo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main (String [] args) {
        //
        // Estructura TreeSet almacenando tipos String
        // se pasa como parámetro del constructor un objeto de tipo Comparator
        // que indica a la estructura que los elementos deben ser almacenados
        // en orden inverso al ordenamiento natural del tipo de dato
        //
//        Set<String> treeStr = new TreeSet<> (Comparator.reverseOrder ());
//        treeStr.add ("r2d2");
//        treeStr.add ("c3po");
//        treeStr.add ("bb8");
//        treeStr.add ("deathstar");
//        treeStr.add ("millenialfalcon");
//
//        System.out.println ("***************TreeSet String, orden de almacenamiento inverso, recorrido normal*****************");
//        // recorremos la estructura y obtener los valores almacenados
//        for (String s: treeStr) {
//            System.out.println (s);
//        }

        //
        // Estructura TreeSet almacenando tipos Employee
        // Si no le indicamos parámetros mediante el constructor la estructura
        // almacena los elementos respetando el orden natural definido por el
        // tipo de dato
        //
//        TreeSet<Employee> treeEmp = new TreeSet<> (Comparator.reverseOrder());
//        treeEmp.add (new Employee ("Lea", 20000.0));
//        treeEmp.add (new Employee ("Luke", 30000.0));
//        treeEmp.add (new Employee ("Anakin", 25000.0));
//        treeEmp.add (new Employee ("Han", 15000.0));

        //System.out.println ("***************TreeSet Employee, orden de almacenamiento natural (basado en payment), recorrido inverso*****************");
        //
        // una vez almacenados y ordenados los elementos podemos recorrer la estructura
        // de forma inversa, mediante el objeto iterador decendente que define el
        // objeto TreeMap
        //
//        for (Employee e: treeEmp) {
//            System.out.println (e);
//        }
        //
        // Estructura TreeSet almacenando tipos Employee
        // En este caso se está modificando la forma de comparación definida
        // en el tipo de dato, mediante un objeto que implementa la interfaz Comparator
        //
        TreeSet<Employee> treeMasters = new TreeSet<>(new Comparator<Employee>() {
            /***
             * Este método reemplaza la forma de comparación definida en el tipo de dato
             *
             * Como puede apreciarse, los valores devueltos son contrarios a los definidos
             * en el método CompareTo definido en la clase Employee, para conseguir que los
             * elementos sean almacenados de forma inversa al orden natural.
             *
             * @param o1 objeto Employee
             * @param o2 objeto Employee
             * @return si el campo payment del objeto 1 es mayor que el campos payment del segundo,
             * devuelve un valor negativo, si es menor, devuelve un valor positivo, si son
             * iguales, devuelve cero.
             */
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getPayment () > o2.getPayment ()) {
                    return -1;
                } else if (o1.getPayment () < o2.getPayment ()) {
                    return 1;
                }

                return 0;
                // comparación basada en Double
                //return o1.getPayment().compareTo(o2.getPayment());

                // comparación basada en String
                //return o1.getName().compareTo (o2.getName ());
            }
        });

        treeMasters.add (new Employee ("Yoda", 45000.00));
        treeMasters.add (new Employee ("Kenobi", 43000.00));
        treeMasters.add (new Employee ("Windu", 44000.00));
        treeMasters.add (new Employee ("Skywaker", 47000.00));

        System.out.println ("***************TreeSet Employee, orden de almacenamiento (basado en payment) modificado, recorrido normal*****************");

        // recorremos la estrucura para apreciar como los elementos
        // están almacenados en base al órden definido por el objeto Comparator
        for (Employee e: treeMasters) {
            System.out.println (e);
        }
    }

}



