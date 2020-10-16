package learn.gouzi.bilibilijetpack.scoreDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import learn.gouzi.bilibilijetpack.R;
import learn.gouzi.bilibilijetpack.databinding.ActivityScoreBinding;

import android.os.Bundle;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;
    private ScoreViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_score);
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        binding.setScore(viewModel);
        binding.setLifecycleOwner(this);
    }
}