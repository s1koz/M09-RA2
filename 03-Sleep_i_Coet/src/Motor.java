import java.util.Random;

public class Motor extends Thread {

    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private final Random random = new Random();

    public Motor(String nom) {
        super(nom);
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        boolean haArrancat = false;
        int ultimFerRes = -1;

        while (true) {
            if (potenciaObjectiu > 0 || potenciaActual > 0) {
                haArrancat = true;
            }

            if (haArrancat && potenciaObjectiu == 0 && potenciaActual == 0) {
                break;
            }

            if (potenciaActual < potenciaObjectiu) {
                dormirAleatorio();
                potenciaActual++;
                if (potenciaActual == potenciaObjectiu) {
                    if (ultimFerRes != potenciaActual) {
                        System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                        ultimFerRes = potenciaActual;
                    }
                } else {
                    ultimFerRes = -1;
                    System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }
            } else if (potenciaActual > potenciaObjectiu) {
                dormirAleatorio();
                potenciaActual--;
                if (potenciaActual == potenciaObjectiu) {
                    if (ultimFerRes != potenciaActual) {
                        System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                        ultimFerRes = potenciaActual;
                    }
                } else {
                    ultimFerRes = -1;
                    System.out.println(getName() + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    private void dormirAleatorio() {
        int espera = random.nextInt(1001) + 1000; // Entre 1000 y 2000 ms
        try {
            Thread.sleep(espera);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}