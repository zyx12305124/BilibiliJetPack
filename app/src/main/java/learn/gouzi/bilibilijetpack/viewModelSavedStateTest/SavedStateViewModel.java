package learn.gouzi.bilibilijetpack.viewModelSavedStateTest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import learn.gouzi.bilibilijetpack.viewModelTest.MainActivity;


public class SavedStateViewModel extends ViewModel {
//    private MutableLiveData<Integer> aScore;
    private SavedStateHandle handle;

    public SavedStateViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getaScore(){
        if(!handle.contains(SavedStateActivity.KEY_NUMBER)){
            handle.set(SavedStateActivity.KEY_NUMBER,0);
            //public <T>void set(String key, Integer value) 这个泛型什么意思
        }
        return handle.getLiveData(SavedStateActivity.KEY_NUMBER);
//        if (aScore==null){
//            aScore = new MutableLiveData<>();
//            aScore.setValue(0);
//        }
//        return aScore;
    }

    public void aAdd(int n){
        getaScore().setValue(getaScore().getValue()+n);
    }

}
