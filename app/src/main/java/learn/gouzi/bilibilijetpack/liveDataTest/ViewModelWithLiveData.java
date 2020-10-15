package learn.gouzi.bilibilijetpack.liveDataTest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 定义livedata 保证数不为空
 * 初始化livedata里面的数据
 * 保证获取到的变量不为null
 *
 * addNumber()
 */
public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> likedNumber;

    public MutableLiveData<Integer> getLikedNumber(){
        if (likedNumber==null){
            this.likedNumber = new MutableLiveData<>();
            likedNumber.setValue(0);
        }
        return likedNumber;
    }

    public void addNumber(int n){
        likedNumber.setValue(likedNumber.getValue()+n);
    }
}
