package selldone.routes;

import android.util.Log;
import android.webkit.WebView;

import com.google.gson.Gson;

import java.util.HashMap;

import selldone.models.Basket;

public class ShopRoute {
    private static final String ShopPage = "ShopPage";
    private static final String PageRender = "PageRender"; // params: page_name

    private static final String ProductPage = "ProductPage"; // params: product_id
    private static final String ComparisonPage = "ComparisonPage";

    private static final String BasketPage = "BasketPage";// params: type
    private static final String MyOrdersPage = "MyOrdersPage";
    private static final String MyBasketOrderInfoPage = "MyBasketOrderInfoPage";// params: basket_id
    private static final String MyVirtualOrderInfoPage = "MyVirtualOrderInfoPage";// params: virtual_item_id
    private static final String UserProfilePage = "UserProfilePage";
    private static final String UserAddressesPage = "UserAddressesPage";
    private static final String UserReturnRequests = "UserReturnRequests";
    private static final String UserFavoritesPage = "UserFavoritesPage";
    private static final String UserCommentsPage = "UserCommentsPage";
    private static final String UserGiftCardsPage = "UserGiftCardsPage";
    private static final String Blogs = "Blogs";
    private static final String ShopProfilePage_AboutUs = "ShopProfilePage_AboutUs";
    private static final String ShopProfilePage_Terms = "ShopProfilePage_Terms";
    private static final String ShopProfilePage_Privacy = "ShopProfilePage_Privacy";
    private static final String ShopFAQ = "ShopFAQ";
    private static final String ShopContactUs = "ShopContactUs";


    public static void GoToBasket(WebView webView, Basket.Type type) {

        HashMap<String, String> params = new HashMap<>();
        params.put("type", type.toString());


        GoToPath(webView, "BasketPage", params, null);
    }


    public static void GoToPath(WebView webView, String path_name, HashMap<String, String> params, HashMap<String, String> query) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GoToPath('");
        stringBuilder.append(path_name);
        stringBuilder.append("'");

        if (params != null) {
            Gson gson = new Gson();
            stringBuilder.append(",");
            stringBuilder.append(gson.toJson(params));
        }

        if (query != null) {
            Gson gson = new Gson();
            stringBuilder.append(",");
            stringBuilder.append(gson.toJson(query));
        }


        stringBuilder.append(");");

        String path = stringBuilder.toString();

        Log.i("PATH GENERATED:", path);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript(path, null);
        } else {
            webView.loadUrl("javascript:" + path);
        }
    }

}
