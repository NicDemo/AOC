package capteur;

import canal.ObserverDeCapteurAsync;

import java.util.List;

public interface Capteur {

    void attach(ObserverDeCapteurAsync canal);

    void detach(ObserverDeCapteurAsync canal);
    Integer getValue();
    void tick();
    void notifyObservateurs();
    List<ObserverDeCapteurAsync> getCanaux();
    void unlock(int n);
    void saveValue();
}
