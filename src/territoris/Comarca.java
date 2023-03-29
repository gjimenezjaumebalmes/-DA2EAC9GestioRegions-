/*
 * Classe que defineix una comarca. Una comarca es defineix pel seu nom, el nom de
 * la seva capital, un array de ciutats, un array de pobles i un array de zones rurals.
 */
package territoris;

import principal.Territori;

/**
 *
 * @author fta
 */
public class Comarca implements Territori {

    private String codi;
    private String nom;
    private String capital;
    private Poblacio[] poblacions = new Poblacio[300];
    private int pPoblacions = 0; //Priemra posició buida de l'array de poblacions
    

    public Comarca(String codi, String nom, String capital) {
        this.codi = codi;
        this.nom = nom;
        this.capital = capital;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Poblacio[] getPoblacions() {
        return poblacions;
    }

    public void setPoblacions(Poblacio[] poblacions) {
        this.poblacions = poblacions;
    }

    public int getpPoblacions() {
        return pPoblacions;
    }

    public void setpPoblacions(int pPoblacions) {
        this.pPoblacions = pPoblacions;
    }


    public static Comarca addComarca() {
        String codi, nom, capital;

        System.out.println("\nCodi de la comarca:");
        codi = DADES.next();
        DADES.nextLine(); //Netejem buffer
        System.out.println("\nNom de la comarca:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la comarca:");
        capital = DADES.nextLine();

        return new Comarca(codi, nom, capital);
    }


    @Override
    public void updateTerritori() {
        System.out.println("\nCodi de la comarca:" + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Netejem buffer
        System.out.println("\nNom de la comarca: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la comarca: " + capital);
        System.out.println("\nEntra la nova capital:");
        capital = DADES.nextLine();
    }


    public int calcularTotalHabitants() {
    
        int totalHabitants = 0;

        for (int i = 0; i < pPoblacions; i++) {
            totalHabitants += poblacions[i].getHabitants();
        }

        return totalHabitants;
    }

    @Override
    public void showTerritori() {
        System.out.println("\nLes dades de la comarca amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nCapital: " + capital);
        System.out.println("\nTotal habitants: " + calcularTotalHabitants());
    }


    public void addCiutat() {

        Ciutat novaCiutat = Ciutat.addCiutat();

        if (selectPoblacio(1, novaCiutat.getCodi()) == -1) {
            poblacions[pPoblacions] = novaCiutat;
            pPoblacions++;
        } else {
            System.out.println("\nLa ciutat ja existeix");
        }
    }


    public void addPoble() {

        Poble nouPoble = Poble.addPoble();

        if (selectPoblacio(2, nouPoble.getCodi()) == -1) {
            poblacions[pPoblacions] = nouPoble;
            pPoblacions++;
        } else {
            System.out.println("\nEl poble ja existeix");
        }
    }


    public void addZonaRural() {

        ZonaRural novaZonaRural = ZonaRural.addZonaRural();

        if (selectPoblacio(3,novaZonaRural.getCodi()) == -1) {
            poblacions[pPoblacions] = novaZonaRural;
            pPoblacions++;
        } else {
            System.out.println("\nLa zona rural ja existeix");
        }
    }

    public int selectPoblacio(int tipusPoblacio, String codi) {

        if (codi == null) {
            //Demanem quin tipus de població es vol seleccionar i el seu codi
            switch (tipusPoblacio) {
                case 1:
                    System.out.println("Codi de la ciutat?:");
                    break;
                case 2:
                    System.out.println("Codi del poble?:");
                    break;
                case 3:
                    System.out.println("Codi de la zona rural?:");
                    break;
            }

            codi = DADES.next();
        }

        int posPoblacio = -1; //Posició que ocupa la població seleccionada dins l'array de poblacions de la comarca

        //Seleccionem la posició que ocupa la població dins l'array de poblacions de la comarca
        for (int i = 0; i < pPoblacions; i++) {
            if (poblacions[i] instanceof Ciutat && tipusPoblacio == 1) {
                if (((Ciutat) poblacions[i]).getCodi().equals(codi)) {
                    return i;
                }
            } else if (poblacions[i] instanceof Poble && tipusPoblacio == 2) {
                if (((Poble) poblacions[i]).getCodi().equals(codi)) {
                    return i;
                }
            } else if (poblacions[i] instanceof ZonaRural && tipusPoblacio == 3) {
                if (((ZonaRural) poblacions[i]).getCodi().equals(codi)) {
                    return i;
                }
            }
        }

        return posPoblacio;
    }

}
