package nyc.c4q.assessment.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public class ApiResponse {
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("data")
    @Expose
    public List<User> data;
}
