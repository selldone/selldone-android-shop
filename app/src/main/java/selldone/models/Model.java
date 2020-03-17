package selldone.models;


import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Model {


    @SerializedName("created_at")
    public Date created_at;

    @SerializedName("updated_at")
    public Date updated_at;


}
