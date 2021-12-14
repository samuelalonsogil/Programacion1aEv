package Ejemplos;

import java.io.File;
import java.io.IOException;

public class RedireccionAFicherosEntraSaliErrores {

    public static void main(String[] args) throws IOException {
        try {
            // create a process
            ProcessBuilder pb = new ProcessBuilder("cmd");

            // take all commands as input in a text file
            File commands = new File("E:\\test\\commands.txt");

            // File where error logs should be written
            File error = new File("E:\\test\\error.txt");

            // File where output should be written
            File output = new File("E:\\test\\output.txt");

            // redirect all the files
            pb.redirectInput(commands);
            pb.redirectOutput(output);
            pb.redirectError(error);

            // start the process
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
