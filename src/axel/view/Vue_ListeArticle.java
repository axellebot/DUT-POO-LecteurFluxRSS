package axel.view;

import axel.control.Observateur;
import axel.model.Data;
import axel.model.EnsembleFlux;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by axell on 15/12/15.
 */
public class Vue_ListeArticle extends JPanel implements Observateur {

    private EnsembleFlux ensembleFlux;

    private JScrollPane scrollPane;
    private JList jList;
    private JTextPane descriptionPane;
    private ArrayList<Data> listArticle;
    private DefaultListModel defaultListModel;

    public Vue_ListeArticle(EnsembleFlux ensembleFlux) {
        this.setBorder(BorderFactory.createTitledBorder("Liste des articles"));

        this.ensembleFlux = ensembleFlux;
        this.ensembleFlux.addObservateur(this);

        this.listArticle = new ArrayList<>();

        //Panel interne "description"
        this.descriptionPane = new JTextPane();
        this.descriptionPane.setBorder(BorderFactory.createTitledBorder("Description"));

        // Create some items to add to the jList
        this.defaultListModel=new DefaultListModel();
        this.jList = new JList(this.defaultListModel);

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
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        this.add(this.descriptionPane, gbc);

        //listener
        this.jList.addListSelectionListener(new Ecouteur_SelectArticle());

    }

    @Override
    public void update() {
        if (this.ensembleFlux.getFluxCourant() != null) {
            this.jList.setListData(this.ensembleFlux.getFluxCourant().extract().toArray());
        }else{
            this.defaultListModel.removeAllElements();
        }
        this.descriptionPane.setText("");
        this.revalidate();
        this.repaint();
    }

    class Ecouteur_SelectArticle implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            descriptionPane.setText(((Data)jList.getSelectedValue()).getDescription());
        }
    }
}
