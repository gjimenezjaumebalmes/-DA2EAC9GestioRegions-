package persistencia;

import principal.GestorRegionsException;
import principal.Regio;


/**
 *
 * @author fta
 */
public class GestorPersistencia {

    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML pGestor) {
        gestor = pGestor;
    }

    public void desarRegio(String tipusPersistencia, String nomFitxer, Regio regio) throws GestorRegionsException {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarRegio(nomFitxer, regio);
        }
    }

    public void carregarRegio(String tipusPersistencia, String nomFitxer) throws GestorRegionsException {

        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.carregarRegio(nomFitxer);
        }
    }
}
