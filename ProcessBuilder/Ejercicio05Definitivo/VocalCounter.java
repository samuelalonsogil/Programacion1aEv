package ProcessBuilder.Ejercicio05Definitivo;

import java.io.*;

public class VocalCounter {

    public static final File file = new File("F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicio05Definitivo\\ejercicio05.txt");

    public static void main(String[] args) {

        char vocal = args[0].charAt(0);
        int counter = vocalCounter(vocal);

        System.out.println(counter);
    }

    public static int vocalCounter(char vocal){
        int vocalCounter = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line= "";

            while( (line = bufferedReader.readLine() ) != null){
                vocalCounter = vocalChecker(line , vocal);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  vocalCounter;
    }


    public static int vocalChecker(String text, char vocal){
        int counter = 0;
        char arrayCharacters [] = text.toLowerCase().toCharArray(); //divide el texto en chars y los guarda en un array

        int arrayCharactersLenght = arrayCharacters.length;

        for (int i = 0; i < arrayCharactersLenght; i++) {
            if (arrayCharacters[i] == vocal) counter++;
        }

        return counter;
    }

}
