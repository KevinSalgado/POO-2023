package mx.uv.fiee.iinf.poo;

import java.util.Objects;

/**
 * Representa un objeto circulo que implementa las interfaces Draw y Shape
 * por lo tanto, está oblidada a implementar los métodos que estas definen
 *
 * La interfaz clonable no define un método propio, en su lagar utiliza la
 * función definida en la clase base (Object) para realizar la copia.
 * Dicha operación es realizada mediante código nativo a la plataforma,
 * con el objetivo de realizala lo más rápido posible, pero principalmente
 * debido a que debe acceder directamente a la memoria para copiar byte a byte
 * al objeto en cuestión.
 *
 * Implementa la interfaz Comparable, dándole la capacidad al objeto creado
 * a partir de esta clase, de compararse contra otro objeto igual de forma que se
 * pueda saber si se es mayor, menor o iguales.
 *
 */
public class Circle implements Draw, Calculate, Cloneable, Comparable<Circle> {
    int x, y;
    int radio;
    double area;

    public Circle (int x, int y, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    /***
     * Sobreescribe los métodos definidos en la interfaz Draw
     */
    @Override
    public void paint () {
        System.out.println ("Círculo dibujado con centro en (" + this.x + ", " + this.y + ") y radio de " + this.radio);
    }

    @Override
    public void fill () {
        System.out.println ("Círculo coloreado!");
    }
    /****/

    /**
     * Sobreescribe al método definido en la interfaz Shape
     */
    @Override
    public void calculateArea () {
        this.area = Math.PI * Math.sqrt (radio);
        System.out.println ("El área del círculo es " + this.area);
    }

    /**
     * Reemplaza al método equals de la clase base, lo que nos permite ahora
     * comparar directamente las áreas para definir la igualdad.
     *
     * @param obj objeto contra el cuál se compara a este objeto.
     * @return verdadero si ambos objetos presetan la misma área, falso en caso contrario
     */
    @Override
    public boolean equals (Object obj) {
        if (obj instanceof Circle) {
            return this.area == ((Circle) obj).area;
        }

        return false;
    }

    /**
     * Reemplaza al método hashcode de la clase base, generando un identificador único
     * para este objeto, basado en los valores de sus campos
     *
     * @return entero representando el identificador obtenido del cálculo hash
     */
    @Override
    public int hashCode () {
        return Objects.hash (x, y, radio, area);
    }

    /**
     * invoca a la función clone de la clase base, delegando la operación de copia
     * @return Un objeto con el mismo estado (valores de los campos) del objeto copiado.
     * @throws CloneNotSupportedException si la clase donde se invoca no implementa la interfaz Clonable
     */
    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone ();
    }

    /**
     * Compara el objeto actual contra otro similar. Podría pensarse que este método realiza
     * una función similar al método equals, pero la naturaleza de compareTo es ordenamiento,
     * mientras que equals busca igualdad.
     *
     * @param o objeto contra el cuál compararse
     * @return valor entero representando si el objeto actual es mayor (>0), si es menor (<0)
     * o sin son iguales (0), tomando como referencia el área que los objetos en cuestión ocupan.
     */
    @Override
    public int compareTo (Circle o) {
        if (this.area == 0.0) this.calculateArea ();
        if (o.area == 0.0) o.calculateArea ();

        if (this.area > o.area) return 1;
        if (this.area < o.area) return -1;

        return 0;
    }


}