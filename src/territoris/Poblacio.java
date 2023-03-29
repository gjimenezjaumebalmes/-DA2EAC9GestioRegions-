package territoris;

import principal.Territori;

/**
 *
 * @author fta
 */
public abstract class Poblacio implements Territori {

    private String codi;
    private String nom;
    private int habitants;
    private double densitat;

    public Poblacio(String codi, String nom, int habitants, double densitat) {
        this.codi = codi;
        this.nom = nom;
        this.habitants = habitants;
        this.densitat = densitat;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHabitants() {
        return habitants;
    }

    public void setHabitants(int habitants) {
        this.habitants = habitants;
    }

    public double getDensitat() {
        return densitat;
    }

    public void setDensitat(double densitat) {
        this.densitat = densitat;
    }

    @Override
    public void updateTerritori(){
        
        System.out.println("\nCodi de la poblacio: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la poblacio: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        
    }

    @Override
    public void showTerritori(){
        System.out.println("\nLes dades de la població amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHabitants: " + habitants);
        System.out.print("\nDensitat: " + densitat);
    }
    
}
