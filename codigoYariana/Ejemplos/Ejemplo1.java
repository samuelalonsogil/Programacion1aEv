package Ejemplos;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        // creating list of process
        ArrayList<String> list = new ArrayList<String>();

        list.add("notepad.exe");

// create the process
        ProcessBuilder build = new ProcessBuilder(list);

// checking the command i list
        System.out.println("command: " + build.command());

    }
}

