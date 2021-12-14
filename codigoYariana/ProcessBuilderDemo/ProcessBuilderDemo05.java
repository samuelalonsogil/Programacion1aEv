package ProcessBuilderDemo;

import java.util.ArrayList;

public class ProcessBuilderDemo05 {
    public static void main(String[] args) {
        // creating list of commands
        ArrayList list = new ArrayList();

        list.add("notepad.exe");
        list.add("xyz.txt");

//creating the process
        ProcessBuilder build = new ProcessBuilder(list);

// checking if error stream is redirected
        System.out.println(build.redirectErrorStream());

    }

}

