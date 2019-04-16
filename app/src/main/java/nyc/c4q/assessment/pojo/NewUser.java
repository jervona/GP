package nyc.c4q.assessment.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public class NewUser {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("job")
    @Expose
    public String job;
}
