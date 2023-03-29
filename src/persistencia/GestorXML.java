package persistencia;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import principal.GestorRegionsException;
import principal.Regio;

/**
 *
 * @author fta
 */
public class GestorXML implements ProveedorPersistencia {

    private Document doc;
    private Regio regio;

    public Document getDoc() {
        return doc;
    }

    public Regio getRegio() {
        return regio;
    }

    @Override
    public void desarRegio(String nomFitxer, Regio regio) throws GestorRegionsException {
        construeixModel(regio);
        desarModel(nomFitxer);
    }

    @Override
    public void carregarRegio(String nomFitxer) throws GestorRegionsException {
        carregarFitxer(nomFitxer);
        llegirFitxerRegio();
    }

    /*Paràmetres: Regio a partir de la qual volem construir el model
     *
     *Acció: 
     * - Llegir els atributs de l'objecte regio passat per paràmetre per construir 
     *   un model (document XML) sobre el Document doc (atribut de GestorXML).
     *
     * - L'arrel del document XML és "regio". Aquesta arrel, l'heu d'afegir a doc. Un 
     *   cop fet això, heu de recórrer l'ArrayList comarques de la regió passada per
     *   paràmetre i per a cada comarca, afegir un fill a doc. Cada fill tindrà
     *   com atributs els atributs de l'objecte (nom, capital i les poblacions)
     *
     * - En el cas de les poblacions de cada comarca, heu de recórrer l'ArrayList 
     *   poblacions de la comarca corresponent i per a cada població, afegir un fill a doc,
     *   tenint en compte que hi haurà tres tipus d'elements, un per les ciutats, un altre pels
     *   pobles i un altre per les zones rurals. Cada fill tindrà com atributs els atributs de 
     *   l'objecte (codi, nom, etc.)
     *
     * - Si heu de gestionar alguna excepció relacionada amb la construcció del model,
     *   heu de llençar una excepció de tipus GestorRegionsException amb codi 
     *   "GestorXML.model".
     *
     *Retorn: cap
     */
    public void construeixModel(Regio regio) throws GestorRegionsException {

    }

    public void desarModel(String nomFitxer) throws GestorRegionsException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            File f = new File(nomFitxer + ".xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            throw new GestorRegionsException("GestorXML.desar");
        }
    }

    public void carregarFitxer(String nomFitxer) throws GestorRegionsException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            File f = new File(nomFitxer + ".xml");
            doc = builder.parse(f);
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            throw new GestorRegionsException("GestorXML.carrega");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     * - Llegir el fitxer del vostre sistema i carregar-lo sobre l'atribut doc, per
     *   assignar valors als atributs de la regió i la resta d'objectes que formen les
     *   comarques de la regió.
     *    
     * - Primer heu de crear l'objecte de la classe Regio a partir de l'arrel del document XML
     *   per després recórrer el doc i per cada fill, afegir un objecte a l'atribut comarques 
     *   de la regió mitjançant el mètode escaient de la classe Regio. Recordeu que com l'arrel conté
     *   els atributs nom i capital de la regió, al fer Element arrel = doc.getDocumentElement(); 
     *   ja podeu crear l'objecte de la classe.
     *
     *Retorn: cap
     */
    private void llegirFitxerRegio() throws GestorRegionsException {

    }
}
