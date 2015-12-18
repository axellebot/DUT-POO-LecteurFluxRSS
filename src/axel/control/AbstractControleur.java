package axel.control;

import axel.model.EnsembleFlux;
import axel.model.FluxRSS;

import java.util.ArrayList;

/**
 * Created by axell on 01/12/15.
 */
public abstract class AbstractControleur {
    protected EnsembleFlux ensembleFlux;
    abstract public void control(FluxRSS fluxRSS);
}
