package algorithme;

import capteur.Capteur;

/** @Author Nicolas Demongeot Paul Borie
 *  Strategy de diffusion par époque
 *  les afficheurs ne prennent en compte que les valeurs qu'ils reçoivent seulement si la valeur reçu est supérieur a toutes celles déjà reçu.
 *  (le comportement est directement traité dans les afficheurs)
 *
 */
public class DiffusionEpoque implements  AlgoDiffusion{
    Capteur capteur;
    Boolean isConfig=false;
    @Override
    public void execute() throws InterruptedException {
    if(isConfig){
        this.capteur.saveValue();
        this.capteur.notifyObservateurs();

    }
    else{throw  new InterruptedException("strategy not configured");}
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
