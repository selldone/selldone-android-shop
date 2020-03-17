package selldone.models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;


public class Basket extends Model {

    @SerializedName("id")
    public Integer id;


    @SerializedName("shop_id")
    public int shop_id;

    @SerializedName("user_id")
    public int user_id;

    @SerializedName("type")
    public Type type;
    @SerializedName("status")
    public OrderStatus status;
    @SerializedName("reject")
    public String reject;
    @SerializedName("receiver_info")
    public String receiver_info;

    @SerializedName("delivery_info")
    public String delivery_info;
    @SerializedName("price")
    public double price;
    @SerializedName("currency")
    public String currency;
    @SerializedName("delivery_price")
    public double delivery_price;

    @SerializedName("delivery_state")
    public String delivery_state;

    @SerializedName("delivery_at")
    public Date delivery_at;


    @SerializedName("items")
    public ArrayList<BasketItem> items;

    public enum Type {
        @SerializedName(value = "PHYSICAL")
        PHYSICAL,
        @SerializedName(value = "VIRTUAL")
        VIRTUAL,
        @SerializedName(value = "FILE")
        FILE,
        @SerializedName(value = "SERVICE")
        SERVICE,
    }

    public enum OrderStatus {
        @SerializedName(value = "Open")
        Open,
        @SerializedName(value = "Reserved")
        Reserved,
        @SerializedName(value = "Payed")
        Payed,
        @SerializedName(value = "Canceled")
        Canceled,
        @SerializedName(value = "COD")
        COD,
    }


}
