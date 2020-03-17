package selldone.models;

import com.google.gson.annotations.SerializedName;

public class Badge {
    @SerializedName("shop_id")
    public int shop_id;

    @SerializedName("badge")
    public String badge;
}
