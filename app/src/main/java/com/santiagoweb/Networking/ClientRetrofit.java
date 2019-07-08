package com.santiagoweb.Networking;

import com.santiagoweb.Model.ComicsResponse;
import com.santiagoweb.Model.charactersResponse;
import com.santiagoweb.Model.creatorsResponse;
import com.santiagoweb.Model.eventsResponse;
import com.santiagoweb.Model.seriesResponse;
import com.santiagoweb.Model.storiesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClientRetrofit {
    @GET("comics")
    Call<ComicsResponse> getComics(@Query("apikey") String key,
                                   @Query("ts") String ts,
                                   @Query("hash") String hash);
    @GET("characters ")
    Call<charactersResponse> getCharacters(@Query("apikey") String key,
                                           @Query("ts") String ts,
                                           @Query("hash") String hash);
    @GET("creators")
    Call<creatorsResponse> getCreators(@Query("apikey") String key,
                                       @Query("ts") String ts,
                                       @Query("hash") String hash);
    @GET("events")
    Call<eventsResponse> getEvents(@Query("apikey") String key,
                                   @Query("ts") String ts,
                                   @Query("hash") String hash);
    @GET("series")
    Call<seriesResponse> getSeries(@Query("apikey") String key,
                                   @Query("ts") String ts,
                                   @Query("hash") String hash);
    @GET("stories ")
    Call<storiesResponse> getStories(@Query("apikey") String key,
                                     @Query("ts") String ts,
                                     @Query("hash") String hash);
}
