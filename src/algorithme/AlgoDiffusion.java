package algorithme;

import capteur.Capteur;

/**
 * @Author  Nicolas demongeot Paul Borie
 */
public interface AlgoDiffusion {

    /**
     * Sert à définir l'état du système lors de l'execution des algorithmes de diffusion*
     */
    /**
     * Execute l'algorithme de diffusion.
     * Appeler l'éxécution de l'algorithme avant de l'avoir configuré avec la fonction prévue à cet effet
     * resulte en une erreur java.lang.AssertionError.
     * @throws InterruptedException
     * @throws java.lang.AssertionError
     */
    void execute() throws InterruptedException;

    /**
     * Permet de déverouiller N sémaphores pour permettre l'éxécution de l'algorithme de diffusion suivant.
     * @param n, nombre de sémaphore
     */
    void unlock(int n);

    /**
     * Configure l'algorithme de diffusion.
     * Doit être éxécuté avant de faire appel à l'execution de celui-ci.
     * @param capteur
     * @param nbCanaux
     */
    void configure(Capteur capteur, int nbCanaux);

}