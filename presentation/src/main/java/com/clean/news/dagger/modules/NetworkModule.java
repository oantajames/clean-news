package com.clean.news.dagger.modules;

import com.clean.news.domain.repository.NewsRepository;
import com.clean.news.domain.repository.NewsSourcesRepository;
import com.clean.news.data.net.api.news.NewsApi;
import com.clean.news.data.repository.NewsDataRepository;
import com.clean.news.data.repository.NewsSourcesDataRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author james on 5/12/17.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        setLoggingInterceptor(clientBuilder);
        clientBuilder.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalUrl = original.url();
            HttpUrl newUrl = originalUrl.newBuilder()
                    .addQueryParameter("apiKey", "5ade1a0d479245a1afc2b0e690f93c4b")
                    .build();
            Request.Builder builder = original.newBuilder()
                    .url(newUrl);
            Request request = builder.build();
            return chain.proceed(request);
        });
        return clientBuilder.build();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient okHttpClient, Converter.Factory gsonConverterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .baseUrl("https://newsapi.org")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }


    protected void setLoggingInterceptor(OkHttpClient.Builder clientBuilder) {
        HttpLoggingInterceptor loggingHeaders = new HttpLoggingInterceptor();
        loggingHeaders.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        clientBuilder.addInterceptor(loggingHeaders);

        HttpLoggingInterceptor loggingBody = new HttpLoggingInterceptor();
        loggingBody.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingBody);
    }


    @Provides
    @Singleton
    public Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    NewsRepository provideNewsRepository(NewsDataRepository newsDataRepository) {
        return newsDataRepository;
    }

    @Provides
    @Singleton
    NewsApi provideNewsService(Retrofit retrofit) {
        return retrofit.create(NewsApi.class);
    }


    @Provides
    @Singleton
    NewsSourcesRepository provideNewsSourcesRepository(NewsSourcesDataRepository newsSourcesDataRepository) {
        return newsSourcesDataRepository;
    }

}
