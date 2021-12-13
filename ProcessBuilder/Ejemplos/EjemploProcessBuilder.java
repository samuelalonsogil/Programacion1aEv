package ProcessBuilder.Ejemplos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjemploProcessBuilder {


    public static void main(String[] arg) throws IOException {

        List<String> list = new ArrayList<String>();
        list.add("notepad.exe");
        ProcessBuilder build = new ProcessBuilder(list);
        System.out.println("command: " + build.command());

    }
}

