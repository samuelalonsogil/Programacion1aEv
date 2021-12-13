package ProcessBuilder.Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EjemploProcessBuilder07 {

    public static void main(String[] arg) throws IOException{

        // creating list of commands
        List<String> commands = new ArrayList<String>();
        commands.add("cmd.exe"); // command
        commands.add("/c"); // ejecutar como admin
        commands.add("dir");

        // creating the process
        ProcessBuilder pb = new ProcessBuilder(commands);

        // startinf the process
        Process process = pb.start();

        // for reading the ouput from stream
        BufferedReader stdInput = new BufferedReader(new
        InputStreamReader(process.getInputStream()));
        String s = null;

        while ((s = stdInput.readLine()) != null)
        {
            System.out.println(s);
        }
    }
}
