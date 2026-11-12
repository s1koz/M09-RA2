public class PrincipalDiferents {
    public static void main(String[] args) {
        
        Fil juan = new Fil("Juan", Thread.MIN_PRIORITY);
        Fil pepe = new Fil("Pepe",Thread.MAX_PRIORITY);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");

    }
}