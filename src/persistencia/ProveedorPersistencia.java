package persistencia;

import principal.GestorRegionsException;
import principal.Regio;


/**
 *
 * @author fta
 */
public interface ProveedorPersistencia {
    public void desarRegio(String nomFitxer, Regio regio)throws GestorRegionsException;
    public void carregarRegio(String nomFitxer)throws GestorRegionsException; 
}
