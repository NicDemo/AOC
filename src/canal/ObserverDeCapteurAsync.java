package canal;

import capteur.Capteur;

import java.util.concurrent.Future;

public interface ObserverDeCapteurAsync {

    Future<?> update(Capteur capteur);
}

