package mx.uv.fiee.iinf.poo.networks;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.util.HashMap;

public class EntryPoint {

    public static void main (String [] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient ();

        HttpRequest request = HttpRequest.newBuilder ()
                .uri (URI.create ("http://www.uv.mx"))
                .GET ()
                .build ();

        HttpResponse<Void> response = client.send (request, HttpResponse.BodyHandlers.discarding ());
        System.out.println ("Status code of requeted to url " + request.uri () + ": "  + response.statusCode ());

        System.out.printf ("*******************************************************************************\n\n");

        // requesting only headers
        request = HttpRequest.newBuilder(URI.create ("http://www.uv.mx"))
                .method ("HEAD", HttpRequest.BodyPublishers.noBody ())
                .build ();

        response = client.send (request, HttpResponse.BodyHandlers.discarding());

        HttpHeaders headers = response.headers();

        headers.map().forEach((key, values) -> {
            System.out.printf("%s: %s%n", key, values);
        });

        System.out.printf ("*******************************************************************************\n\n");

        // saving content into a file
        request = HttpRequest.newBuilder ()
                .uri (URI.create ("https://firebasestorage.googleapis.com/v0/b/mymovieswishlist-927ff.appspot.com/o/images%2Florem.txt?alt=media&token=4cbd995f-a6fe-4cb3-b802-55696954c31c"))
                .GET ()
                .build ();

        // this file is relative to the project
        var fileName = "loremipsum.txt";
        var response1 = client.send (request, HttpResponse.BodyHandlers.ofFile (Paths.get (fileName)));
        System.out.println ("file download with status code " + response1.statusCode ());

        System.out.printf ("*******************************************************************************\n\n");

        // sending data to a URI
        var values = new HashMap<String, String>() {{
            put("name", "John Snow");
            put ("occupation", "Night Watcher");
        }};

        var objectMapper = new ObjectMapper ();
        String requestBody = objectMapper.writeValueAsString(values);

        request = HttpRequest.newBuilder ()
                .uri(URI.create ("https://httpbin.org/post"))
                .POST (HttpRequest.BodyPublishers.ofString(requestBody))
                .build ();

        var response2 = client.send (request, HttpResponse.BodyHandlers.ofString ());
        System.out.println (response2 .body ());
    }
}




