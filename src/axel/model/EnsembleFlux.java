package axel.model;

import axel.control.Observable;
import axel.control.Observateur;

import java.util.ArrayList;

/**
 * Created by axell on 15/12/15.
 */
public class EnsembleFlux implements Observable {
    FluxRSS fluxCourant;
    ArrayList<FluxRSS> listFlux;
    private ArrayList<Observateur> listObservateur;


    public EnsembleFlux() {
        this.listFlux=new ArrayList<FluxRSS>();
        this.listObservateur =new ArrayList<Observateur>();
    }

    public void addFlux(FluxRSS flux) {
        listFlux.add(flux);
        System.out.println(flux+" -> ajouté");
        this.notifyObservateur();
    }

    public void removeFlu(FluxRSS flux) {
        listFlux.remove(flux);
        System.out.println(flux + " -> supprimé");
    }

    @Override
    public void addObservateur(Observateur observateur) {
        listObservateur.add(observateur);
    }

    @Override
    public void removeObservateur(Observateur observateur) {
        listObservateur.remove(observateur);
    }

    @Override
    public void notifyObservateur() {
        for (int i = 0; i < this.listObservateur.size(); i++) {
            listObservateur.get(i).update();
        }
    }

    public FluxRSS getFluxCourant() {
        return fluxCourant;
    }

    public void setFluxCourant(FluxRSS fluxCourant) {
        this.fluxCourant = fluxCourant;
    }

    public ArrayList<FluxRSS> getListFlux() {
        return listFlux;
    }

    public void setListFlux(ArrayList<FluxRSS> listFlux) {
        this.listFlux = listFlux;
    }
}
