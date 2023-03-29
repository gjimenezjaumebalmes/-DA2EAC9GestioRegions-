/*
* Classe que defineix una zona rural d’una comarca. Es defineixen pel seu codi, 
* nom, nombre d’habitants, densitat de població per Km2
 */
package territoris;


/**
 *
 * @author fta
 */
public class ZonaRural extends Poblacio {

    public ZonaRural(String codi, String nom, int habitants, double densitat) {
       super(codi, nom, habitants, densitat);
    }
    

    public static ZonaRural addZonaRural() {
        String codi, nom;
        int habitants;
        double densitat;

        System.out.println("\nCodi de la zona rural:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la zona rural:");
        nom = DADES.nextLine();

        do {
            System.out.println("\nQuants habitants té la zona rural?:");
            habitants = DADES.nextInt();
        } while (habitants < 0 || habitants >= 5000);

        do {
            System.out.println("\nQuina és la densitat de la zona rural?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new ZonaRural(codi, nom, habitants, densitat);
    }


    @Override
    public void updateTerritori() {
        
        super.updateTerritori();
        
        System.out.println("\nNombre d'habitants de la ciutat: " + getHabitants());
        do {
            System.out.println("\nEntra el nou nombre d'habitants:");
            setHabitants(DADES.nextInt());
        } while (getHabitants() < 0 || getHabitants() >= 5000);

        System.out.println("\nDensitat de la ciutatl: " + getDensitat());
        do {
            System.out.println("\nEntra la nova densitat:");
            setDensitat(DADES.nextDouble());
        } while (getDensitat() < 0 || getDensitat() > getHabitants());

    }

}
