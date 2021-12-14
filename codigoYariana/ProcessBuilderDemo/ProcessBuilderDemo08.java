package ProcessBuilderDemo;

import java.io.IOException;

public class ProcessBuilderDemo08 {
    public static void main(String[] arg) throws IOException,
            InterruptedException {
        ProcessBuilder pb = new ProcessBuilder
                ("echo", "Hello GeeksforGeeks\n"
                        + "This is ProcessBuilder Example");
        pb.inheritIO();
        Process process = pb.start();
        process.waitFor();

    }
}
