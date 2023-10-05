package compte;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;

import exceptions.mtInvalide;
import exceptions.soldeInsuffisant;

public abstract class compte {
    private int  code;
    protected float solde;
    private static int nbComptes;
    private compteStatus status;
    private ArrayList<operation> operations;

    public compte(float solde) {
        this.code =++ nbComptes;
        this.solde = solde;
        this.status = compteStatus.CREATED;
        this.operations = new ArrayList<>();
    }

    public compte(){

    }

    public void verser(float mt){
        if (mt > 0) {
            solde += mt;
            operations.add(new operation(new Date(),"versement",mt));
        }
    }

    public void retirer(float mt)throws Exception{
        if (mt>=solde){ throw new soldeInsuffisant("Votre solde is insuffisant");}
            if (mt<0){ throw new mtInvalide("Le montant doit etre positif");}
            solde = solde - mt;
            operations.add(new operation(new Date(),"retrait",mt));
    }

    public void transferer(compte aCompte, float mt){
        solde = solde - mt;
        aCompte.verser(mt);
    }
    @NonNull
    public String stringSolde() {
        return ("solde=" + solde);
    }

    public void stringTransactions(){
        for (operation operation : operations) {
            System.out.println(" " + operation.getNombreOperation()+" "+operation.getDate() +" "+ operation.getOperation()+" "+ operation.getMt());
        }
    }

    public float getSolde() {
        return solde;
    }

    public compteStatus getStatus() {
        return status;
    }

    public ArrayList<operation> getTransactions() {
        return operations;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public void setStatus(compteStatus status) {
        this.status = status;
    }

    public void setTransactions(ArrayList<operation> operations) {
        this.operations = operations;
    }
}



