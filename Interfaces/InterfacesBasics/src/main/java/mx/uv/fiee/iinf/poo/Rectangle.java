package mx.uv.fiee.iinf.poo;

import java.util.Objects;

/**
 * Representa un objeto rectangulo que implementa las interfaces Draw y Shape
 * por lo tanto, está oblidada a implementar los métodos que estas definen.
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
 */
public class Rectangle implements Draw, Calculate, Cloneable, Comparable<Rectangle> {
    int x1, y1, x2, y2;
    double area;

    public Rectangle (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /***
     * Sobreescribe los métodos definidos en la interfaz Draw
     */
    @Override
    public void paint () {
        String m = String.format ("Dibujando el rectangulo desde el punto (%d, %d) al punto (%d, %d)", x1, y1, x2, y2);
        System.out.println (m);
    }

    @Override
    public void fill () {
        System.out.println ("Rectángulo coloreado!");
    }
    /******/

    /**
     * Sobreescribe al método definido en la interfaz Shape
     */
    @Override
    public void calculateArea () {
        int base = x2 - x1;
        int altura = y2 - y1;
        this.area = base * altura;
        System.out.println ("El área del rectángulo es " + this.area);
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
        if (obj instanceof Rectangle) {
            return this.area == ((Rectangle) obj).area;
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
        return Objects.hash (x1, y1, x2, y2, area);
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
    public int compareTo (Rectangle o) {
        if (this.area == 0.0) calculateArea ();
        if (o.area == 0.0) o.calculateArea ();

        if (this.area > o.area) return 1;
        if (this.area < o.area) return -1;

        return 0;
    }
}