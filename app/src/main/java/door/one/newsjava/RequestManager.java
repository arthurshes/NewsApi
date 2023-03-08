package door.one.newsjava;

import android.content.Context;
import android.widget.Toast;

import door.one.newsjava.Models.NewsApiResponce;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;

    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(" https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getNewsLabel(OnFechListen onFechListen,String category,String query){
        CallNewsApi callNewsApi=retrofit.create(CallNewsApi.class);
        Call<NewsApiResponce>call=callNewsApi.callheadlines("ru",category,query,context.getString(R.string.api_key));

        try{
            call.enqueue(new Callback<NewsApiResponce>() {
                @Override
                public void onResponse(Call<NewsApiResponce> call, Response<NewsApiResponce> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                    }
                    onFechListen.onFetchData(response.body().getArticles(), response.message());

                }
                @Override
                public void onFailure(Call<NewsApiResponce> call, Throwable t) {
onFechListen.onError("error");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public RequestManager(Context context) {
        this.context = context;
    }
    public interface CallNewsApi{
        @GET("top-headlines")
        Call<NewsApiResponce>callheadlines(
                @Query("country")String country,
                @Query("category")String category,
                @Query("q")String query,
                @Query("apiKey")String api_key
        );
    }
}
