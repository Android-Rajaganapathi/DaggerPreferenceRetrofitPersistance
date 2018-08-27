package ganapathi.raja.simpledagger.di.module;

import java.util.List;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import ganapathi.raja.simpledagger.di.NetworkScope;
import ganapathi.raja.simpledagger.model.Api;
import ganapathi.raja.simpledagger.model.ModelApi;
import ganapathi.raja.simpledagger.presistence.entity.MovieTicketEntity;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private String mBaseUrl;

    public NetworkModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @NetworkScope
    ModelApi provideModelApi() {
        return new ModelApi(provideRetrofit());
    }

    @Provides
    @NetworkScope
    Retrofit provideRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @NetworkScope
    Call<List<MovieTicketEntity>> provideMovieTickets(Retrofit retrofit) {
        return retrofit.create(Api.class).getData();
    }

}
