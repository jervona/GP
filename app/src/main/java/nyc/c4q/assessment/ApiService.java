package nyc.c4q.assessment;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public interface ApiService {
    @GET("users")
    Observable<Object> getListOfUser();

    @POST("users")
    Observable<Object> postNewUser();

}
