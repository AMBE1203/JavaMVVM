package com.example.javamvvm.data.source.remote.interceptor;

import android.content.Context;
import com.example.javamvvm.utils.DeviceUtil;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class NetworkCheckerInterceptor implements Interceptor {

    private Context context;

    public NetworkCheckerInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (DeviceUtil.hasConnection(context)) {
            return chain.proceed(chain.request());
        } else {
            throw new NoConnectivityException();
        }
    }

    public class NoConnectivityException extends IOException {
        @Override
        public String getMessage() {
            return "I'm Died!";
        }
    }
}
