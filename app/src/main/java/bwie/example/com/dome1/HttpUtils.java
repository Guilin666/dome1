package bwie.example.com.dome1;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    private static volatile HttpUtils instance;
    public static final String BASE_URL = "http://www.zhaoapi.cn/";
    private final Retrofit retrofit;

    private HttpUtils() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(client()).build();
    }

    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (null == instance) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    private OkHttpClient client() {
        return new OkHttpClient.Builder().build();
    }

    public <T> T create(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
