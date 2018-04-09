package com.example.tinyfight;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.data.utils.WeatherTownIDMapUtil;
import com.example.domain.model.Weather;
import com.example.tinyfight.di.ActivityComponent;
import com.example.tinyfight.di.ActivityModule;
import com.example.tinyfight.di.DaggerActivityComponent;
import com.example.tinyfight.mvp.MainPresenter;
import com.example.tinyfight.mvp.main.MainConstract;
import com.example.tinyfight.widget.MaterialSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainConstract.View{

    String[] ITEMS = {"北京", "上海", "天津", "重庆"};

    @BindView(R.id.ms_selector)
    MaterialSpinner ms;
    @BindView(R.id.tv_city_name)
    TextView cityText;
    @BindView(R.id.tv_weather_temp)
    TextView tempText;
    @BindView(R.id.tv_weather_desc)
    TextView descText;

    Unbinder unbinder;
    @Inject
    MainPresenter mPresenter;

    private boolean isOkConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        initInject();
        initMaterView();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestPermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[]{},0x01);
        }else {
            isOkConnect = true;
        }
    }

    private void initMaterView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms.setAdapter(adapter);
        ms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isOkConnect){
                    mPresenter.getWeather(WeatherTownIDMapUtil.getTownID(position));
                }else {
                    Toast.makeText(MainActivity.this,"请授予网络请求权限",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showWeather(Weather weather) {
        if(weather != null){
            cityText.setText(weather.getCityName());
            tempText.setText(weather.getNowTemperature());
            descText.setText(weather.getNowText());
        }
    }

    protected void initInject(){
        getActivityComponent().inject(this);
        mPresenter.attachView(this);
        unbinder = ButterKnife.bind(this);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 0x01){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                isOkConnect = true;
            }
        }
    }
}
