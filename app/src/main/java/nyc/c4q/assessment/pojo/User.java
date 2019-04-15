package nyc.c4q.assessment.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public class User {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("avatar")
    @Expose
    public String avatar;
}
