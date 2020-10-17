package learn.gouzi.bilibilijetpack.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import learn.gouzi.bilibilijetpack.R;

import android.os.Bundle;

public class NavigationActivity extends AppCompatActivity {

    /**
     * 1.NavHost 是一个用来存放每一个页面（Fragment）的容器,
     * 它同时也是一个控制器。
     * 2.Fragment
     * 3.NavController 用来控制导航逻辑的
     * 4.NavGraph 用来设置导航路线
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this,navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
//        return super.onSupportNavigateUp();
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        return navController.navigateUp();
    }
}