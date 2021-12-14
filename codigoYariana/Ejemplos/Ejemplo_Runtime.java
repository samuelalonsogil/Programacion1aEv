package Ejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejemplo_Runtime {
    public static void main(String[] args) {
        //take the runtime of java application
        Runtime builder = Runtime.getRuntime();

        //execute commands line
        String cmd = "cmd.exe";

        try {
            //execute the command and save the process in out
            Process out = builder.exec(cmd);
            //take the result and print it on screen
            BufferedReader bf = new BufferedReader(new InputStreamReader(out.getInputStream()));
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

