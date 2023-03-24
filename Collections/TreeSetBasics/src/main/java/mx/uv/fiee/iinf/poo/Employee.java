package mx.uv.fiee.iinf.poo;

/***
 *
 * @author Gonzalo
 *
 * Implementa la interfaz Comparable para ser utilizada dentro de estructuras
 * tipo TreeMap, que requieren ordenar sus elementos cuando los agregan.
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private Double payment;

    public Employee (String name, Double payment) {
        this.name = name;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public Double getPayment() {
        return this.payment;
    }

    @Override
    public String toString () {
        return this.name + " has a payment of " + this.payment;
    }

    /**
     * Compara un objeto Employee contra otro similar
     *
     * @param o objeto a ser comparado
     *
     * @return si el campos payment en el objeto actual es mayor, devuelve un valor positivo
     * si es menor, un valor negativo, si son iguales, cero.
     */
    @Override
    public int compareTo (Employee o) {
        if (this.payment > o.getPayment ()) {
            return 1;
        } else if (this.payment < o.getPayment ()) {
            return -1;
        }

        return 0;
    }
}
