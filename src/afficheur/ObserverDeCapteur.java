package afficheur;

import canal.CapteurAsync;
/**@Author  Nicolas Demongeot Paul Borie
 * */
public interface ObserverDeCapteur{
    /**@param  canal Canal sur lequel on va récupéré la valeur du capteur en appelant la methode getValue dessus.
     *
     * */
    void update(CapteurAsync canal);

}
