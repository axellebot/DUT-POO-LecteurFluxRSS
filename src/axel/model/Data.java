package axel.model;

/**
 * Created by axell on 15/12/15.
 */
public class Data {
    String titre,lien,description;

    public Data(String titre, String lien, String description) {
        this.titre = titre;
        this.lien = lien;
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //-----------------Fonctions Usuelles-----------------//
    public String toString(){
        return this.titre;
    }
}
