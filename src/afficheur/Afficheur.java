package afficheur;

import java.util.ArrayList;
import java.util.List;

import canal.CapteurAsync;


public class Afficheur implements ObserverDeCapteur {

    private int currentMaxValue = -1;
    private List<Integer> receivedValues;

    public Afficheur() {
        this.receivedValues = new ArrayList<Integer>();
    }



    @Override
    public void update(CapteurAsync ca){

    }

    public List<Integer> getReceivedValues() {
        return this.receivedValues;
    }

    public int getNumberOfValues() {
        return this.receivedValues.size();
    }


}
