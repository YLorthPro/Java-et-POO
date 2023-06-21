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

            switch (choixUtilisateur){
                case "1":
                    if(maBoisson.quantite>0){
                        System.out.println("Voici un "+ maBoisson.nom);
                        System.out.println("Quantité restante: "+ (--maBoisson.quantite));;
                    } else
                        System.out.println("Nous n'avons plus de "+ maBoisson.nom);
                    break;
                case "2":
                    if(maBoisson2.quantite>0){
                        System.out.println("Voici un "+maBoisson2.nom);
                        System.out.println("Quantité restante: "+ (--maBoisson2.quantite));;
                    } else
                        System.out.println("Nous n'avons plus de "+maBoisson2.nom);
                    break;
                case "3":
                    if(maBoisson3.quantite>0){
                        System.out.println("Voici un "+maBoisson3.nom);
                        System.out.println("Quantité restante: "+ (--maBoisson3.quantite));;
                    } else
                        System.out.println("Nous n'avons plus de "+maBoisson3.nom);
                    break;
                default:
                    System.out.println("Boisson non connue");
            }

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
