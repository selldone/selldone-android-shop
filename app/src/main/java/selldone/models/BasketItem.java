package selldone.models;

import com.google.gson.annotations.SerializedName;

public class BasketItem {

    @SerializedName("id")
    public int id;

    @SerializedName("basket_id")
    public int basket_id;

    @SerializedName("product_id")
    public int product_id;

    @SerializedName("count")
    public int count;


    @SerializedName("price")
    public double price;

    @SerializedName("dis")
    public double dis;

    @SerializedName("currency")
    public String currency;

    @SerializedName("product")
    public Product product;

}
