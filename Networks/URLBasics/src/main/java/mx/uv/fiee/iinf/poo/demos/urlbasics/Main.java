package mx.uv.fiee.iinf.poo.demos.urlbasics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * Clase demostrativa de algunas características de la clase URL y URLconnection.
 *
 * Se presenta una ventana al usuario y posteriormente se descarga de internet
 * el archivo que contiene la información requerida.
 *
 * La clase Main representa la ventana
 */
public class Main extends JFrame {
    static TextArea myText; //area de texto donde colocar los datos descargados
    
    public Main () {
        setTitle ("HTTP URL Connection"); // título de la ventana
        setSize (new Dimension (800, 600)); // tamaño predeterminado
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // operación predeterminada al cierre de la ventana

        myText = new TextArea (); // creamos al componente de área de texto
        myText.setFont (new Font ("Verdana", NORMAL, 12));

        // debido a que la cantidad de texto rebasa el tamaña del área de texto
        // se utiliza un panel contenedor que incluye barras de desplazamiento
        JScrollPane panel = new JScrollPane (myText);
        setContentPane (panel); // asignamos al panel desplazable coomo contenedor predeterminado

        setVisible (true);
    }

    /***
     * Dentro del método main realizamos la invocación del objeto que representa la ventana
     * e iniciamos la descarga de los datos
     *
     * Debido a que el trabajo con las clases URL, URLConnection e InputStream producen diferentes
     * Excepcions y con la idea de no sobrecargar el código con estructuras try catch, se optó
     * por definir al método main como origen de dichas excepciones. Esto no se recomienda, ya que
     * al producirse un error el proceso de la aplicación no finaliza limpiamente.
     *
     * @param args
     * @throws MalformedURLException producida cuanda el objeto URL no puede ser creado
     * @throws IOException algún error relacionado con la entrada/salida de los flujos de red
     */
    public static void main (String [] args) throws MalformedURLException, IOException, InterruptedException {
        Main m = new Main (); // creamos al objeto que representa la ventana

        // ******************************************************************************************
        // en el siguiente fragmento de código se muestra la forma de crear un objeto URL a partir
        // de una cadena, y si esta es correcta, la forma de recuperar información de su estructura
        //
        URL url = new URL ("http://www.uv.mx:8080/usuarios.html?q=any&filename=book.pdf");
        
        System.out.println ("protocol = "   + url.getProtocol ());
        System.out.println("authority = "   + url.getAuthority ());
        System.out.println("host = "        + url.getHost ());
        System.out.println("port = "        + url.getPort ());
        System.out.println("path = "        + url.getPath ());
        System.out.println("query = "       + url.getQuery ());
        System.out.println("filename = "    + url.getFile ());
        System.out.println("ref = "         + url.getRef ());
        // ******************************************************************************************

        // en el siguiente fragmento se muestra la forma de realizar la conexión a una URL especifica,
        // y posteriormente obtener los bytes almacenados en el archivo destino.
        //
        URL loremURL = new URL ("https://tinyurl.com/yxoaw447"); // creamos al objeto URL a partir de la dirección
        // el método openConnection devuelve la referencia a la conexión
        // aunque aún no se establece realmente, esto es, aún no se abre dicha conexión
        URLConnection urlConn = loremURL.openConnection ();
        // para utilizar los métodos definidos en la clase URLConnection, se requiere de un objeto
        // de alguna de las clases que la heredan, HTTPConnection en este caso, ya que se trata de una
        // dirección de internet
        HttpsURLConnection httpUrlConn = (HttpsURLConnection) urlConn;
        httpUrlConn.connect (); // abrimos la conexión

        // al momento de abrir una conexión el servidor puede devolver diferentes estados,
        // desde HTTP_OK, que indica que la conexión se ha establecido, a otras que representan algún error.
        // Es por esto que primero se valida que el estado de la conexión es OK.
        if (httpUrlConn.getResponseCode () == HttpURLConnection.HTTP_OK) {
            // Una vez establecida la conexión, obtenemos los bytes
            // el método getInputStream abre el flujo de bytes, pero no los lee
            InputStream in = httpUrlConn.getInputStream ();

            // para leerlos se requiere de una clase lectora, un objeto InputStremReader
            // este lee los bytes y los convierte a su representación de caracter
            InputStreamReader inputStreamReader = new InputStreamReader (in, "utf-8");
            // la clase InputStreamReader leee los bytes y los convierte a su representación unicode
            // pero lo realiza de forma secuencial, esto es, caracter a caracter, para agilizar este proceso
            // se utiliza una clase BufferedReader, que está optimizada para lectura de caracteres en bloques,
            // eso permite iterar sobre el conjunto completo de datos almacenados en el inputstreamreader
            BufferedReader buffReader = new BufferedReader (inputStreamReader); 

            // una vez obtenido el lector, es necesario iterar sobre el conjunto linea por línea,
            // sin embargo, no podemos asignar los caracteres leídos a una variable String, ya que hay
            // que recordar que las cadenas no son mutables, en su lugar se utiliza un objeto StringBuilder
            // que sí permite concatenar cadenas en él.
            String line;
            StringBuilder builder = new StringBuilder ();
            while ((line = buffReader.readLine ()) != null) {
                builder.append (line); // asignamos la línea leída al StringBuilder
                builder.append ("\n"); // junto con el caracter de salto de línea
            }
            
            in.close (); // cerramos el flujo de entrada
            //myText.setText (builder.toString ()); // asignamos los caracteres al área de texto
        }

        httpUrlConn.disconnect (); // finalmente, cerramos la conexión

        // HTTP GET POST PUT DELETE UPDATE
        String url_base = "https://firebasestorage.googleapis.com/v0/b/mymovieswishlist-927ff.appspot.com/o/images%2Florem.txt?alt=media&token=4cbd995f-a6fe-4cb3-b802-55696954c31c";

        HttpClient client = HttpClient.newBuilder().build();
        client.followRedirects ();

        HttpRequest request = HttpRequest.newBuilder (URI.create (url_base)).GET().build ();
//        HttpResponse<String> response = client.send (request, HttpResponse.BodyHandlers.ofString ());
//
//        if (response.statusCode () == 200) {
//            String foo = response.body ();
//            myText.setText(foo);
//        } else {
//            System.out.println (response);
//        }

        client.sendAsync (request, HttpResponse.BodyHandlers.ofString ())
                .thenApply (res -> res.body ())
                .thenAccept (s -> {
                   myText.setText (s);
                });

    }
    
}