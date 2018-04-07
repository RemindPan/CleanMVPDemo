package com.example.tinyfight;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.domain.model.Weather;
import com.example.tinyfight.di.ActivityComponent;
import com.example.tinyfight.di.ActivityModule;
import com.example.tinyfight.di.DaggerActivityComponent;
import com.example.tinyfight.mvp.MainPresenter;
import com.example.tinyfight.mvp.main.MainConstract;
import com.example.tinyfight.widget.MaterialSpinner;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements MainConstract.View{

    @BindView(R.id.ms_selector)
    MaterialSpinner ms;
    @BindView(R.id.tv_city_name)
    TextView cityText;
    @BindView(R.id.tv_weather_temp_high)
    TextView tempHighText;
    @BindView(R.id.tv_weather_temp_low)
    TextView tempLowText;

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInject();
        initMaterView();
    }

    private void initMaterView() {
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showWeather(Weather weather) {

    }

    protected void initInject(){
        getActivityComponent().inject(this);
    }

    private ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder().
                appComponent(WeatherApplication.getInstance().getComponent()).
                activityModule(getActivityModule()).
                build();

    }

    private ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }
}
