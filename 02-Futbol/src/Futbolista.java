public class Futbolista extends Thread {
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nombre) {
        super(nombre);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override 
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;

            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

}
