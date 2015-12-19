package axel.control;

import axel.model.EnsembleFlux;
import axel.model.FluxRSS;

/**
 * Created by axell on 15/12/15.
 */
public class Contr_DeleteListFlux extends AbstractControleur {
    public Contr_DeleteListFlux(EnsembleFlux ensembleFlux) {
        this.ensembleFlux = ensembleFlux;
    }

    @Override
    public void control(FluxRSS fluxRSS) {
        if (fluxRSS != null) {
            this.ensembleFlux.removeFlux(fluxRSS);
        }
        this.ensembleFlux.notifyObservateur();
    }
}
