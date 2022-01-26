package capteur;

import algorithme.AlgoDiffusion;
import canal.ObserverDeCapteurAsync;
import capteur.Capteur;

import java.util.ArrayList;
import java.util.List;

public class CapteurImpl implements Capteur {

    private final static int START_VALUE = 1;

    private List<ObserverDeCapteurAsync> canaux = new ArrayList<>() {
    };
    private AlgoDiffusion algoDiffusion;
    private Integer value = Integer.valueOf(START_VALUE);
    private Integer savedValue = Integer.valueOf(START_VALUE);


    public CapteurImpl(AlgoDiffusion algo) {
        this.algoDiffusion = algo;
    }

    @Override
    public void attach(ObserverDeCapteurAsync canal) {
        this.canaux.add(canal);
    }

    @Override
    public void detach(ObserverDeCapteurAsync canal) {
        this.canaux.remove(canal);
    }

    @Override
    public Integer getValue() {
        Integer toReturn = Integer.valueOf(this.savedValue);
        this.unlock(1);
        return toReturn;
    }

    @Override
    public void tick() {
        try {
            this.algoDiffusion.execute();
            this.value++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void unlock(int n) {
        this.algoDiffusion.unlock(n);
    }


    @Override
    public void saveValue() {
        this.savedValue = this.value;
    }

    @Override
    public List<ObserverDeCapteurAsync> getCanaux() {
        return this.canaux;
    }

    @Override
    public void notifyObservateurs() {
        for (ObserverDeCapteurAsync obs : this.canaux) {
            obs.update(this);
        }
    }

}