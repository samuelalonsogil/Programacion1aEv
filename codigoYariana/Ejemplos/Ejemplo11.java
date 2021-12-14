package Ejemplos;

import java.io.File;

public class Ejemplo11 {
    public static void main(String[] args) {

        //create the command
        String cmd = "ps";

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);

            //redirect the output to a new file named output.txt
            pb.redirectOutput(new File("output.txt"));

            pb.start();//execute the command

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
