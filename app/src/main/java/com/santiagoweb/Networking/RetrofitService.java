package com.santiagoweb.Networking;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.santiagoweb.Util.Constants.RUTA_SERVIDOR;

public class RetrofitService {


//    private static Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(RUTA_SERVIDOR)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();

    private static Retrofit retrofit = getClient();

    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static Retrofit getClient(){

        Retrofit retrofit2 = null;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if(retrofit2==null){
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(RUTA_SERVIDOR)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit2;
    }
}
