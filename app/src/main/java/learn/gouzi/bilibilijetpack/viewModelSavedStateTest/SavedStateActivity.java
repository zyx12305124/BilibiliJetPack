package learn.gouzi.bilibilijetpack.viewModelSavedStateTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import learn.gouzi.bilibilijetpack.R;
import learn.gouzi.bilibilijetpack.databinding.ActivitySavedStateBinding;
import learn.gouzi.bilibilijetpack.databinding.ActivityScoreBinding;
import learn.gouzi.bilibilijetpack.scoreDemo.ScoreViewModel;

import android.os.Bundle;
import android.os.PersistableBundle;

public class SavedStateActivity extends AppCompatActivity {
/**
 * ViewModelSavedState 即使进程在后台被系统杀死数据也存活
 */

    /**
     * 1.模拟器打开开发者模式，然后选择不允许后台存在activity，就是说只要按home键进程就被杀掉了
     * 这样是为了模仿由于内存不足进程无声无息被杀死的情况
     * 2.这时候再打开篮球计分器就可以发现，进程被杀死的时候，数据也随之清空了。
     * 之所以丢失，是因为viewmodel跟随着进程一起被杀掉了。再重新进入app时候相当于重新创建这个进程，
     * 就会生成一个新的viewmodel对象，这个时候原本的ui数据就没了
     *
     *
     * 方法一 老方法 savedInstanceState
     * 方法二 viewmodel新特性 lifecycle-viewmodel-savedstate
     */
    private ActivitySavedStateBinding binding;
    private SavedStateViewModel viewModel;
    public static String KEY_NUMBER = "my_number";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_state);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_saved_state);
        //由于viewmodel修改了构造器，要带一个参数，所以这里也要加个参数
        viewModel = ViewModelProviders.of(this,
                new SavedStateViewModelFactory(getApplication(),this))
                .get(SavedStateViewModel.class);
//        viewModel = ViewModelProviders.of(this).get(SavedStateViewModel.class);
//        if(savedInstanceState!=null){
//            viewModel.getaScore().setValue(savedInstanceState.getInt(KEY_NUMBER));
//        }

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);


    }

    //当系统开始停止您的Activity时,它会调用onSaveInstanceState()
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_NUMBER,viewModel.getaScore().getValue());
//    }

}