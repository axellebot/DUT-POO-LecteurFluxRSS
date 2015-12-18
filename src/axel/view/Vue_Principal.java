package axel.view;

import axel.model.EnsembleFlux;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axell on 01/12/15.
 */
public class Vue_Principal extends JFrame {
    Vue_Form viewAjout;
    Vue_ListeArticle viewListeArticle;
    Vue_ListeFlux viewListeFlux;

    public Vue_Principal(EnsembleFlux ensembleFlux) {
        super("TP4");
        setResizable(true);

        this.viewAjout = new Vue_Form(ensembleFlux);
        this.viewListeArticle = new Vue_ListeArticle(ensembleFlux);
        this.viewListeFlux = new Vue_ListeFlux(ensembleFlux);

        //ajout à la fenetre avec les contraintes
        //Layout
        this.setLayout(new GridBagLayout());

        //Constraint
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = gbc.gridwidth = 1;
        gbc.weightx = gbc.weighty = 1;
        gbc.gridx = gbc.gridy = 0;

        //ajout
        gbc.gridheight = 2;
        this.add(viewListeFlux, gbc);
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.weightx=4;
        this.add(viewAjout, gbc);
        gbc.gridy = 1;
        gbc.weighty = 50;
        this.add(viewListeArticle, gbc);
    }
}
