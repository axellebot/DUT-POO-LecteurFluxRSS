package axel.view;

import axel.control.Contr_CheckListFlux;
import axel.control.Contr_DeleteListFlux;
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
public class Vue_ListeFlux extends JPanel implements Observateur {
    private EnsembleFlux ensembleFlux;

    private JScrollPane scrollPane;
    private JList jList;
    private JButton btnCheck,btnDelete;
    private DefaultListModel defaultListModel;

    private Contr_CheckListFlux controlCheck;
    private Contr_DeleteListFlux controlDelete;

    public Vue_ListeFlux(EnsembleFlux ensembleFlux) {
        this.setBorder(BorderFactory.createTitledBorder("Flux enregistrés"));

        this.ensembleFlux = ensembleFlux;
        this.ensembleFlux.addObservateur(this);

        //Controlleur
        this.controlCheck = new Contr_CheckListFlux(this.ensembleFlux);
        this.controlDelete=new Contr_DeleteListFlux(this.ensembleFlux);

        this.btnCheck = new JButton("Check");
        this.btnDelete=new JButton("Supprimer");

        // Create some items to add to the list
        this.defaultListModel = new DefaultListModel();
        this.jList = new JList();

        // Create a scrollPanel to hold all other components
        this.scrollPane = new JScrollPane(this.jList);


        //Layout
        this.setLayout(new GridBagLayout());

        //Constraint
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = gbc.gridwidth = 1;
        gbc.weightx = gbc.weighty = 1;
        gbc.gridx = gbc.gridy = 0;

        //ajout à la fenetre
        gbc.weighty = 50;
        this.add(this.scrollPane, gbc);
        gbc.gridy = 1;
        gbc.weighty = 1;
        this.add(this.btnCheck, gbc);
        gbc.gridy++;
        this.add(this.btnDelete,gbc);

        //listener
        this.btnCheck.addActionListener(new Ecouteur_Check1());
        this.btnDelete.addActionListener(new Ecouteur_Delete());

        this.jList.setListData(this.ensembleFlux.getListFlux().toArray());
    }

    @Override
    public void update() {
        // Create some items to add to the list
        jList.setListData(this.ensembleFlux.getListFlux().toArray());
        // jList.setSelectedValue(this.ensembleFlux.getFluxCourant(), true);

        this.revalidate();
        this.repaint();
    }

    class Ecouteur_Check1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCheck) {
                controlCheck.control((FluxRSS) jList.getSelectedValue());
            }
        }
    }

    class Ecouteur_Delete implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnDelete) {
                controlDelete.control((FluxRSS) jList.getSelectedValue());
            }
        }
    }
}

