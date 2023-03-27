import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Muestra las formas de realizar la lectura/escritura de archivos utilizando
 * las clases decendientes de InputStream y OutputStream, así como lectores especializado
 *  en el manejo de flujos de caractereres
 */
public class Main {

    public static void main (String [] args) throws IOException {
        // obtiene la referencia a este archivo .java
        // creando la ruta utilizando clases y métodos independientes
        // de la plataforma
        File tmp = new File (".");
        String path = tmp.getCanonicalPath ()  + File.separator + "src" + File.separator + "main" + File.separator +  "java" + File.separator;
        String fullPath = path + "Main.java";
        File file = new File (fullPath); // a partir de la ruta del archivo, se crea un objeto del tipo File

        // utilizando la referencia al archivo, se obtiene la referencia
        // al flujo de entrada
        FileInputStream fis = new FileInputStream (file);
        // a partir del flujo de entrada, se crea un lector de caracteres
        InputStreamReader reader = new InputStreamReader (fis);

        //BufferedReader bufferedReader = new BufferedReader (new FileReader (file));
        // para facilitar la lectura se utiliza un lector basado en buffers
        // que presenta mejor rendiemiento que la lectura directa del flujo de entrada
        BufferedReader bufferedReader = new BufferedReader (reader);


        StringBuilder builder = new StringBuilder ();
        String line;
        int count = 1;

        // para buscar las palabras reservadas se analiza línea por línea
        // buscando todas la palabras que coincidan con el arreglo de palabras de reservadas
        while ((line = bufferedReader.readLine ()) != null) {
            for (String word: Utils.reservedWords) { // recorre el arreglo de palabras reservadas
                if (line.contains (word)) { // si existe alguna, se añade al contenedor
                    builder.append (String.format ("%s at line %d\n", word, count));
                }
            }

            count++;
        }

        String result = builder.toString (); // se obtiene la cadena resultante
        System.out.println (result);
        bufferedReader.close (); // cierra el lector
        fis.close (); // cierra el flujo de entrada

        // crea un archivo de salida, en la misma ubicación del archivo de entrada
        File outFile = new File (path + "output.txt");
        // a partir del archivo creado, se crea un flujo de salida hacia dicho archivo
        FileOutputStream fos = new FileOutputStream (outFile);

        // escritura basada en la clase OutputStreamWriter, especialidad en escribir en flujos de salida
        // crea objeto escritor a partir del flujo de salida hacia archivos
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter (fos);
//        outputStreamWriter.append (result); // agrega la cadena
//        outputStreamWriter.flush (); // vaciado al archivo
//        outputStreamWriter.close (); // cierra el objeto escritor
//
        // escritura basada en clase BufferedOutputStream, que primero realiza la escritura
        // primero hacia un buffer, para después vaciar los datos al archivo
        // la principal diferencia respecto a la clase OutputStreamWriter es que esta clase
        // solo procesa bytes por lo que primero es necesario convertir la cadena a escribir
        // en su representación de byte
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream (fos);
        // se especifica que la conversión de los caracteres utilicen la especificación UTF-8
//        byte [] fooBytes = result.getBytes (StandardCharsets.UTF_8);
//        bufferedOutputStream.write (fooBytes); // escribe los bytes
//        bufferedOutputStream.close (); // cierra el flujo y elimina el buffer
//
//        fos.close (); // cierra el flujo de salida

        // la clase PrintWriter se epecializa en salida de texto formateado
        // su uso es similar al método System.out.print con excepción que el flujo de salida
        // es un archivo en lugar de la consola del sistema
//        PrintWriter printWriter = new PrintWriter (outFile);
//        printWriter.print (result); // imprime los datos
//        printWriter.flush (); // vacía los datos al archivo
//        printWriter.close (); // cierra el escritor
//
        // la clase FileWriter realiza la escritura de datos hacia archivos, principalmente
        // hacia archivos de texto
        FileWriter fileWriter = new FileWriter (outFile);
        fileWriter.write (result);
        fileWriter.flush ();
        fileWriter.close ();
    }

}
