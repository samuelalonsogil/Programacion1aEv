package HILOS.Reloj;

public class Recurso {

    String mostrar;
    Recurso(){
        this.mostrar="no se ha escrito nada";
    }
    Recurso(String m){
        this.mostrar="m";
    }
    public String getMostrar() {
        return mostrar;
    }
    public void setMostrar(String mostrar) {
        this.mostrar = mostrar;
    }
    @Override
    public String toString() {
        return "recurso [mostrar=" + mostrar + "]";
    }
}
