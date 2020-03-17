package selldone.models;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    public int id;


    @SerializedName("title")
    public String title;

    @SerializedName("title_en")
    public String title_en;


}
