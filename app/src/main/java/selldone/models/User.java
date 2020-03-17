package selldone.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("personal_information_verified")
    public Boolean personal_information_verified;

    @SerializedName("email_verified")
    public Boolean email_verified;


    @SerializedName("phone")
    public String phone;
}
