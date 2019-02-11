package ua.dnepr.mytestapplication.data.network;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.dnepr.mytestapplication.data.events.GetListEmailed;
import ua.dnepr.mytestapplication.data.events.GetListShared;
import ua.dnepr.mytestapplication.data.events.GetListViewed;

public interface GhostApiService {

    @GET("emailed/1.json")
    Single<GetListEmailed> getListEmailed(@Query("api-key") String api_key);

    @GET("shared/1/facebook.json")
    Single<GetListShared> getListShared(@Query("api-key") String api_key);

    @GET("viewed/1.json")
    Single<GetListViewed> getListViewed(@Query("api-key") String api_key);
}
