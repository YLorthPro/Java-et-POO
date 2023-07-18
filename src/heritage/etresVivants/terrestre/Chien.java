package heritage.etresVivants.terrestre;

import heritage.etresVivants.Mammifere;

public class Chien extends Terrestre implements Mammifere {
    private String nom;

    public Chien(String nom) {
        super(true);
        this.nom = nom;
    }

    public void abboyer(){
        System.out.println("Miaouw");
    }

    @Override
    public void accoucher() {
        System.out.println("J'accouche");
    }

    @Override
    public void allaiter() {
		System.out.println("J'allaite");
    }
}
