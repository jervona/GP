package nyc.c4q.assessment.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

@Module
public class ApiModule {
    private static final String BASE_URL="https://reqres.in/api/";

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Singleton
    @Provides
    ApiService provideApiService (Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
