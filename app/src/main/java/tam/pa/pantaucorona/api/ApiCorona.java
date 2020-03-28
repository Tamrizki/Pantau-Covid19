package tam.pa.pantaucorona.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tam.pa.pantaucorona.model.DataCorona;
import tam.pa.pantaucorona.model.DataCoronaLocal;

public interface ApiCorona {
    String URL = "https://covid19.mathdro.id/api/";
    String URL_LOCAL = "https://api.kawalcorona.com/indonesia/";
    @GET("confirmed")
    Call<List<DataCorona>> view();

    @GET("provinsi/")
    Call<List<DataCoronaLocal>> local();
}
