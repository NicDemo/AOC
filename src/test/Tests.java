package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import afficheur.Afficheur;
import algorithme.AlgoDiffusion;
import algorithme.DiffusionSequentielle;
import canal.Canal;
import capteur.CapteurImpl;

import static org.junit.Assert.*;

public class Tests {
    public ScheduledExecutorService scheduler ;
    public AlgoDiffusion strategy;
    public CapteurImpl capteur= new CapteurImpl(strategy);
    public Canal canal1,canal2,canal3,canal4;
    public Afficheur afficheur1,afficheur2,afficheur3,afficheur4;
    public int iterations = 20;
    @BeforeEach
    @DisplayName("test egalité")
    public void Init() {
        this.scheduler = Executors.newScheduledThreadPool(50);
        this.strategy = new DiffusionSequentielle();
        this.capteur = new CapteurImpl(strategy);
        this.strategy.configure(capteur, 4);

        this.canal1= new Canal(scheduler, afficheur1);
        this.canal2=new Canal(scheduler, afficheur2);
        this.canal3=new Canal(scheduler, afficheur3);
        this.canal4=new Canal(scheduler, afficheur4);
        capteur.attach(canal1);
        capteur.attach(canal2);
        capteur.attach(canal3);
        capteur.attach(canal4);

    }
    @After
    void clean_up() throws InterruptedException {
        scheduler.awaitTermination(10, TimeUnit.SECONDS);
        scheduler.shutdown();
    }

    @Test
    public void Test_equality() throws InterruptedException {
        for(int i = 0; i<iterations;i++) {
            capteur.tick();
            Thread.sleep(100);
        }
        Thread.sleep(200);
        //Assertions.assertEquals(afficheur1.getReceivedValues(),afficheur2.getReceivedValues());
        assertEquals(afficheur3.getNumberOfValues(),afficheur4.getNumberOfValues());
      //  Assertions.assertEquals(afficheur3.getReceivedValues().size(),afficheur4.getReceivedValues().size());
    }



}