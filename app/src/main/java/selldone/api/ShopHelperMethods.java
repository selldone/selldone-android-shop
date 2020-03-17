package selldone.api;


/**
 * Samin shop helper functions.
 */
public class ShopHelperMethods {

    /**
     * Convert file name to Samin CDN url
     *
     * @param file_name file name received in fetching
     * @param size      Optional image size
     * @return Absolute image url.
     */
    public static String getShopImagePath(String file_name, String size) {
        return
                "https://selldone.com/cdn-shop-images-1/" + file_name +
                        (size != null ? ("?size=" + size) : "")
                ;
    }

    /**
     * Get shop icon by shop ID
     *
     * @param shop_id Unique shop id
     * @param size    Optional image size
     * @return Absolute shop icon url.
     */
    public static String getShopIcon(int shop_id, String size) {
        return (
                "https://selldone.com/xapi/shops/" + shop_id + "/icon" +
                        (size != null ? ("?size=" + size) : "")
        );
    }


    public static String getUserAvatar(int user_id, String size) {
        return (
                "https://selldone.com/users/" + user_id + "/profile/avatar/" + (size != null ? size : "small")
        );
    }
}
