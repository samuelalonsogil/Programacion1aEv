package ProcessBuilderDemo;

import java.io.IOException;
import java.util.ArrayList;

public class ProcessBuilderDemo {
    public static void main(String[] arg) throws IOException {
// creating list of process
        ArrayList<String> list = new ArrayList<String>();
        list.add("notepad.exe");

// create the process
        ProcessBuilder build = new ProcessBuilder(list);

// checking the command i list
        System.out.println("command: " + build.command());

    }
}
