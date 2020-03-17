package selldone.models;

import com.google.gson.annotations.SerializedName;

public class ShopDataPack {

    @SerializedName("shop")
    public Shop shop;

    @SerializedName("basket")
    public Basket basket;


}
