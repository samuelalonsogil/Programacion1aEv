package ProcessBuilder.Ejercicio05;

import java.io.*;
import java.text.FieldPosition;

public class CuentaVocales {

    public static void readFile(File file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int numVocals = 0;
            char arrayVocals [] = {'a' , 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

            while(line != null){
                line = bufferedReader.readLine();

                if(line != null){

                    int lineLenght = line.length();
                    int arrayVocalsLenght = arrayVocals.length;

                    for(int i = 0; i < lineLenght; i++){
                        for(int j = 0; j < arrayVocalsLenght ;j++){
                            if(line.charAt(i) == arrayVocals[j] ) numVocals++;
                        }
                    }
                }
                if(line == null) System.out.println(numVocals);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static void main(String[] args) {
        File file = new File("G:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicio05\\ejemplo.txt");

        readFile(file);
    }

}
