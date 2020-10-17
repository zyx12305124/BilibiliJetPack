package learn.gouzi.bilibilijetpack.androidViewModel;

import androidx.appcompat.app.AppCompatActivity;
import learn.gouzi.bilibilijetpack.R;

import android.os.Bundle;

public class AndroidViewModelActivity extends AppCompatActivity {

    /**
     * 让viewmodel访问全局资源
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_view_model);
    }
}