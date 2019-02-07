package ua.dnepr.mytestapplication.data.network;


import io.reactivex.Single;
import retrofit2.http.GET;
import ua.dnepr.mytestapplication.data.events.GetListEmailed;

public interface GhostApiService {

    @GET("emailed/7.json")
    Single<GetListEmailed> getListEmailed();
}
