package src;

public class Fil extends Thread {
    private String nombre;
    
    public Fil(String nombre, int prioridad) {
        this.nombre = nombre;
        this.setPriority(prioridad);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " " + i);
        }
        System.out.println("Acaba el fil " + nombre);
    }

}