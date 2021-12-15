public class Tirada {
    Resultado marcador;
    Dado[] dados= new Dado[5];
    Thread[] hilos= new Thread[5];
    int suma =0;

    Tirada(Resultado m){
        marcador = m;
    }

    public void tirarDados(){
        for(int i = 0; i < 5; i++){
            dados[i] = new Dado(marcador);
            hilos[i] = new Thread(dados[i]); //pasamos los runnables
            hilos[i].start();
        }

        for(int i = 0; i < 5; i++){
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        suma = marcador.getSuma();
        System.out.println("Resultado tirada de:" + marcador.getNombre() + " es " + marcador.getSuma());
    }

    public Resultado getMarcador() {
        return marcador;
    }

    public int getSuma() {
        return suma;
    }
}
