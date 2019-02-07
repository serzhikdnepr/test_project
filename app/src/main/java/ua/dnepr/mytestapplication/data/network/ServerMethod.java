package ua.dnepr.mytestapplication.data.network;



import io.reactivex.Single;
import ua.dnepr.mytestapplication.data.events.GetListEmailed;

public class ServerMethod {
    private GhostApiService mGhostApiService;

    public ServerMethod(GhostApiService ghostApiService) {
        mGhostApiService = ghostApiService;
    }

    public ServerMethod() {
    }

    public Single<GetListEmailed> getListEmailedSingle() {
        return mGhostApiService.getListEmailed(AppApiConstants.API_KEY);
    }
}