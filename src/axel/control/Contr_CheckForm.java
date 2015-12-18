package axel.control;

import axel.model.EnsembleFlux;
import axel.model.FluxRSS;

import java.util.ArrayList;

/**
 * Created by axell on 15/12/15.
 */
public class Contr_CheckForm extends AbstractControleur  {
    public Contr_CheckForm(EnsembleFlux ensembleFlux) {
        this.ensembleFlux=ensembleFlux;
    }

    @Override
    public void control(FluxRSS fluxRSS) {
        if(fluxRSS !=null){
            this.ensembleFlux.setFluxCourant(fluxRSS);
            this.ensembleFlux.notifyObservateur();
        }
    }
}
