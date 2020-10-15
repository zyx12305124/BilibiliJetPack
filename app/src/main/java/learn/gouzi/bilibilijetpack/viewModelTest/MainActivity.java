package learn.gouzi.bilibilijetpack.viewModelTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import learn.gouzi.bilibilijetpack.R;
import learn.gouzi.bilibilijetpack.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * viewmodel 负责管理一个屏幕中的数据 旋转屏幕和切换语言的时候数据不会丢失
     * viewmodel + livedata可以实现对数据的监听 通过监听可以使界面的内容会自动的得到刷新
     * 再配合room 处理sqlite 可以实现数据的存储
     *
     * * @param savedInstanceState
     */
    private ActivityMainBinding binding;
    private MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        //视屏里最后加了这句，不加oncreate重新创建的时候会回到最初的样子
        //但是多旋转几次，回来的时候还是原来的值
        binding.textView.setText(String.valueOf(viewModel.num));
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.num++;
                binding.textView.setText(String.valueOf(viewModel.num));
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.num +=2;
                binding.textView.setText(String.valueOf(viewModel.num));
            }
        });
    }
    /**
     * 这个例子我们不需要对数据进行保存 也不需要用到savedInstanceState
     * 也没有在Activty出现一个数据的变量
     */
}