import java.util.Scanner;

public class Coet {

    private final Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor("Motor " + i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error de valor: la potència ha d'estar entre 0 i 10.");
            return;
        }
        System.out.println("Passant a potència " + p);
        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner sc = new Scanner(System.in);
        int p;
        do {
            p = sc.nextInt();
            coet.passaAPotencia(p);
        } while (p != 0);

        sc.close();
    }
}