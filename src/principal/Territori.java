/*
 * Interfície que implementarà qualsevol territori
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public interface Territori {  
    
    public final static Scanner DADES = new Scanner(System.in);
    
    public void updateTerritori(); 
    public void showTerritori();     
    
}
