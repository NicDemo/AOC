package canal;

import capteur.Capteur;

import java.util.concurrent.Future;

/**
 * @Author  Nicolas demongeot Paul Borie
 */
public interface ObserverDeCapteurAsync {

    /**
     * Enqueue une methode m dans le scheldulerExecutorService avec un délai.
     * cette methode m Appelle la méthode upDate de l'afficheur.
     * elle fait le lien entre le capteur et l'afficheur.
     */
    Future<?> update(Capteur capteur);
}

