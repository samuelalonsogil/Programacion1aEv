package ProcessBuilderDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProcessBuilderDemo07 {
    public static void main(String[] args) throws IOException {
        // creating list of commands
        ArrayList<String> commands = new ArrayList<String>();

        commands.add("cmd.exe"); // command
        //le añadimos esto para que nos funcione

        commands.add("/c"); // command
        commands.add("dir");
        //commands.add("/Users/abhishekverma"); //command in Mac OS

        // creating the process
        ProcessBuilder pb = new ProcessBuilder(commands);

        // startinf the process

        Process process = pb.start();

        // for reading the ouput from stream
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
    }
}
