package selldone.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Shop extends Model {

    @SerializedName("id")
    public int id;

    @SerializedName("user_id")
    public int user_id;

    @SerializedName("name")
    public String name;


    @SerializedName("title")
    public String title;


    @SerializedName("description")
    public String description;


    @SerializedName("icon")
    public String icon;

    @SerializedName("official")
    public boolean official;

    @SerializedName("info")
    public ShopInfo info;


    @SerializedName("support_mode")
    public String support_mode;

    @SerializedName("gold")
    public Boolean gold;

    @SerializedName("penalty")
    public Boolean penalty;


    @SerializedName("badges")
    public ArrayList<Badge> badges;

/*
    @SerializedName("type")
    public Type type;

    public enum Type {
        @SerializedName(value = "Transfer")
        Transfer
    }
*/

}
