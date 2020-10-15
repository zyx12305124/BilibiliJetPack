package learn.gouzi.bilibilijetpack.dataBindingTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import learn.gouzi.bilibilijetpack.R;
import learn.gouzi.bilibilijetpack.databinding.ActivityDataBindingTestBinding;
import learn.gouzi.bilibilijetpack.databinding.ActivityLiveDataTestBinding;
import learn.gouzi.bilibilijetpack.liveDataTest.ViewModelWithLiveData;

import android.os.Bundle;
import android.view.View;

public class DataBindingTestActivity extends AppCompatActivity {

    /**
     * 界面与代码的解耦
     * 1.textView
     * 2.button 呼叫函数
     * 3.binding绑定viewModel
     * 4.binding绑定lifeCycleOwner 如果这句不写，数据是不会被观察到的，
     * 你点按钮的时候数据不会刷新，因为这时候没有进行数据的观察
     * 5.可以对比下这个相比较LiveDataTestActivity删除了哪些代码
     */

    private ViewModelWithLiveData viewModelWithLiveData;
    private ActivityDataBindingTestBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_test);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_test);
        viewModelWithLiveData = ViewModelProviders.of(this).get(ViewModelWithLiveData.class);
        binding.setData(viewModelWithLiveData);
        binding.setLifecycleOwner(this);
//        viewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.textView2.setText(String.valueOf(integer));
//            }
//        });
    }
}