package com.santiagoweb.Networking;


import androidx.lifecycle.MutableLiveData;

import com.santiagoweb.Model.ComicsResponse;
import com.santiagoweb.Model.charactersResponse;
import com.santiagoweb.Model.creatorsResponse;
import com.santiagoweb.Model.eventsResponse;
import com.santiagoweb.Model.seriesResponse;
import com.santiagoweb.Model.storiesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.santiagoweb.Util.Constants.HASH;
import static com.santiagoweb.Util.Constants.KEY;
import static com.santiagoweb.Util.Constants.TS;

public class NewsRepository {

    private static NewsRepository newsRepository;

    public static NewsRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    private ClientRetrofit newsApi;

    public NewsRepository(){
        newsApi = RetrofitService.cteateService(ClientRetrofit.class);
    }

    public MutableLiveData<ComicsResponse> getListComics(){
        final MutableLiveData<ComicsResponse> newsData = new MutableLiveData<>();
        newsApi.getComics(KEY, TS, HASH).enqueue(new Callback<ComicsResponse>() {
            @Override
            public void onResponse(Call<ComicsResponse> call,
                                   Response<ComicsResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                    System.out.println("sucess");
                }
            }
            @Override
            public void onFailure(Call<ComicsResponse> call, Throwable t) {
                System.out.println("error getListComics"+ t.getMessage() );
                newsData.setValue(null);
            }
        });
        return newsData;
    }

    public MutableLiveData<charactersResponse> getListCharacter(){
        final MutableLiveData<charactersResponse> newsData = new MutableLiveData<>();
        newsApi.getCharacters(KEY, TS, HASH).enqueue(new Callback<charactersResponse>() {
            @Override
            public void onResponse(Call<charactersResponse> call,
                                   Response<charactersResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                    System.out.println("sucess");
                }
            }
            @Override
            public void onFailure(Call<charactersResponse> call, Throwable t) {
                System.out.println("error getListComics"+ t.getMessage() );
                newsData.setValue(null);
            }
        });
        return newsData;
    }
    public MutableLiveData<creatorsResponse> getListCreators(){
        final MutableLiveData<creatorsResponse> newsData = new MutableLiveData<>();
        newsApi.getCreators(KEY, TS, HASH).enqueue(new Callback<creatorsResponse>() {
            @Override
            public void onResponse(Call<creatorsResponse> call,
                                   Response<creatorsResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                    System.out.println("sucess");
                }
            }
            @Override
            public void onFailure(Call<creatorsResponse> call, Throwable t) {
                System.out.println("error getListComics"+ t.getMessage() );
                newsData.setValue(null);
            }
        });
        return newsData;
    }


    public MutableLiveData<eventsResponse> getListEvents(){
        final MutableLiveData<eventsResponse> newsData = new MutableLiveData<>();
        newsApi.getEvents(KEY, TS, HASH).enqueue(new Callback<eventsResponse>() {
            @Override
            public void onResponse(Call<eventsResponse> call,
                                   Response<eventsResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                    System.out.println("sucess");
                }
            }
            @Override
            public void onFailure(Call<eventsResponse> call, Throwable t) {
                System.out.println("error getListComics"+ t.getMessage() );
                newsData.setValue(null);
            }
        });
        return newsData;
    }
    public MutableLiveData<seriesResponse> getListSeries(){
        final MutableLiveData<seriesResponse> newsData = new MutableLiveData<>();
        newsApi.getSeries(KEY, TS, HASH).enqueue(new Callback<seriesResponse>() {
            @Override
            public void onResponse(Call<seriesResponse> call,
                                   Response<seriesResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                    System.out.println("sucess");
                }
            }
            @Override
            public void onFailure(Call<seriesResponse> call, Throwable t) {
                System.out.println("error getListComics"+ t.getMessage() );
                newsData.setValue(null);
            }
        });
        return newsData;
    }
    public MutableLiveData<storiesResponse> getListStories(){
        final MutableLiveData<storiesResponse> newsData = new MutableLiveData<>();
        newsApi.getStories(KEY, TS, HASH).enqueue(new Callback<storiesResponse>() {
            @Override
            public void onResponse(Call<storiesResponse> call,
                                   Response<storiesResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                    System.out.println("sucess");
                }
            }
            @Override
            public void onFailure(Call<storiesResponse> call, Throwable t) {
                System.out.println("error getListComics"+ t.getMessage() );
                newsData.setValue(null);
            }
        });
        return newsData;
    }

}

