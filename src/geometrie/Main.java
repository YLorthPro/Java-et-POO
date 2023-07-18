package geometrie;

public class Main {
    public static void main(String[] args) {
        Carre carre = new Carre(4, "Jaune");
        Triangle triangle = new Triangle(3, 4, 5, "Bleu");
        Cercle cercle = new Cercle(5,"Vert");
        Cube cube = new Cube(3,"Rouge");
        Sphere sphere = new Sphere(3,"Gris");

        Affichable[] formes = {carre, triangle, cercle, cube, sphere};

        for (Affichable forme : formes) {
            forme.afficherInfo();
            System.out.println("-------------------");
        }

    }
}
