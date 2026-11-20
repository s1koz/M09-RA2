
import java.util.Random;

public class DormAleatori extends Thread{
    private long instateCreacion;

    public DormAleatori(String nom) {
        super(nom);
        this.instateCreacion = System.currentTimeMillis();
    }

    @Override 
    public void run() {
        Random random = new Random();

        for (int iteracio = 0; iteracio < 10; iteracio++) {
            int intervalAleatori = random.nextInt(901) + 100;
            long tempsDesDeConstruccio = System.currentTimeMillis() - instateCreacion;
        
            System.out.println(getName() + " (" + iteracio + ") a dormir " +
             + intervalAleatori + "ms" + 
            " Total " + tempsDesDeConstruccio + "ms");

            try {
                Thread.sleep(intervalAleatori);
            } catch (InterruptedException e) {
                System.out.println("El fil " + getName() + " ha estat interromput.");
                return;
            }

        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main ------------");
    }

}