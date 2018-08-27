package ganapathi.raja.simpledagger.model;

import java.util.List;

import ganapathi.raja.simpledagger.presistence.entity.MovieTicketEntity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //    https://api.androidhive.info/json/movies.json

    @GET("json/movies.json")
    Call<List<MovieTicketEntity>> getData();
}
