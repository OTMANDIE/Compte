package compte;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import exceptions.mtInvalide;
import exceptions.soldeInsuffisant;

public abstract class compte {
    private int  code;
    protected float solde;
    private static int nbComptes;
    private compteStatus status;
    private ArrayList<operation> operations;
    private ArrayList<versement> versements;
    private ArrayList<retrait> retraits;

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
            operations.add(new versement(new Date(),mt));
        }
    }

    public void retirer(float mt)throws Exception{
        if (mt>=solde){ throw new soldeInsuffisant("Votre solde is insuffisant");}
            if (mt<0){ throw new mtInvalide("Le montant doit etre positif");}
            solde = solde - mt;
            operations.add(new retrait(new Date(),mt));
    }

    public void transferer(compte destinationCompte, float mt) throws Exception {
        if (mt <= 0) {
            throw new mtInvalide("Le montant doit être positif");
        }
        if (solde < mt) {
            throw new soldeInsuffisant("Votre solde est insuffisant");
        }
        this.retirer(mt);
        destinationCompte.verser(mt);
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

    public void operationToTextFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\AndroidStudioProjects\\Compte\\app\\src\\androidTest\\java\\compte\\operations.txt", true))) {
            for (operation op : operations) {
                String operationType = op instanceof retrait ? "retrait" : "versement";
                String message = "Operation de " + operationType + " a " + op.getDate() + " de montant " + op.getMt() + " dans le compte " + this.getClass().getSimpleName();
                writer.write(message);
                writer.newLine();
            }
            System.out.println("File created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stringRetrait(){
        for (retrait retrait : retraits) {
            System.out.println(" " + retrait.getNombreOperation()+" "+retrait.getDate() +" "+ retrait.getOperation()+" "+ retrait.getMt());
        }
    }
    public void stringVersement(){
        for (versement versement : versements) {
            System.out.println(" " + versement.getNombreOperation()+" "+versement.getDate() +" "+ versement.getOperation()+" "+ versement.getMt());
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

}



