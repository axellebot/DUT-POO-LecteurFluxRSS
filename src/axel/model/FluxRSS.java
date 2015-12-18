package axel.model;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axell on 15/12/15.
 */
public class FluxRSS {
    String url, nom, description;
    Integer id;
    Boolean affiche; //true si afficher sinon false;

    public FluxRSS(String url) {
        this.url = url;

        Boolean titreTrouve=false,descriptionTrouve=false;

        ArrayList<Data> listData = new ArrayList<Data>();

        SAXBuilder builder = new SAXBuilder();

        try {

            Document document = (Document) builder.build(new URL(this.url));
            Element rootNode = document.getRootElement();
            Element channelNode = rootNode.getChild("channel");

            List contenuChannel = channelNode.getChildren();

            for (int i = 0; i < contenuChannel.size()&&!(titreTrouve&&descriptionTrouve); i++) {
                Element nodeItemChannel = (Element) contenuChannel.get(i);

                switch (nodeItemChannel.getName()) {
                    case "title":
                        System.out.println("Titre : " + nodeItemChannel.getText());
                        this.setNom(nodeItemChannel.getText());
                        titreTrouve=true;
                        break;
                    case "description":
                        System.out.println("Description : " + nodeItemChannel.getText());
                        this.setDescription(nodeItemChannel.getText());
                        descriptionTrouve=true;
                        break;
                }
            }


        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }

    public FluxRSS(String url, String nom, Integer id, Boolean affiche) {
        this.url = url;
        this.nom = nom;
        this.id = id;
        this.affiche = affiche;
    }

    //-----------------Fonctions Usuelles-----------------//
    public ArrayList<Data> extract() {
        ArrayList<Data> listData = new ArrayList<Data>();

        SAXBuilder builder = new SAXBuilder();

        try {

            Document document = (Document) builder.build(new URL(this.url));
            Element rootNode = document.getRootElement();
            Element channelNode = rootNode.getChild("channel");

            List contenuChannel = channelNode.getChildren();

            for (int i = 0; i < contenuChannel.size(); i++) {
                Element nodeItemChannel = (Element) contenuChannel.get(i);

                if (nodeItemChannel.getName() == "item") {
                    System.out.println("\n");
                    System.out.println("Lien : " + nodeItemChannel.getChildText("link"));
                    System.out.println("Titre : " + nodeItemChannel.getChildText("title"));
                    System.out.println("Description : " + nodeItemChannel.getChildText("description"));
                    System.out.println("Date de publication : " + nodeItemChannel.getChildText("pubDate"));
                    System.out.println("Guid : " + nodeItemChannel.getChildText("guid"));
                    System.out.println("Enclosure : " + nodeItemChannel.getChildText("enclosure"));
                    System.out.println("\n");

                    Data _data = new Data(nodeItemChannel.getChildText("title"),
                            nodeItemChannel.getChildText("link"),
                            nodeItemChannel.getChildText("description"));

                    listData.add(_data);

                }
            }


        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }


        return listData;
    }

    public String toString() {
        return this.nom;
        //return this.nom+"<"+this.url+">";
    }

    //-----------------GETTER + SETTER-----------------//
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAffiche() {
        return affiche;
    }

    public void setAffiche(Boolean affiche) {
        this.affiche = affiche;
    }
}
