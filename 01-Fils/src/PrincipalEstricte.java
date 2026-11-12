public class PrincipalEstricte {
    public static void main(String[] args) {
        
        Fil pepe = new Fil("Pepe",Thread.MAX_PRIORITY, 9, 2);
        Fil juan = new Fil("Juan",Thread.MAX_PRIORITY, 9,2);
        
        pepe.start();
        juan.start();

        System.out.println("Termina thread main");

    }    
}
