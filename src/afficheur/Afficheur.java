package afficheur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import canal.CapteurAsync;


public class Afficheur implements ObserverDeCapteur {

    private int currentMaxValue = -1;
    private List<Integer> receivedValues;

    public Afficheur() {
        this.receivedValues = new ArrayList<Integer>();
    }



    @Override
    public void update(CapteurAsync ca){
      Future to_ret =  ca.getValue();
      try {
          Integer a = (Integer) to_ret.get();
          if (a>currentMaxValue){
              receivedValues.add(a);
              currentMaxValue=a;
          }
          else{
              //System.out.println("date de péremption dépassé");
          }
      }
      catch (Exception e){e.printStackTrace();}

    }

    public List<Integer> getReceivedValues() {
        return this.receivedValues;
    }

    public int getNumberOfValues() {
        return this.receivedValues.size();
    }


}
