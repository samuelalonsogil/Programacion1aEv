package ProcessBuilder.Ejemplos;

import java.lang.*;
import java.io.*;
import java.util.*;

public class AbrirBlockNotas {

    public static void main(String[] arg) throws IOException {
// creating list of process
        List<String> list = new ArrayList<String>();
        list.add("notepad.exe");

// create the process
        ProcessBuilder build = new ProcessBuilder(list);

// checking the command in list
        System.out.println("command: " + build.command());
        build.start();
    }
}

