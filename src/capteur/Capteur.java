package capteur;

import canal.ObserverDeCapteurAsync;

import java.util.List;

/**
 * @Author Nicolas Demongeot Paul Borie
 *
 */
public interface Capteur {

    /**@param canal abonne un canal au capteur pour la notification d'update
     * */
    void attach(ObserverDeCapteurAsync canal);
    /**@param canal désabonne le canal pour ne pas recevoir les notifications (never used)
     **/
    void detach(ObserverDeCapteurAsync canal);
    /**
     * @return la valeur à envoyer aux afficheurs
     * */
    Integer getValue();
    /**
     * Execute la methode execute de la stratégie et Incrémente
     * */
    void tick();
    /**
     * Notifie les observeurs attach au capteur
     * */
    void notifyObservateurs();
    List<ObserverDeCapteurAsync> getCanaux();
    /**
     * Libére n sémaphore contenu dans la strategy
     * */
    void unlock(int n);

    /**
     * sauvegarde la valeur a l'instant t, cette valeur est celle transmise aux afficheur lors de la notification.
     */
    void saveValue();
}
