package canal;

import java.util.concurrent.Future;

/**
 * @Author Nicolas Demongeot Paul Borie
 */
public interface CapteurAsync {
    /**
     * Enqueue une methode m dans le scheldulerExecutorService avec un délai.
     * cette methode m Appelle la méthode getValue du capteur.
     * elle fait le lien entre l'afficheur  et le capteur.
     */
    Future<Integer> getValue();


}
