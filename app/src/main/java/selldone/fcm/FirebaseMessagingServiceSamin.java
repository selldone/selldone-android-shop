package selldone.fcm;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.core.app.NotificationCompat;
import selldone.com.shop.R;
import selldone.helpers.BitmapHelper;
import selldone.helpers.COLOR;
import selldone.messages.OrderUpdateMessage;
import selldone.models.Basket;
import selldone.models.Shop;


public class FirebaseMessagingServiceSamin extends FirebaseMessagingService {

    final static String TAG = FirebaseMessagingServiceSamin.class.getSimpleName();
    static int i = 0;
    NotificationManager mNotificationManager;
    NotificationCompat.Builder mBuilder_Account;

    // Context context;
    NotificationCompat.Builder mBuilder_Gift;

    public static void sendRegistrationToServer(Context context, String token) {
        //  SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("fcm", MODE_PRIVATE);


    }

    public void init(Context context) {
        //   this.context = context;
        //Get an instance of NotificationManager//
        mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Uri sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getApplicationContext().getPackageName() + "/" + R.raw.iapetus);


        mBuilder_Account =
                new NotificationCompat.Builder(context, "Account")
                        .setSmallIcon(R.drawable.selldone_logo)
                        .setContentTitle(getString(R.string.Notification_Account_Title_def))
                        .setContentText(getString(R.string.Notification_Account_Message_def))
                        .setAutoCancel(true)// clear notification after click
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setLargeIcon(BitmapHelper.getBitmapFromVector(context.getResources().getDrawable(R.drawable.ic_transfer_black)))
                        .setGroup("Account")
                        .setSound(sound);
        //  mBuilder_Account.setColorized(true).setColor(COLOR.PURPLE);

        mBuilder_Gift =
                new NotificationCompat.Builder(context, "Gift")
                        .setSmallIcon(R.drawable.ic_card_giftcard_black_24dp)
                        .setContentTitle(getString(R.string.Notification_Gift_Title_def))
                        .setContentText(getString(R.string.Notification_Gift_Message_def))
                        .setAutoCancel(true)// clear notification after click
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setLargeIcon(BitmapHelper.getBitmapFromVector(context.getResources().getDrawable(R.drawable.ic_gift_box_yellow)))
                        .setGroup("Account")
                        .setSound(sound);

        mBuilder_Gift.setColorized(true).setColor(COLOR.GREEN);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // ------------- Notification > Channel > Account --------------
            NotificationChannel mChannel_Account = new NotificationChannel("Account",
                    "Account",
                    NotificationManager.IMPORTANCE_DEFAULT);

            AudioAttributes attributes_Account = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();


            // Configure the notification channel.
            mChannel_Account.setDescription("Notification in account transactions.");
            mChannel_Account.enableLights(false);
            mChannel_Account.enableVibration(false);
            mChannel_Account.setSound(sound, attributes_Account); // This is IMPORTANT
            mChannel_Account.setShowBadge(true);
            if (mNotificationManager != null)
                mNotificationManager.createNotificationChannel(mChannel_Account);

            //  mBuilder_Account.setChannelId(mChannel_Account.getId());

            // ------------- Notification > Channel > Gift --------------
            NotificationChannel mChannel_Gift = new NotificationChannel("Gift",
                    "Gift",
                    NotificationManager.IMPORTANCE_DEFAULT);

            AudioAttributes attributes_Gift = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();


            // Configure the notification channel.
            mChannel_Gift.setDescription("Notification for receive or accept gifts.");
            mChannel_Gift.enableLights(false);
            mChannel_Gift.enableVibration(false);
            mChannel_Gift.setSound(sound, attributes_Gift); // This is IMPORTANT
            mChannel_Gift.setShowBadge(true);
            if (mNotificationManager != null)
                mNotificationManager.createNotificationChannel(mChannel_Gift);


        }

    }

    @Override
    public void onCreate() {
        super.onCreate();

        init(this);

    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);


        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(getApplicationContext(), token);


    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        Log.d(TAG, "From: " + remoteMessage.getFrom());


        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (remoteMessage.getData().containsKey("basket")) {


                OrderUpdateMessage orderUpdateMessage = OrderUpdateMessage.from(remoteMessage.getData().get("basket"));

                SendNotification(orderUpdateMessage);
                Log.d(TAG, "Message Notification Body: " + orderUpdateMessage.toString());


            }


            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                // scheduleJob();
            } else {
                // Handle message within 10 seconds
                // handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification getTag: " + remoteMessage.getNotification().getTag());


            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());


        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    public void SendNotification(OrderUpdateMessage orderUpdateMessage) {


        Basket basket = orderUpdateMessage.basket;
        Shop shop = orderUpdateMessage.shop;


        mBuilder_Gift.setStyle(new NotificationCompat.InboxStyle()
                .addLine(shop.title)

                //   .addLine(String.format(getString(R.string.Notification_Gift_Amount), FormatHelper.FormatNumber(giftMessage.amount), getResources().getString(giftMessage.currency.name_res)))
                .addLine(basket.type.toString() + "-" + basket.id)
                .setBigContentTitle("ORDER" + basket.status)

        );
        mBuilder_Gift.setContentTitle(getString(R.string.Notification_Gift_Title_def));
        mBuilder_Gift.setContentText("Some message...");

        mBuilder_Gift.setSmallIcon(R.drawable.ic_card_giftcard_black_24dp);
        mBuilder_Gift.setLargeIcon(BitmapHelper.getBitmapFromVector(this.getResources().getDrawable(R.drawable.ic_gift_box_yellow)));
        mNotificationManager.notify(i++, mBuilder_Gift.build());
        if (i > 7) i = 0;
    }


}
