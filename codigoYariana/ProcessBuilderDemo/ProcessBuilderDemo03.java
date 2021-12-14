package ProcessBuilderDemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessBuilderDemo03 {
    public static void main(String[] arg) throws IOException {
// creating list of process
        ArrayList<String> list = new ArrayList<String>();
        list.add("notepad.exe");
        list.add("abc.txt");

// creating the process
        ProcessBuilder build = new ProcessBuilder(list);

// setting the directory
        build.directory(new File("src"));

// checking the directory, on which currently working on
        System.out.println("directory: " + build.directory());

    }
}
