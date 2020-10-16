package learn.gouzi.bilibilijetpack.scoreDemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by kila on 2020/10/16.
 */
public class ScoreViewModel extends ViewModel {
    private MutableLiveData<Integer> aScore;
    private MutableLiveData<Integer> bScore;
    private int aBack,bBack;

    public MutableLiveData<Integer> getaScore(){
        if (aScore==null){
            aScore = new MutableLiveData<>();
            aScore.setValue(0);
        }
        return aScore;
    }

    public MutableLiveData<Integer> getbScore(){
        if (bScore==null){
            bScore = new MutableLiveData<>();
            bScore.setValue(0);
        }
        return bScore;
    }

    public void aAdd(int n){
        aBack = aScore.getValue();
        aScore.setValue(aScore.getValue()+n);
    }

    public void bAdd(int n){
        bBack = bScore.getValue();
        bScore.setValue(bScore.getValue()+n);
    }

    public void reset(){
        aBack = aScore.getValue();
        bBack = bScore.getValue();
        aScore.setValue(0);
        bScore.setValue(0);
    }

    public void undo(){
        aScore.setValue(aBack);
        bScore.setValue(bBack);
    }

}
