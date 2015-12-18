package axel.view;

import axel.control.Contr_AjoutForm;
import axel.control.Contr_CheckForm;
import axel.control.Observateur;
import axel.model.EnsembleFlux;
import axel.model.FluxRSS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by axell on 15/12/15.
 */
public class Vue_Form extends JPanel {
    JTextField txtUrl;
    JButton btnCheck, btnEnregistrer;
    Contr_CheckForm controlCheck;
    Contr_AjoutForm controlAjout;

    EnsembleFlux ensembleFlux;

    public Vue_Form(EnsembleFlux ensembleFlux) {
        this.ensembleFlux = ensembleFlux;

        //Controlleur
        this.controlCheck = new Contr_CheckForm(this.ensembleFlux);
        this.controlAjout = new Contr_AjoutForm(this.ensembleFlux);

        //Composants
        this.txtUrl = new JTextField();
        this.txtUrl.setColumns(10);
        this.btnCheck = new JButton("Check");
        this.btnEnregistrer = new JButton("Enregistrer");
        //ajout contour
        this.setBorder(BorderFactory.createTitledBorder("Nouveau flux"));

        //ajout à la fenetre avec les contraintes
        //Layout
        this.setLayout(new GridBagLayout());

        //Constraint
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridheight = gbc.gridwidth = 1;
        gbc.weightx = gbc.weighty = 1;
        gbc.gridx = gbc.gridy = 0;

        //ajout fenetre
        this.add(new JLabel("Donner l'adresse du flux. http://"));
        gbc.gridx++;
        this.add(this.txtUrl, gbc);
        gbc.gridx++;
        this.add(this.btnCheck);
        gbc.gridx++;
        this.add(this.btnEnregistrer);

        //ajout Listener
        this.btnCheck.addActionListener(new Ecouteur_Check1());
        this.btnEnregistrer.addActionListener(new Ecouteur_Ajout());
    }

    class Ecouteur_Check1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCheck) {
                if (txtUrl != null) {
                    controlCheck.control(new FluxRSS("http://" + txtUrl.getText()));
                }
            }
        }
    }

    class Ecouteur_Ajout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnEnregistrer) {
                if (txtUrl.getText() != null) {
                    controlAjout.control(new FluxRSS("http://" + txtUrl.getText()));
                }
            }
        }
    }


}
