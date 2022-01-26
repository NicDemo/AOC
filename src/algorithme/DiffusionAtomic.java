package algorithme;

import capteur.Capteur;

import java.util.concurrent.Semaphore;

public class DiffusionAtomic implements  AlgoDiffusion{
    private Capteur capteur;
    private Semaphore semaphore;
    private boolean configured = false;
    @Override
    public void execute() throws InterruptedException {
        if(configured){
        semaphore.acquire(capteur.getCanaux().size());
        this.capteur.saveValue();
        this.capteur.notifyObservateurs();
        }
        else{throw new InterruptedException("strat non configuré");}


    }

    @Override
    public void unlock(int n) {
    this.semaphore.release(n);
    }

    @Override
    public void configure(Capteur capteur, int Canaux) {
    this.capteur=capteur;
    this.semaphore=new Semaphore(Canaux);
    this.configured=true;
    }
}
