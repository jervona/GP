package nyc.c4q.assessment.api;

import io.reactivex.Observable;
import nyc.c4q.assessment.pojo.ApiResponse;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public interface ApiService {
    @GET("users")
    Observable<ApiResponse> getListOfUser();

    @POST("users")
    Observable<ApiResponse> postNewUser();

}
