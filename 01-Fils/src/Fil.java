public class Fil extends Thread {
    private String nombre;
    private int limite;
    private int delay;
    
    public Fil(String nombre, int prioridad, int limite, int delay) {
        this.nombre = nombre;
        this.setPriority(prioridad);
        this.limite = limite;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limite; i++) {
            System.out.println(nombre + " " + i);

            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("Acaba el fil " + nombre);
    }

}