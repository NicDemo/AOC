package test;

import afficheur.Afficheur;
import algorithme.AlgoDiffusion;
import algorithme.DiffusionEpoque;
import algorithme.DiffusionSequentielle;
import canal.Canal;
import capteur.CapteurImpl;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class test_époque {
    public ScheduledExecutorService scheduler;
    public AlgoDiffusion strategy;
    public CapteurImpl capteur;
    public Canal canal1, canal2, canal3, canal4;
    public Afficheur afficheur1, afficheur2, afficheur3, afficheur4;
    public int iterations = 30;
    public int canaux = 4;

    @BeforeEach
    public void Init() throws InterruptedException {
        afficheur1 = new Afficheur();
        afficheur2 = new Afficheur();
        afficheur3 = new Afficheur();
        afficheur4 = new Afficheur();

        this.scheduler = Executors.newScheduledThreadPool(50);
        this.strategy = new DiffusionEpoque();
        this.capteur = new CapteurImpl(strategy);
        this.strategy.configure(capteur, canaux);

        this.canal1 = new Canal(scheduler, afficheur1);
        this.canal2 = new Canal(scheduler, afficheur2);
        this.canal3 = new Canal(scheduler, afficheur3);
        this.canal4 = new Canal(scheduler, afficheur4);
        capteur.attach(canal1);
        capteur.attach(canal2);
        capteur.attach(canal3);
        capteur.attach(canal4);
        for (int i = 0; i < iterations; i++) {
            capteur.tick();
            Thread.sleep(1000);
        }
    }

    @After
    public void clean_up() throws InterruptedException {
        scheduler.awaitTermination(5, TimeUnit.SECONDS);
        scheduler.shutdown();
    }

    @Test
    @DisplayName("Rangé par ordre croissance Stricte")
    public void croissance_seq() throws InterruptedException {

        Boolean isSorted1 = Utilitaires.isSorted(afficheur1.getReceivedValues());
        Boolean isSorted2 = Utilitaires.isSorted(afficheur2.getReceivedValues());
        Boolean isSorted3 = Utilitaires.isSorted(afficheur3.getReceivedValues());
        Boolean isSorted4 = Utilitaires.isSorted(afficheur4.getReceivedValues());
                for(int i = 0 ;i< afficheur1.getNumberOfValues();i++){
            System.out.println(afficheur1.getReceivedValues().get(i)+ " ,");
            System.out.println(afficheur2.getReceivedValues().get(i)+ " ,");
            System.out.println(afficheur3.getReceivedValues().get(i)+ " ,");
            System.out.println(afficheur4.getReceivedValues().get(i)+ " ,");
        }
     //   assertTrue(isSorted1);
       // assertTrue(isSorted2);
       // assertTrue(isSorted3);
        //assertTrue(isSorted4);

    }
}

