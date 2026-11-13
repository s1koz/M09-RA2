public class MainFutbolista {
    public static void main(String[] args) {
        // Array con los nombres de los 11 jugadores
        String[] nombres = {
            "Piqué", "Vinicius", "Torres", "Ramos", 
            "Ronaldo", "Lewan", "Belli", "Arnau", 
            "Aspas", "Messi", "MBapé"
        };

        // 1. Se crean todos los fils (hilos)
        Futbolista[] futbolistas = new Futbolista[Futbolista.NUM_JUGADORS];
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            futbolistas[i] = new Futbolista(nombres[i]);
        }

        System.out.println("Inici dels xuts ------------------------");

        // 2. S'inicien tots els fils
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            futbolistas[i].start();
        }

        // 3. S'espera a tots els fils a que acabin (utilizando join)
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            try {
                futbolistas[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts ------------------------");
        System.out.println("--- Estadístiques ------");

        // 4. Es mostren les estadístiques dels xuts
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            System.out.println(futbolistas[i].getName() + " -> " + futbolistas[i].getNgols() + " gols");
        }
    }
}