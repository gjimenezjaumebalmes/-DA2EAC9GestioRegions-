/*
* Classe que defineix un poble d’una comarca. Es defineixen pel seu codi, nom, 
* nombre d’habitants i densitat de població per Km2.
 */
package territoris;

/**
 *
 * @author fta
 */
public class Poble extends Poblacio {


    public Poble(String codi, String nom, int habitants, double densitat) {
        super(codi, nom, habitants, densitat);
    }

    

    public static Poble addPoble() {
        String codi, nom;
        int habitants;
        double densitat;

        System.out.println("\nCodi del poble:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del poble:");
        nom = DADES.nextLine();

        do {
            System.out.println("\nQuants habitants té el poble?:");
            habitants = DADES.nextInt();
        } while (habitants < 5000 || habitants >= 50000);

        do {
            System.out.println("\nQuina és la densitat del poble?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new Poble(codi, nom, habitants, densitat);
    }


    @Override
    public void updateTerritori() {
        
        super.updateTerritori();
        
        System.out.println("\nNombre d'habitants de la ciutat: " + getHabitants());
        do {
            System.out.println("\nEntra el nou nombre d'habitants:");
            setHabitants(DADES.nextInt());
        } while (getHabitants() < 5000 || getHabitants() >= 50000);

        System.out.println("\nDensitat de la ciutatl: " + getDensitat());
        do {
            System.out.println("\nEntra la nova densitat:");
            setDensitat(DADES.nextDouble());
        } while (getDensitat() < 0 || getDensitat() > getHabitants());
        
    }

}
