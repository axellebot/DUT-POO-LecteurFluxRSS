package axel;

import axel.model.EnsembleFlux;
import axel.model.FluxRSS;
import axel.view.Vue_Principal;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");



        //UserInterface
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }
        if(netIsAvailable()) {
            EnsembleFlux ensembleFlux = new EnsembleFlux();
            FluxRSS flux_leMonde=new FluxRSS("http://www.lemonde.fr/m-actu/rss_full.xml");
            FluxRSS flux_net=new FluxRSS("http://www.01net.com/rss/actualites/jeux/");
            ensembleFlux.addFlux(flux_leMonde);
            ensembleFlux.addFlux(flux_net);

            //IHM
            Vue_Principal _fenetre = new Vue_Principal(ensembleFlux);
            _fenetre.pack();
            RefineryUtilities.centerFrameOnScreen(_fenetre);
            _fenetre.setVisible(true);
            _fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }else{
            JOptionPane.showMessageDialog(null, "Vous n'avez pas de connection internet !\nLe programme ne peut pas être lancé !");
        }
    }
    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
}
