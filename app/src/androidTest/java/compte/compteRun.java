package compte;

public class compteRun {
    public static void main(String[] args) throws Exception {
        compteEpargne c1 =new compteEpargne(5000,2);
        compteEpargne c2 =new compteEpargne(5000,2);
        c1.verser(5000);
        c1.transferer(c2,4000);
        c1.verser(6000);
        c1.stringTransactions();
    }
}
