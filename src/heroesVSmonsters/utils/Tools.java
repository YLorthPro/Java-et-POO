package heroesVSmonsters.utils;

import java.util.Scanner;

public class Tools {

    public final static Des D4 = new Des(1,4);
    public final static Des D6 = new Des(1,6);

    public static int demanderNB(int min, int max, String rouge, String reset){
        //entrée nombre
        Scanner sc = new Scanner (System.in);
        int nbUser=0;
        boolean entreeOK;

        do {
            try {
                nbUser = Integer.parseInt(sc.nextLine());
                if((nbUser>min-1)&&(nbUser<max+1)){
                    entreeOK=true;
                }else{
                    System.out.println(rouge + "Ce nombre n'est pas compris entre " + min + " et " + max + reset);
                    entreeOK=false;
                }

            } catch(NumberFormatException e){
                System.out.println(rouge + "Ce n'est pas un nombre. Réessayez!" + reset);
                entreeOK=false;
            }
        }while(!entreeOK);
        return nbUser;
    }

    public static boolean ouiOuNon(){
        //fonction oui ou non
        Scanner sc = new Scanner (System.in);
        boolean choixU=false, repeat;
        String temp;

        do{
            System.out.println("Oui (O) ou non(N)");
            temp= sc.nextLine();
            if((((temp.charAt(0))==('o'))||((temp.charAt(0))==('O')))&&(temp.length()==1)){
                choixU=true;
                repeat=false;
            }else if((((temp.charAt(0))==('n'))||((temp.charAt(0))==('N')))&&(temp.length()==1)){
                repeat=false;
            }else{
                System.out.println("Choix invalide");
                repeat=true;
            }
        }while (repeat);
        return choixU;
    }

    public static int best3Of4(){
        int sum = 0;
        int min = 7;

        for (int i = 0; i < 4; i++) {
            int rslt = D6.lancer();
            sum += rslt;
            if( min > rslt )
                min = rslt;
        }

        return sum - min;
    }
}
