package ua.dnepr.mytestapplication.data.network.interceptors;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ua.dnepr.mytestapplication.data.network.NetworkChecker;
import ua.dnepr.mytestapplication.domain.exceptions.NoNetworkException;


public class NetworkCheckInterceptor implements Interceptor {
    private NetworkChecker networkChecker;

    public NetworkCheckInterceptor(NetworkChecker networkChecker) {
        this.networkChecker = networkChecker;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();
        if (!networkChecker.isConnected()) {
            throw new NoNetworkException("No network connection");
        }

        try {
            return chain.proceed(requestBuilder.build());
        } catch (SocketTimeoutException | UnknownHostException e) {
            throw new NoNetworkException();
        }

    }

}
