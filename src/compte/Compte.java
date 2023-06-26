package compte;

public class Compte {
    private String numero;
    private String titulaire;
    private double solde;

    public Compte(String numero, String titulaire, double solde){
        if(solde>=0)
            this.solde=solde;
        this.numero=numero;
        this.titulaire= titulaire;
    }

    //Getters et les Setters


    public double getSolde() {
        return solde;
    }

    public void setSolde(double montantOperation) {
        if(this.solde+montantOperation>=0)
            this.solde += montantOperation;
    }
}
