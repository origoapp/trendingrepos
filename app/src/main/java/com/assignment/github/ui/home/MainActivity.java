package com.assignment.github.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModelProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.assignment.github.App;
import com.assignment.github.R;
import com.assignment.github.data.DataManager;
import com.assignment.github.ui.base.BaseActivity;
import com.assignment.github.utils.Util;

public class MainActivity extends BaseActivity<MainViewModel> {

    @BindView(R.id.sample_main_layout)
    LinearLayout mainLayout;
    @BindView(R.id.imgview)
    ImageView imageView;

    @Override
    public MainViewModel createViewModel() {
        MainViewModelFactory factory = new MainViewModelFactory(DataManager.getInstance(App.getInstance()));
        return new ViewModelProvider(this,factory).get(MainViewModel.class);
    }

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        if (Util.isNetworkAvailable(App.getInstance()))
            getSupportFragmentManager().beginTransaction()
            .replace(R.id.sample_content_fragment, MainFragment.getInstance())
            .commit();
        else {
            Util.showSnack(mainLayout,true,"No Internet Connection! ");
            imageView.setVisibility(View.VISIBLE);
        }
    }
}
