package com.jhonlee.musicpf.network;

import android.util.Log;


import com.jhonlee.musicpf.network.api.IMusicRequest;
import com.jhonlee.musicpf.util.Const;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class NetworkApi {

    private static NetworkApi networkApi = null;

    private Retrofit retrofit;



    private NetworkApi() {
        retrofit = getRetrofit(Const.URL);
    }
    public synchronized static  NetworkApi getNetworkApi() {

        if (networkApi == null){
            networkApi = new NetworkApi();
        }
        return networkApi;
    }


    private Retrofit getRetrofit(String url){

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkhttpCleient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

    private OkHttpClient getOkhttpCleient() {

        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("Jhon Lee","OkHttp====Message:"+message);
            }
        });
        loggingInterceptor.setLevel(level);
        OkHttpClient okhttpCleient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .addHeader("referer","http://music.163.com/")
                                .build();

                        return chain.proceed(request);
                    }
                }).build();
        return okhttpCleient;
    }
    /**
     * 创建请求接口的对象
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
