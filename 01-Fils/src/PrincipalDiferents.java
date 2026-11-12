public class PrincipalDiferents {
    public static void main(String[] args) {
        
        Fil juan = new Fil("Juan", Thread.MIN_PRIORITY, 1000, 0);
        Fil pepe = new Fil("Pepe",Thread.MAX_PRIORITY,1000 ,0);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");

    }
}