package learn.gouzi.bilibilijetpack.liveDataTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import learn.gouzi.bilibilijetpack.R;
import learn.gouzi.bilibilijetpack.databinding.ActivityLiveDataTestBinding;

import android.os.Bundle;
import android.view.View;

public class LiveDataTestActivity extends AppCompatActivity {


    /**
     * 感知数据的变化，自动刷新界面
     */
    private ViewModelWithLiveData viewModelWithLiveData;
    private ActivityLiveDataTestBinding binding ;

    /**
     * 给viewmodel 里的变量添加一个观察 观察它自己，如果这个数发生变化，
     * 变化之后它就会来呼叫onChanged函数 执行里面的代码
     * observe方法第一个参数必须是有lifecycle管理功能的对象
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_test);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_live_data_test);
        viewModelWithLiveData = ViewModelProviders.of(this).get(ViewModelWithLiveData.class);
        //记住是给livedata设置观察
        viewModelWithLiveData
                .getLikedNumber()
                .observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textView2.setText(String.valueOf(integer));
            }
        });
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addNumber(1);
            }
        });
        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addNumber(-1);
            }
        });
    }
}