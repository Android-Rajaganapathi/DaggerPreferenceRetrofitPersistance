package ganapathi.raja.simpledagger.model;

import java.util.List;

import ganapathi.raja.simpledagger.presistence.entity.MovieTicketEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ModelApi {

    public ModelApi(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }

    private Retrofit mRetrofit;

    public void callApi() {
        mRetrofit.create(Api.class).getData().enqueue(new Callback<List<MovieTicketEntity>>() {
            @Override
            public void onResponse(Call<List<MovieTicketEntity>> call, Response<List<MovieTicketEntity>> response) {
                System.out.println("response = " + response.body());
            }

            @Override
            public void onFailure(Call<List<MovieTicketEntity>> call, Throwable t) {
                System.out.println("error t = " + t);
            }
        });
    }

}
