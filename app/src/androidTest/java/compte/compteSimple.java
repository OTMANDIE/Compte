package compte;

import java.util.Date;

public class compteSimple extends compte{
    private float decouvert;

    public compteSimple(float solde,float decouvert){
        super(solde);
        this.decouvert = decouvert;
    }

    @Override
    public void retirer(float mt){
        if(mt<=solde + decouvert){
            solde -=mt;
            getTransactions().add(new operation(new Date(),"retrait",mt));

        }
    }
}
