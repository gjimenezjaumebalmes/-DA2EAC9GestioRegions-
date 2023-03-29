/*
* Classe que defineix una ciutat d’una comarca. Es defineixen pel seu codi, nom, 
* nombre d’habitants i densitat de població per Km2
 */
package territoris;

/**
 *
 * @author fta
 */
public class Ciutat extends Poblacio {
    

    public Ciutat(String codi, String nom, int habitants, double densitat) {
        super(codi,nom,habitants,densitat);
    }


    public static Ciutat addCiutat() {
        String codi, nom;
        int habitants;
        double densitat;

        System.out.println("\nCodi de la ciutat:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la ciutat:");
        nom = DADES.nextLine();

        do {
            System.out.println("\nQuants habitants té la ciutat?:");
            habitants = DADES.nextInt();
        } while (habitants < 50000);

        do {
            System.out.println("\nQuina és la densitat de la ciutat?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new Ciutat(codi, nom, habitants, densitat);
    }


    @Override
    public void updateTerritori() {
        
        super.updateTerritori();

        System.out.println("\nNombre d'habitants de la ciutat: " + getHabitants());
        do {
            System.out.println("\nEntra el nou nombre d'habitants:");
            setHabitants(DADES.nextInt());
        } while (getHabitants() < 50000);

        System.out.println("\nDensitat de la ciutatl: " + getDensitat());
        do {
            System.out.println("\nEntra la nova densitat:");
            setDensitat(DADES.nextDouble());
        } while (getDensitat() < 0 || getDensitat() > getHabitants());
    }

}
