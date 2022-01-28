package algorithme;

import capteur.Capteur;


/**Concrete Algorithm dans le cadre du pattern Strategy.
 * Strategy de diffusion par époque
 * les afficheurs ne prennent en compte que les valeurs qu'ils reçoivent seulement si la valeur reçu est supérieur a toutes celles déjà reçu.
 * (le comportement est directement traité dans les afficheurs)
 * @Author Nicolas Demongeot Paul Borie jean derieux
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
