package com.santiagoweb.Viewmodels;
;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.santiagoweb.Model.ComicsResponse;
import com.santiagoweb.Model.charactersResponse;
import com.santiagoweb.Model.creatorsResponse;
import com.santiagoweb.Model.eventsResponse;
import com.santiagoweb.Model.seriesResponse;
import com.santiagoweb.Model.storiesResponse;
import com.santiagoweb.Networking.NewsRepository;

public class ComicsViewModel extends ViewModel {
    private MutableLiveData<ComicsResponse> mutableLiveData;
    private MutableLiveData<charactersResponse> chareData;
    private MutableLiveData<creatorsResponse> creatorData;
    private MutableLiveData<eventsResponse> eventsData;
    private MutableLiveData<seriesResponse> seriesData;
    private MutableLiveData<storiesResponse> storiesData;
    private NewsRepository newsRepository;
    private int mTypeFragment ;

    public int getmTypeFragment() {
        return mTypeFragment;
    }

    public void setmTypeFragment(int mtypeFragment) {
        this.mTypeFragment = mtypeFragment;
    }

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        switch (this.mTypeFragment){
            case 0:
                chareData = newsRepository.getListCharacter();
                break;
            case 1: //comics
                mutableLiveData = newsRepository.getListComics();
                break;
            case 2://comics
                mutableLiveData = newsRepository.getListComics();
                break;
            case 3: //creators
                creatorData = newsRepository.getListCreators();
                break;
            case 4:
                eventsData = newsRepository.getListEvents();
                break;
            case 5:
                seriesData = newsRepository.getListSeries();
                break;
            case 6:
                storiesData = newsRepository.getListStories();
                break;

        }
    }

    public LiveData<ComicsResponse> getComicRepository() {
        return mutableLiveData;
    }

    public LiveData<charactersResponse> getChareRepository() {
        return chareData;
    }
    public LiveData<creatorsResponse> getCreatorseRepository() {
        return creatorData;
    }

    public LiveData<eventsResponse> getCreatorseRepoevents() {
        return eventsData;
    }

    public LiveData<seriesResponse> getCreatorseReposeries() {
        return seriesData;
    }

    public LiveData<storiesResponse> getCreatorseRepostories() {
        return storiesData;
    }
}
