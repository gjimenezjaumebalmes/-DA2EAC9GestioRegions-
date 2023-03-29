package principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import persistencia.GestorPersistencia;
import territoris.Ciutat;
import territoris.Poble;
import territoris.ZonaRural;

/**
 *
 * @author fta
 */
public class Application {

    private final static Scanner DADES = new Scanner(System.in);

    private static Regio[] regions = new Regio[10];
    private static int pRegions = 0; //Priemra posició buida del vector regions
    private static Regio regioActual = null;
    static private String FITXER = "regio";
    static private GestorPersistencia gp = new GestorPersistencia();

    public static void main(String[] args) {
            menuPrincipal();
    }

    private static void menuPrincipal(){
        int opcio = 0;

        do {

                System.out.println("\nSelecciona una opció");
                System.out.println("\n0. Sortir");
                System.out.println("\n1. Gestió de regions");
                System.out.println("\n2. Gestió de comarques");
                System.out.println("\n3. Gestió de ciutats");
                System.out.println("\n4. Gestió de pobles");
                System.out.println("\n5. Gestió de zones rurals");
                opcio = DADES.nextInt();

                switch (opcio) {
                    case 0:
                        break;
                    case 1:
                        menuRegions();
                        break;
                    case 2:
                        if (regioActual != null) {
                            menuComarques();
                        } else {
                            System.out.println("\nPrimer s'ha de seleccionar la regió al menú Gestió de regions");
                        }
                        break;
                    case 3:
                        if (regioActual != null) {
                            menuPoblacions(1);
                        } else {
                            System.out.println("\nPrimer s'ha de seleccionar la regió al menú Gestió de regions");
                        }
                        break;
                    case 4:
                        if (regioActual != null) {
                            menuPoblacions(2);
                        } else {
                            System.out.println("\nPrimer s'ha de seleccionar la regió al menú Gestió de regions");
                        }
                        break;
                    case 5:
                        if (regioActual != null) {
                            menuPoblacions(3);
                        } else {
                            System.out.println("\nPrimer s'ha de seleccionar la regió al menú Gestió de regions");
                        }
                        break;
                    default:
                        System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                        break;
                }

        } while (opcio != 0);
    }

    public static void menuRegions(){
        int opcio;

        do {
            int indexSel;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llista de regions");
            System.out.println("\n5. Carregar regió");
            System.out.println("\n6. Desar regió");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    Regio novaRegio = Regio.addRegio();

                    indexSel = selectRegio(novaRegio);

                    if (indexSel == -1) {
                        regions[pRegions] = novaRegio;
                        pRegions++;
                    } else {
                        System.out.println("\nLa regió ja existeix");
                    }
                    break;
                case 2:
                    indexSel = selectRegio(null);
                    if (indexSel >= 0) {
                        regioActual = regions[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta regió");
                    }
                    break;
                case 3:
                    indexSel = selectRegio(null);
                    if (indexSel >= 0) {
                        regions[indexSel].updateTerritori();
                    } else {
                        System.out.println("\nNo existeix aquesta regió");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pRegions; i++) {
                        regions[i].showTerritori();
                    }
                    break;
                case 5: //Carregar regio
                    pRegions = 0;
                    regions = new Regio[1]; //Per facilitar la feina, només podem carregar una regió
                    gp.carregarRegio("XML", FITXER);
                    regions[pRegions] = (gp.getGestor()).getRegio();
                    pRegions++;
                    break;

                case 6: //Desar regió
                    int pos = selectRegio(null);
                    if (pos >= 0) {
                        gp.desarRegio("XML", FITXER, regions[pos]);
                    } else {
                        System.out.println("\nNo existeix aquesta regió");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    
    public static void menuComarques(){
        int opcio;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista de comarques");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    regioActual.addComarca();
                    break;
                case 2:
                    int indexSel = regioActual.selectComarca(null);
                    if (indexSel >= 0) {
                        regioActual.getComarques()[indexSel].updateTerritori();
                    } else {
                        System.out.println("\nNo existeix aquesta comarca");
                    }
                    break;
                case 3:
                    for (int i = 0; i < regioActual.getpComarques(); i++) {
                        regioActual.getComarques()[i].showTerritori();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    
    public static void menuPoblacions(int tipus) throws InputMismatchException {
        int opcio;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    switch (tipus) {
                        case 1:
                            regioActual.addCiutatComarca();
                            break;
                        case 2:
                            regioActual.addPobleComarca();
                            break;
                        case 3:
                            regioActual.addZonaRuralComarca();
                            break;
                    }
                    break;
                case 2:
                    switch (tipus) {
                        case 1:
                            regioActual.updateCiutatComarca();
                            break;
                        case 2:
                            regioActual.updatePobleComarca();
                            break;
                        case 3:
                            regioActual.updateZonaRuralComarca();
                            break;
                    }
                    break;
                case 3:
                    for (int i = 0; i < regioActual.getpComarques(); i++) {

                        for (int j = 0; j < regioActual.getComarques()[i].getpPoblacions(); j++) {
                            
                            if (regioActual.getComarques()[i].getPoblacions()[j] instanceof Ciutat && tipus == 1) {
                                regioActual.getComarques()[i].getPoblacions()[j].showTerritori();
                            } else if (regioActual.getComarques()[i].getPoblacions()[j] instanceof Poble && tipus == 2) {
                                regioActual.getComarques()[i].getPoblacions()[j].showTerritori();
                            } else if (regioActual.getComarques()[i].getPoblacions()[j] instanceof ZonaRural && tipus == 3) {
                                regioActual.getComarques()[i].getPoblacions()[j].showTerritori();
                            }
   
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static Integer selectRegio(Regio regio) {

        String nom;

        if (regio == null) {
            System.out.println("\nNom de la regió?:");
            DADES.nextLine(); //Neteja buffer
            nom = DADES.nextLine();
        } else {

            nom = regio.getNom();
        }

        for (int i = 0; i < pRegions; i++) {
            if (regions[i].getNom().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
    
}
