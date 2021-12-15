public class Resultado {
    int suma = 0;
    String nombre;

    Resultado(String n){
        nombre = n;
    }

    public synchronized void añadir(int v){
        suma+=v;
    }

    public int getSuma(){
        return suma;
    }

    public String getNombre(){
        return nombre;
    }
}
