package ProcessBuilderDemo;

import java.io.IOException;
import java.util.ArrayList;

public class ProcessBuilderDemo02 {
    public static void main(String[] arg) throws IOException {
// creating list of process
        ArrayList<String> list = new ArrayList<String>();
        list.add("notepad.exe");
        list.add("xyz.txt");

// create the process
        ProcessBuilder build = new ProcessBuilder(list);

// checking the command in list
        System.out.println("command: " + build.command());

    }
}
