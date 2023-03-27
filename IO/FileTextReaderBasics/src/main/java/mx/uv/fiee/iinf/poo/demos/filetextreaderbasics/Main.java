package mx.uv.fiee.iinf.poo.demos.filetextreaderbasics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void main (String [] args) throws FileNotFoundException, IOException {
        String pathname = "/Users/Gonzalo/lorem";
        
        File file = new File (pathname);
        FileReader fileReader = new FileReader (file);
        
//        StringBuilder sb = new StringBuilder ();
//        int charsRead;
//        char[] charBuffer = new char [1024];
//
//        while ((charsRead = fileReader.read (charBuffer)) > -1) {
//            sb.append (charBuffer, 0, charsRead);
//        }
//
//        System.out.println (sb.toString ());
        
        BufferedReader buff = new BufferedReader (fileReader);

        String line;
        while ((line = buff.readLine ()) != null) {
            System.out.println (line);
        }
        
        buff.close ();
        fileReader.close ();
    }

}
