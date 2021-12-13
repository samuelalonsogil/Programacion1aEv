package Threads.EjercicioTicTac;

public class RecursoThreads {
    String mostrar;

    public RecursoThreads(String mostrar) {
        this.mostrar = mostrar;
    }

    public RecursoThreads() {
        this.mostrar = "no se ha escrito nada";
    }



    public String getMostrar() {
        return mostrar;
    }

    public void setMostrar(String mostrar) {
        this.mostrar = mostrar;
    }
}
