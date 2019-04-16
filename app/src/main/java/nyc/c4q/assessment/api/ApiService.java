package nyc.c4q.assessment.api;

import io.reactivex.Observable;
import nyc.c4q.assessment.pojo.ApiResponse;
import nyc.c4q.assessment.pojo.SuccessfulNewUserResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public interface ApiService {
    @GET("users")
    Observable<ApiResponse> getListOfUser();

    @GET("users")
    Observable<ApiResponse> getListOfUser(@Query("page")int page_num);

    @FormUrlEncoded
    @POST("users")
    Observable<SuccessfulNewUserResponse> postNewUser(@Field("name")String userName, @Field("job")String userJob);
}
