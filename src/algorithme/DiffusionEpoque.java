package algorithme;

import capteur.Capteur;

public class DiffusionEpoque implements  AlgoDiffusion{
    Capteur capteur;
    Boolean isConfig=false;
    @Override
    public void execute() throws InterruptedException {
    if(isConfig){
        this.capteur.saveValue();
        this.capteur.notifyObservateurs();

    }
    else{throw  new InterruptedException("start non config");}
    }

    @Override
    public void unlock(int n) {
    }

    @Override
    public void configure(Capteur capteur, int Canaux) {
    this.capteur=capteur;
    this.isConfig=true;
    }
}
