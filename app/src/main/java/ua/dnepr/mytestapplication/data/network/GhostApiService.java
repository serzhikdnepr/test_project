package ua.dnepr.mytestapplication.data.network;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.dnepr.mytestapplication.data.events.GetListEmailed;

public interface GhostApiService {

    @GET("emailed/1.json")
    Single<GetListEmailed> getListEmailed(@Query("api-key") String api_key);
}
