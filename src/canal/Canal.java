package canal;

import afficheur.Afficheur;
import capteur.Capteur;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements CapteurAsync, ObserverDeCapteurAsync {


    private final static int DELAY_UNIT = 1000;
    private ScheduledExecutorService scheduler;
    private Afficheur afficheur;
    private Capteur capteur;

    public Canal(ScheduledExecutorService scheduler, Afficheur afficheur){
        this.scheduler = scheduler;
        this.afficheur = afficheur;
    }


    @Override
    public Future<Integer> getValue() {
        return (Future<Integer>) scheduler.schedule(() ->{ return this.capteur.getValue();},
                (long)(Math.random()*DELAY_UNIT+DELAY_UNIT), TimeUnit.MILLISECONDS);
    }

    @Override
    public Future<?> update(Capteur capteur) {
        this.capteur = capteur;
        return scheduler.schedule(() ->{ afficheur.update(this);},
                (long)(Math.random()*DELAY_UNIT+DELAY_UNIT), TimeUnit.MILLISECONDS);
    }



}
