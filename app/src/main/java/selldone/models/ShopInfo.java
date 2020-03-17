package selldone.models;

import com.google.gson.annotations.SerializedName;

public class ShopInfo {

    @SerializedName("address")
    public String address;

    @SerializedName("phone")
    public String phone;

    @SerializedName("email")
    public String email;


    @SerializedName("location")
    public LocationObject location;
}
