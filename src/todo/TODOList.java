package todo;

import todo.Tache;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TODOList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList toDoList = new ArrayList<>();

        String reponseUtilisateur;
        String reponseUtilisateur2;
        LocalDate date;
        String reponseUtilisateur3;
        boolean repeat;

        do{
            System.out.println("Entrez le nom de la tache:");
            reponseUtilisateur=sc.nextLine();

            System.out.println("Entrez la date (JJ-MM-YYYY):");
            reponseUtilisateur2=sc.nextLine();
            date= LocalDate.parse(reponseUtilisateur2, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            System.out.println("Entrez la description de la tache");
            reponseUtilisateur3=sc.nextLine();

            Tache aAjouter = new Tache(reponseUtilisateur,date,reponseUtilisateur3);
            toDoList.add(aAjouter);

            System.out.println("Nombre de tache à faire: "+ toDoList.size());

            System.out.println(aAjouter.nom);

            do {
                System.out.println("Voulez-vous ajouter une autre tache? Oui (O), non (N)");
                reponseUtilisateur = sc.nextLine();

                if("o".equals(reponseUtilisateur.toLowerCase()))
                    repeat=true;
                else
                    repeat=false;
            }while(!reponseUtilisateur.toLowerCase().equals("o") && !reponseUtilisateur.toLowerCase().equals("n"));

        }while(repeat);
    }
}
