package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.interactor.GetWeatherInteractor;
import com.example.domain.respository.ApplicationRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by tinyfight on 2018/4/10.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetWeatherInteractorTest {
    private String townId = "CHBJ000000";

    private GetWeatherInteractor interactor;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private ApplicationRepository mockApplicationRespository;

    @Before
    public void setUp(){
        interactor = new GetWeatherInteractor(mockApplicationRespository,mockThreadExecutor,mockPostExecutionThread);
    }

    @Test
    public void testGetWeatherCase(){
        interactor.seTownId(townId);
        interactor.buildObservable();
        verify(mockApplicationRespository).getWeather(townId);
        verifyNoMoreInteractions(mockApplicationRespository);
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);
    }
}
