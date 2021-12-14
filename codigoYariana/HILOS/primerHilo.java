package HILOS;

public class primerHilo extends Thread {
    private int x;
    private String nombre;

    primerHilo(int x, String n) {
        this.x = x;
        this.nombre = n;
        System.out.println("Se ha creado un nuevo hilo llamado " + nombre);
    }


    @Override
    public void run() {
        super.run();
        for (int i = 0; i < x; i++) {
            //System.out.println("Ejecución de run número: " + i + " de hilo " + nombre);
            System.out.println(this.toString());
        }
    }

    @Override
    public String toString() {
        return "primerHilo{" +
                "x=" + x +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
