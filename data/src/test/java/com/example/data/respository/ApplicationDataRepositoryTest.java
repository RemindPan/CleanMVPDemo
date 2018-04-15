package com.example.data.respository;

import com.example.data.ApplicationTestCase;
import com.example.data.config.AppTestWeatherConfig;
import com.example.data.entity.WeatherEntity;
import com.example.data.net.WeatherApi;
import com.example.data.net.WeatherClient;
import com.example.data.repository.ApplicationDataRepository;
import com.example.domain.model.Weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;

/**
 * Created by tinyfight on 2018/4/15.
 */

@RunWith(MockitoJUnitRunner.class)
public class ApplicationDataRepositoryTest {
    private ApplicationDataRepository applicationRepository;
    private String townId = "CHBJ000000";
    private AppTestWeatherConfig config;

    @Mock private WeatherClient weatherClient;
    @Mock private WeatherApi mockWeatherApi;
    @Mock private WeatherEntity mockWeatherEntity;
    @Mock private Weather mockWeather;

    @Before
    public void setUp() {
        applicationRepository = new ApplicationDataRepository(ApplicationTestCase.context(), mockWeatherApi);
    }

    @Test
    public void testGetWeatherCase(){
        WeatherEntity fakeEntity = new WeatherEntity();
        Observable<WeatherEntity> fakeReturn = Observable.just(fakeEntity);

        //验证返回是否正确
        given(mockWeatherApi.getWeather(townId,"","","","","")).willReturn(fakeReturn);

        applicationRepository.getWeather(townId);
        //先进行调用，然后检验被Mock的关键字的方法有没有被调用
        Mockito.verify(mockWeatherApi).getWeather(townId,"","","","","");
    }
}
