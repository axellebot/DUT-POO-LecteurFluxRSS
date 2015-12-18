package axel;

import axel.model.EnsembleFlux;
import axel.model.FluxRSS;
import axel.view.Vue_Principal;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EnsembleFlux ensembleFlux = new EnsembleFlux();
        FluxRSS flux_leMonde=new FluxRSS("http://www.lemonde.fr/m-actu/rss_full.xml");
        FluxRSS flux_net=new FluxRSS("http://www.01net.com/rss/actualites/jeux/");
        ensembleFlux.addFlux(flux_leMonde);
        ensembleFlux.addFlux(flux_net);

        //UserInterface
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        //IHM
        Vue_Principal _fenetre = new Vue_Principal(ensembleFlux);
        _fenetre.pack();
        RefineryUtilities.centerFrameOnScreen(_fenetre);
        _fenetre.setVisible(true);
        _fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
