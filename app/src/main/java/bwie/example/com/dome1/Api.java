package bwie.example.com.dome1;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("ad/getAd")
    Observable<bean> create();
}
