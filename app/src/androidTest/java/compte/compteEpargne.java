package compte;

public class compteEpargne extends compte{
    private float taux;

    public compteEpargne(float solde,float taux){
        super(solde);
        this.taux = taux;
    }

    public void calculInteret(float taux){
        solde *= (1+taux/100);
    }
}
