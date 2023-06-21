import java.util.Scanner;

public class DistributeurDeBoissons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Boisson maBoisson = new Boisson();
        maBoisson.nom="cola";
        maBoisson.quantite=3;

        Boisson maBoisson2 = new Boisson();
        maBoisson2.nom="Eau plate";
        maBoisson2.quantite=2;

        Boisson maBoisson3 = new Boisson();
        maBoisson3.nom="Eau gazeuse";
        maBoisson3.quantite=5;

        String choixUtilisateur;
        String autreChoix;

        boolean repeat;


        do {
            System.out.println("Quelle boisson voulez vous? 1.Cola - 2.Eau plate - 3.Eau gazeuse");
            choixUtilisateur = sc.nextLine();

            Boisson lElue = null;

            switch (choixUtilisateur){
                case "1":
                    lElue = maBoisson;
                    break;

                case "2":
                    lElue = maBoisson2;
                    break;

                case "3":
                    lElue = maBoisson3;
                    break;

                default:
                    lElue = null;
            }

            if(lElue.quantite>0){
                System.out.println("Voici un "+ lElue.nom);
                System.out.println("Quantité restante: "+ (--lElue.quantite));;
            } else
                System.out.println("Nous n'avons plus de "+lElue.nom);


            do {
                System.out.println("Voulez-vous une autre boisson? Oui (O), non (N)");
                autreChoix = sc.nextLine();

                if("o".equals(autreChoix.toLowerCase()))
                    repeat=true;
                else
                    repeat=false;
            }while(!autreChoix.toLowerCase().equals("o") && !autreChoix.toLowerCase().equals("n"));

        }while (repeat && (maBoisson.quantite + maBoisson2.quantite+ maBoisson3.quantite >0));

        if(maBoisson.quantite + maBoisson2.quantite+ maBoisson3.quantite==0)
            System.out.println("Plus de boissons disponibles");

        System.out.println("Au revoir!");

    }
}
