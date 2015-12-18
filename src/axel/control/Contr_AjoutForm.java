package axel.control;

import axel.model.EnsembleFlux;
import axel.model.FluxRSS;

import java.util.ArrayList;

/**
 * Created by axell on 15/12/15.
 */
public class Contr_AjoutForm extends AbstractControleur {
    public Contr_AjoutForm(EnsembleFlux ensembleFlux) {
        this.ensembleFlux = ensembleFlux;
    }

    @Override
    public void control(FluxRSS fluxRSS) {
        if (fluxRSS != null) {
            this.ensembleFlux.addFlux(fluxRSS);
            this.ensembleFlux.notifyObservateur();
        }
    }
}
