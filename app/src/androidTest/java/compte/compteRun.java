package compte;

public class compteRun {
    public static void main(String[] args) throws Exception {
        compteEpargne c1 =new compteEpargne(5000,2);
        compteEpargne c2 =new compteEpargne(5000,2);
        c1.transferer(c2,4000);

        System.out.println(c1.stringSolde());
        System.out.println(c2.stringSolde());
    }
}
