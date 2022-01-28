package client;

import  afficheur.Afficheur;
import algorithme.AlgoDiffusion;
import algorithme.DiffusionAtomic;
import algorithme.DiffusionEpoque;
import algorithme.DiffusionSequentielle;
import canal.Canal;
import capteur.CapteurImpl;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) throws InterruptedException {


        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(50);
        AlgoDiffusion strategy;
        Scanner scan  = new Scanner(System.in);
        System.out.println("select Strategy number  {1,2,3}: 1-Atomic 2-sequentielle 3-epoque :");
        String strat = scan.next();
        System.out.println("strategy = "+strat );
        switch (strat) {
            case "1": strategy = new DiffusionAtomic();break;
            case"2" : strategy=new DiffusionSequentielle();break;
            case "3" : strategy= new DiffusionEpoque();break;
             default: strategy =new DiffusionAtomic();break;
        }
        CapteurImpl capteur = new CapteurImpl(strategy);

        Afficheur afficheur1 = new Afficheur();
        Afficheur afficheur2 = new Afficheur();
        Afficheur afficheur3 = new Afficheur();
        Afficheur afficheur4 = new Afficheur();

        Canal canal1 = new Canal(scheduler, afficheur1);
        Canal canal2 = new Canal(scheduler, afficheur2);
        Canal canal3 = new Canal(scheduler, afficheur3);
        Canal canal4 = new Canal(scheduler, afficheur4);


        capteur.attach(canal1);
        capteur.attach(canal2);
        capteur.attach(canal3);
        capteur.attach(canal4);

        strategy.configure(capteur, 4);

        int iterations = 30;
        for(int i = 0; i<iterations;i++) {
            capteur.tick();
          System.out.println("iteration"+i);
            Thread.sleep(300);
        }
        scheduler.awaitTermination(5, TimeUnit.SECONDS);
        scheduler.shutdown();
      System.out.print("Résultats test : \n Afficheur 1 : ");
        for(int i = 0 ;i< afficheur1.getNumberOfValues();i++){
            System.out.print(afficheur1.getReceivedValues().get(i)+ ", ");
        }
        System.out.print(" \nAfficheur 2 : ");
        for(int i = 0 ;i< afficheur2.getNumberOfValues();i++){
            System.out.print(afficheur2.getReceivedValues().get(i)+ " ,");
        }

        System.out.print(" \n Afficheur 3 : ");

        for(int i = 0 ;i< afficheur3.getNumberOfValues();i++){
            System.out.print(afficheur3.getReceivedValues().get(i)+ " ,");
        }
        System.out.print("\n Afficheur 4 : ");

        for(int i = 0 ;i< afficheur4.getNumberOfValues();i++){
            System.out.print(afficheur4.getReceivedValues().get(i)+ " ,");
        }
        System.out.println();


    }


}
