package selldone.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import selldone.models.Basket;
import selldone.models.Model;
import selldone.models.Shop;


public class OrderUpdateMessage extends Model {

    @SerializedName("basket")
    public Basket basket;

    @SerializedName("shop")
    public Shop shop;


    public static OrderUpdateMessage from(String data) {

        GsonBuilder builder_gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss");


        Gson gson = builder_gson.create();


        if (data == null) {
            return new OrderUpdateMessage();
        }
        try {
            java.lang.reflect.Type listType = new TypeToken<OrderUpdateMessage>() {
            }.getType();
            return gson.fromJson(data, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new OrderUpdateMessage();

        }


    }

    public static String to(OrderUpdateMessage someObjects) {
        GsonBuilder builder_gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss");


        Gson gson = builder_gson.create();

        return gson.toJson(someObjects);
    }


    public String toString() {
        return to(this);
    }

}
