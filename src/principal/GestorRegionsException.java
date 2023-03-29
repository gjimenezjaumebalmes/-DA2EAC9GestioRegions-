package principal;

/**
 *
 * @author fta
 */
public class GestorRegionsException extends Exception {

    private String codiCausa = "desconegut";
    private String missatge;

    public GestorRegionsException(String codiCausa) {
        this.codiCausa = codiCausa;
        switch (codiCausa) {
            case "1":
                missatge = "L'opció introduïda no és numèrica";
                break;
            case "2":
                missatge = "Ja no hi caben més regions";
                break;
            case "3":
                missatge = "La regió ja existeix";
                break;
            case "GestorXML.model":
                missatge = "No s'ha pogut crear el model XML per desar la regió";
                break;
            case "GestorXML.desar":
                missatge = "No s'ha pogut desar la regió a causa d'error d'entrada/sortida";
                break;
            case "GestorXML.carrega":
                missatge = "No s'ha pogut carregar la regió a causa d'error d'entrada/sortida";
                break;
            default:
                missatge = "Error desconegut";
                break;
        }
    }

    public String getMessage() {

    }
}
