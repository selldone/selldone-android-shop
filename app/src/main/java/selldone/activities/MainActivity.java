package selldone.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionManager;
import me.dm7.barcodescanner.zbar.BarcodeFormat;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;
import selldone.api.ShopHelperMethods;
import selldone.com.shop.R;
import selldone.fcm.FirebaseMessagingServiceSamin;
import selldone.helpers.COLOR;
import selldone.helpers.CircleTransform;
import selldone.models.Basket;
import selldone.models.ShopDataPack;
import selldone.models.User;
import selldone.routes.ShopRoute;
import selldone.ui.fragments.BackFragment;
import selldone.ui.fragments.ShopAdminFragment;
import selldone.ui.fragments.ShopInfoFragment;
import selldone.ui.gesture.CustomGestureListener;
import selldone.ui.gesture.SwipeConstraintLayout;
import selldone.ui.interfaces.FrameInterface;
import selldone.ui.interfaces.OnShowFragmentInteraction;
import selldone.ui.interfaces.QRCodeScannerCallback;
import selldone.ui.topbar.TopBarInterface;
import selldone.ui.topbar.TopToolbar;

public class MainActivity extends AppCompatActivity implements OnShowFragmentInteraction, ActivityCompat.OnRequestPermissionsResultCallback
        , ZBarScannerView.ResultHandler {


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Static fields ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    final static String TAG = MainActivity.class.getSimpleName();
    final static int BUSINESS_PAGE_IN_MAIN = 0;
    final static int BUSINESS_PAGE_SHOW_FRAGMENT = 1;
    final static int STATE_SHOW_PURSE = 0;
    final static int STATE_PULLED_UP_CARD = 1;
    private static final int PERMISSION_REQUESTS = 1;
    private static long back_pressed;


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Local fields ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    WebView webView;
    FrameInterface currentBackFrame;
    ZBarScannerView mScannerView;
    FrameLayout back_frame;
    FrameLayout home_frame;
    BottomNavigationView bottom_navigation;
    TopToolbar topToolbar;
    int state_business_page = BUSINESS_PAGE_IN_MAIN;
    BackFragment homeFragment = BackFragment.newInstance();
    ConstraintLayout camera_container;
    AppCompatImageButton button_camera_flash;
    Transition transaction_go_back_frame = new AutoTransition();
    Transition transaction_go_home_frame = new AutoTransition();
    Transition transaction_go_qr = new AutoTransition();
    QRCodeScannerCallback mQRCodeScannerCallback;
    Dialog dialog_QRCodeScanner;
    CardView card_main;
    SwipeConstraintLayout main_layout;
    float SwipeMainPage_StartY;
    float SwipeMainPage_StartX;
    float SwipeMainPage_Start_Translation_Y;
    int state = STATE_SHOW_PURSE;
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    TextView textView_not_top;
    ShopDataPack mShopDataPack;
    User mUser;


    String shop_name = null;


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Static Methods ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    private static boolean isPermissionGranted(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission granted: " + permission);
            return true;
        }
        Log.i(TAG, "Permission NOT granted: " + permission);
        return false;
    }

    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Activity life cycle ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // ═══ remove title ═══
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);
        showSplashScreen();



        /*
         * ═══ UI components ═══
         */

        // Shop loading view:
        findViewById(R.id.progressBar_loading).setVisibility(View.VISIBLE);

        topToolbar = findViewById(R.id.topToolbar);

        textView_not_top = findViewById(R.id.textView_not_top);

        back_frame = findViewById(R.id.back_frame);
        home_frame = findViewById(R.id.home_frame);

        webView = findViewById(R.id.webview);
        bottom_navigation = findViewById(R.id.bottom_navigation);

        // Load user data from DB or preferences.. (set null by default)
        onGetUser(null);
        /*
         * ═══ Load PWA ═══
         */
        shop_name = getString(R.string.shop_name);     // Shop user name : selldone.com/@mobile ➔ shop_name = mobile

        String pwa_url = "https://selldone.com/@" + shop_name;        // Shop PWA url

        // Change web setting to load PWA:
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Set chrome as web client:
        webView.setWebChromeClient(new WebChromeClient() {

            // Log console output of the embedded web view:
            public boolean onConsoleMessage(ConsoleMessage message) {
                Log.d("Webview", message.message());
                return false;
            }
        });

        // 🗘 Set Javascript to Android interface:
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // 🞴 Load native mode of app: no title , no footer:
        webView.loadUrl(pwa_url + "?native=true");






        /*
        Bottom navigation
         */

        bottom_navigation.setOnNavigationItemSelectedListener(item -> {

            if (mShopDataPack == null || mShopDataPack.shop == null) return false;


            if (item.getItemId() == R.id.action_home) {
                GoToPath("ShopPage");


            } else if (item.getItemId() == R.id.action_basket) {

                ShopRoute.GoToBasket(webView, Basket.Type.PHYSICAL);

            } else if (item.getItemId() == R.id.action_profile) {


                if (mUser == null) {
                    // Request login:

                    RequestLogin();
                } else {
                    // Show user page:
                    GoToPath("HistoryOrdersPhysical");
                }


            }
            return true;
        });


      /*
      Initialize some UIs
       */
        init_swipe();
        initQRCode();




        /*
        Deploy home fragment
         */
        showFragment(R.id.home_frame, homeFragment, "home", false);


        // Test: initial mode
        card_main.post(() -> {
            //   RequestShowHomePage();
        });

        /*
         * Top main bar listener
         */
        topToolbar.registerListener(new TopBarInterface() {
            @Override
            public void goToHome() {
                GoToPath("ShopPage");
                bottom_navigation.setSelectedItemId(R.id.action_home);
            }

            @Override
            public void goToHistory() {
                GoToPath("HistoryOrdersPhysical");

            }

            @Override
            public void goToFavorites() {
                GoToPath("UserFavoritesPage");
            }

            @Override
            public void logout() {
                NativeLogout();
                onGetUser(null);

            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause


    }

    @Override
    public void onStop() {
        super.onStop();
    }


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ PWA interface (Android ➡ PWA) ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    void GoToPath(String path_name) {
        GoToPath(path_name, null, null);
    }

    void GoToPath(String path_name, HashMap<String, String> params) {
        GoToPath(path_name, params, null);
    }

    /**
     * Javascript interface > Shop App > Push route app
     *
     * @param path_name : Route name in the vue route {@link ShopRoute}
     * @param params    the params
     * @param query     the query
     */
    void GoToPath(String path_name, HashMap<String, String> params, HashMap<String, String> query) {

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

    /**
     * Request login.
     * <p>
     * Login process:
     * 1. Request login by url intent                                    ⬅
     * 2. Receive token by custom URI call intent {@link #onNewIntent}
     * 3. Send token to PWA in the webview {@link #SetToken}
     * <p>
     * Done!
     */
    void RequestLogin() {
        String url = "http://selldone.com/@" + mShopDataPack.shop.name + "/login" + "?app=selldone://" + shop_name + ".callback";
        Uri uri = Uri.parse(url);

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(uri);
        startActivity(i);
    }

    /**
     * Javascript interface > Shop App > Set access token to PWA
     * <p>
     * Login process:
     * 1. Request login by url intent {@link #RequestLogin}
     * 2. Receive token by custom URI call intent {@link #onNewIntent}
     * 3. Send token to PWA in the webview                                  ⬅
     *
     * @param token : access token (get in login process by redirect custom scheme URL)
     */
    void SetToken(String token) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript("SetToken('" + token + "');", null);
        } else {
            webView.loadUrl("javascript:SetToken('" + token + "');");
        }
    }

    /**
     * Logout PWA
     */
    void NativeLogout() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript("NativeLogout();", null);
        } else {
            webView.loadUrl("javascript:SetToken();");
        }
    }

    /**
     * After fetch current shop info
     *
     * @param shopDataPack
     */
    private void onGetShopDataPack(ShopDataPack shopDataPack) {
        this.mShopDataPack = shopDataPack;

        if (shopDataPack.shop == null) return;
        textView_not_top.setText(shopDataPack.shop.title);

        // Set shop icon:
        ImageButton imageButton_menu = findViewById(R.id.imageButton_menu);
        Picasso.get().load(ShopHelperMethods.getShopIcon(shopDataPack.shop.id, "128")).transform(new CircleTransform()).placeholder(R.drawable.ic_chick).into(imageButton_menu);

        // Hide loading view:
        findViewById(R.id.progressBar_loading).setVisibility(View.GONE);
        findViewById(R.id.imageView_cover_loading).setVisibility(View.GONE);


    }

    /**
     * After get user info
     *
     * @param user
     */
    private void onGetUser(User user) {
        this.mUser = user;


        Menu menu = bottom_navigation.getMenu();

        if (user != null) {
            menu.getItem(1).setEnabled(true);
            menu.getItem(2).setTitle("Profile");
            menu.getItem(2).setIcon(R.drawable.ic_account_circle_black_24dp);

            // Set user avatar:
            ImageButton imageButton_userAvatar = findViewById(R.id.imageButton_userAvatar);
            Picasso.get().load(ShopHelperMethods.getUserAvatar(user.id, "small")).transform(new CircleTransform()).placeholder(R.drawable.ic_chick).into(imageButton_userAvatar);


        } else {
            menu.getItem(1).setEnabled(false);
            menu.getItem(2).setTitle("Login");
            menu.getItem(2).setIcon(R.drawable.ic_account_circle_black_24dp);

        }
        bottom_navigation.invalidate();
    }

    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ PWA interface (PWA ➡ Android) ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    /**
     * Handle custom scheme URI (Authentication)
     * Caution: check digital asset verification for direct auth link to app.
     * https://developer.android.com/training/app-links/verify-site-associations
     * <p>
     * Login process:
     * 1. Request login by url intent {@link #RequestLogin}
     * 2. Receive token by custom URI call intent                 ⬅
     * 3. Send token to PWA in the webview {@link #SetToken}
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Uri uri = intent.getData();

        if (uri == null) return;
        Log.v("uri", uri.toString());

        if (uri.getScheme() != null && uri.getScheme().contentEquals("selldone")) {
            String token = uri.getQueryParameter("token");
            if (token != null) {
                Log.v("token", token);
                SetToken(token);
            }
        }
    }


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Intents ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        Log.i(TAG, "Permission granted!");
        if (cameraPermissionsGranted()) {
            mScannerView.startCamera();          // Start camera on resume
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Android Permissions ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    /**
     * Camera permission
     */
    private String[] getCameraPermissions() {
        return new String[]{Manifest.permission.CAMERA};
    }

    private boolean cameraPermissionsGranted() {
        for (String permission : getCameraPermissions()) {
            if (!isPermissionGranted(this, permission)) {
                return false;
            }
        }
        return true;
    }

    private void getCameraRuntimePermissions() {
        List<String> allNeededPermissions = new ArrayList<>();
        for (String permission : getCameraPermissions()) {
            if (!isPermissionGranted(this, permission)) {
                allNeededPermissions.add(permission);
            }
        }

        if (!allNeededPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(
                    this, allNeededPermissions.toArray(new String[0]), PERMISSION_REQUESTS);
        }
    }

    public void RequestBackToMainBusinessPage() {


        state_business_page = BUSINESS_PAGE_IN_MAIN;

    }


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Internal functions ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    /**
     * ZBarScannerView
     */
    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v(TAG, rawResult.getContents()); // Prints scan results
        Log.v(TAG, rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

        if (mQRCodeScannerCallback != null) {
            if (mQRCodeScannerCallback.onQRScanResult(rawResult, rawResult.getContents(), rawResult.getBarcodeFormat())) {
                mQRCodeScannerCallback = null;
                if (dialog_QRCodeScanner != null && dialog_QRCodeScanner.isShowing())
                    dialog_QRCodeScanner.dismiss();

                return;
            }

        }


        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(BarcodeFormat.QRCODE);
        mScannerView.setFormats(formats);


    }


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ZBarScannerView Interface ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    private void initQRCode() {
        camera_container = findViewById(R.id.camera_container);
        camera_container.setVisibility(View.GONE);
        button_camera_flash = findViewById(R.id.button_camera_flash);


        mScannerView = findViewById(R.id.qrdecoderview);    // Programmatically initialize the scanner view

        mScannerView.setAutoFocus(true);


        mScannerView.setLaserColor(COLOR.AMBER);
        mScannerView.setBorderColor(COLOR.AMBER);

        mScannerView.setBorderStrokeWidth(DptoPixel(2));
        mScannerView.setBorderLineLength(DptoPixel(24));
        mScannerView.setLaserEnabled(false);
        mScannerView.setIsBorderCornerRounded(true);
        mScannerView.setBorderCornerRadius(DptoPixel(12));

        mScannerView.setSquareViewFinder(true);
        //   mScannerView.  setBorderAlpha(0.7f);
        button_camera_flash.setImageResource(mScannerView.getFlash() ? R.drawable.ic_light_on : R.drawable.ic_light_off);
        button_camera_flash.setOnClickListener(view -> {
            mScannerView.toggleFlash();
            button_camera_flash.setImageResource(mScannerView.getFlash() ? R.drawable.ic_light_on : R.drawable.ic_light_off);
        });

    }

    @SuppressLint("ClickableViewAccessibility")
    private void init_swipe() {

        card_main = findViewById(R.id.card_main);
        main_layout = findViewById(R.id.main_layout);

        // Create a GestureDetector
        GestureDetector mGestureDetector = new GestureDetector(this, new CustomGestureListener(main_layout) {

            @Override
            public void onDownCall(MotionEvent e) {
            }

            @Override
            public void onFlingCall(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            }

            @Override
            public boolean onSwipeRight(float velocity) {
                return false;
            }

            @Override
            public boolean onSwipeLeft(float velocity) {
                return false;
            }

            @Override
            public boolean onSwipeDown(float velocityY) {
                if (velocityY > ViewConfiguration.get(getApplicationContext()).getScaledMinimumFlingVelocity() * 2)
                    state = STATE_SHOW_PURSE;
                Log.v(TAG, "onSwipeDown");
                return true;
            }

            @Override
            public boolean onSwipeUp(float velocityY) {
                if (velocityY > ViewConfiguration.get(getApplicationContext()).getScaledMinimumFlingVelocity() * 2)
                    state = STATE_PULLED_UP_CARD;
                Log.v(TAG, "onSwipeUp");
                return true;
            }

            @Override
            public boolean onTouch() {
                return false;
            }
        });


        //container click listener


        main_layout.setOnTouchListener((v, event) -> {
            boolean used = mGestureDetector.onTouchEvent(event);


            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                SwipeMainPage_StartY = event.getY(0);
                SwipeMainPage_StartX = event.getX(0);
                SwipeMainPage_Start_Translation_Y = card_main.getTranslationY();
                //  }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {

                GoToState();

            } else if (event.getAction() == MotionEvent.ACTION_CANCEL) {
                GoToState();

            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

                //   card_main.setY(event.getY());
                card_main.setTranslationY(SwipeMainPage_Start_Translation_Y + event.getY(0) - SwipeMainPage_StartY);
                card_main.setTranslationX((event.getX(0) - SwipeMainPage_StartX) / 8);
            }

            return !used;

        });
        main_layout.setGestureDetector(mGestureDetector);
    }

    public void GoToState() {


        if (state == STATE_SHOW_PURSE) {
            main_layout.setInActiveCardView(card_main);
            card_main.animate().translationY(card_main.getMeasuredHeight() - DptoPixel(64))
                    .translationX(0)
                    .setInterpolator(new AccelerateDecelerateInterpolator()).start();
        } else if (state == STATE_PULLED_UP_CARD) {
            main_layout.setInActiveCardView(null);
            card_main.animate().translationY(0).translationX(0).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }

    }

    /**
     * @deprecated
     */
    private void request_permition() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {


                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);


            }
        }
    }

    public int DptoPixel(float dp) {
        Resources r = this.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return (int) px;
    }

    private void showFragment(int frame_id, Fragment fragment, String tag, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        // check if the fragment is in back stack
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(tag, 0); // POP_BACK_STACK_INCLUSIVE -> 0
        if (fragmentPopped) {
            // fragment is pop from backStack
        } else {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(frame_id, fragment, tag);


            if (addToBackStack)
                fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        }

    }

    /**
     * function to go back to previous fragment
     */
    private void oneStepBack() {


        switch (bottom_navigation.getSelectedItemId()) {

            case R.id.action_profile:
                if (state_business_page == BUSINESS_PAGE_SHOW_FRAGMENT) {
                    RequestBackToMainBusinessPage();
                    return;
                } else {
                    bottom_navigation.setSelectedItemId(R.id.action_basket);
                    return;
                }


            case R.id.action_basket:
                if (state_business_page == BUSINESS_PAGE_SHOW_FRAGMENT) {
                    RequestBackToMainBusinessPage();
                    return;
                } else {
                    bottom_navigation.setSelectedItemId(R.id.action_home);
                    return;
                }


            case R.id.action_home:
                FragmentManager fragmentManager = getSupportFragmentManager();

                if (fragmentManager.getBackStackEntryCount() >= 2) {
                    if (fragmentManager.getBackStackEntryCount() == 2) {
                        topToolbar.goToHomeState(homeFragment, view -> showQRCodeScanner(null));
                    }
                    //fragmentManager.popBackStackImmediate(); //animation transition problem!
                    fragmentManager.popBackStack();
                    FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
                    fts.commit();


                    return;
                }

                if (state == STATE_SHOW_PURSE) {
                    if (!(currentBackFrame instanceof BackFragment)) {
                        showHomePage();
                        return;
                    }
                } else {
                    state = STATE_SHOW_PURSE;
                    GoToState();
                    return;
                }


        }


        doubleClickToExit();


    }

    private void doubleClickToExit() {
        if ((back_pressed + 2000) > System.currentTimeMillis())
            finish();
        else
            Toast.makeText(MainActivity.this, "برای خروج مجددا کلید بازگشت را فشار دهید.", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    @Override
    public void onBackPressed() {
        oneStepBack();
    }

    private void closeKeyboard() {
        View view = main_layout.findFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Sync FCM token by Samin server
     *
     * @deprecated
     */
    private void SyncFCMToken() {
        Log.v(TAG, "SyncFCMToken ");

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(instanceIdResult -> {
            String token = instanceIdResult.getToken();
            Log.d(TAG, "FCM Token: " + token);
            FirebaseMessagingServiceSamin.sendRegistrationToServer(this, token);
        });
    }

    public TopToolbar getTopToolbar() {
        return topToolbar;
    }

    /**
     * Show splash screen
     */
    private void showSplashScreen() {
        final ConstraintLayout splash_container = findViewById(R.id.splash_container);
        ImageView imageView_splash = findViewById(R.id.imageView_splash);
        splash_container.setVisibility(View.VISIBLE);


        imageView_splash.setScaleX(1.2f);
        imageView_splash.setScaleY(1.2f);

        imageView_splash.animate().scaleX(1).scaleY(1).setDuration(1800).withEndAction(new Runnable() {
            @Override
            public void run() {
                splash_container.animate().setStartDelay(450).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        splash_container.setVisibility(View.GONE);
                    }
                }).start();
            }
        }).setInterpolator(new AccelerateInterpolator()).start();

/*
        GradientDrawable dialog_YEllow = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
                new int[]{0xFF3a2c41, 0xFF70557e});

        GradientDrawable dialog_PINK = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
                new int[]{0xFF70557e, 0xFF3a2c41});


        TransitionDrawable trans = new TransitionDrawable(new Drawable[]{dialog_YEllow, dialog_PINK});
        trans.startTransition(1800);
        splash_container.setBackground(trans);*/
    }


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Pages ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    public void showBackFrame() {
        transaction_go_back_frame.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull Transition transition) {
                state = STATE_SHOW_PURSE;
                GoToState();
            }

            @Override
            public void onTransitionEnd(@NonNull Transition transition) {

                transaction_go_back_frame.removeListener(this);
            }

            @Override
            public void onTransitionCancel(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionPause(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionResume(@NonNull Transition transition) {

            }
        });

        transaction_go_back_frame.excludeChildren(camera_container, true);
        transaction_go_back_frame.excludeChildren(R.id.back_frame, true);
        transaction_go_back_frame.excludeChildren(R.id.home_frame, true);

        TransitionManager.beginDelayedTransition(main_layout, transaction_go_back_frame);

        camera_container.setVisibility(View.GONE);
        button_camera_flash.setVisibility(View.GONE);
        home_frame.setVisibility(View.GONE);
        back_frame.setVisibility(View.VISIBLE);


        topToolbar.goToBackFrameState(currentBackFrame, view -> showHomePage());

    }

    public void showShopInfoPage() {

        ShopInfoFragment transactionFormFragment = ShopInfoFragment.newInstance();
        showFragment(R.id.back_frame, transactionFormFragment, "shop-info", false);
        currentBackFrame = transactionFormFragment;
        showBackFrame();

    }

    public void showShopAdminPage() {
        ShopAdminFragment receiptAddFragment = ShopAdminFragment.newInstance();
        showFragment(R.id.back_frame, receiptAddFragment, "shop-admin", false);
        currentBackFrame = receiptAddFragment;
        showBackFrame();

    }

    public void showHomePage() {
        closeKeyboard();
        currentBackFrame = homeFragment;

        //   textView_not_top.setText(homeFragment.getTitle());

        transaction_go_home_frame.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull Transition transition) {
            }

            @Override
            public void onTransitionEnd(@NonNull Transition transition) {
                state = STATE_SHOW_PURSE;
                GoToState();
                transaction_go_home_frame.removeListener(this);

                homeFragment.resetState();
            }

            @Override
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            @Override
            public void onTransitionPause(@NonNull Transition transition) {
            }

            @Override
            public void onTransitionResume(@NonNull Transition transition) {
            }
        });

        transaction_go_home_frame.excludeTarget(camera_container, true);
        transaction_go_home_frame.excludeTarget(R.id.main_layout, true);
        TransitionManager.beginDelayedTransition(main_layout, transaction_go_home_frame);

        camera_container.setVisibility(View.GONE);
        button_camera_flash.setVisibility(View.GONE);

        back_frame.setVisibility(View.GONE);
        home_frame.setVisibility(View.VISIBLE);


        topToolbar.goToHomeState(homeFragment, view -> showQRCodeScanner(null));

    }

    public void showQRCodeScanner(@Nullable QRCodeScannerCallback qrCodeScannerCallback) {
        this.mQRCodeScannerCallback = qrCodeScannerCallback;

        if (cameraPermissionsGranted()) {
            mScannerView.startCamera();          // Start camera on resume
        } else {
            getCameraRuntimePermissions();
        }


        mScannerView.resumeCameraPreview(this);
        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(BarcodeFormat.QRCODE);
        mScannerView.setFormats(formats);


        if (qrCodeScannerCallback != null) {
            dialog_QRCodeScanner = new Dialog(this);
            //   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_QRCodeScanner.setCancelable(true);
            ConstraintLayout.LayoutParams param = (ConstraintLayout.LayoutParams) mScannerView.getLayoutParams();
            ViewGroup viewGroup_ordinal_parent = (ViewGroup) mScannerView.getParent();
            viewGroup_ordinal_parent.removeView(mScannerView);


            Rect displayRectangle = new Rect();
            Window window = this.getWindow();
            window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog_QRCodeScanner.getWindow().getAttributes());
            lp.width = displayRectangle.width() / 2;
            lp.height = displayRectangle.width() / 2;
            dialog_QRCodeScanner.show();
            dialog_QRCodeScanner.getWindow().setAttributes(lp);

            dialog_QRCodeScanner.setContentView(mScannerView);
            dialog_QRCodeScanner.setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    ViewGroup viewGroup = (ViewGroup) mScannerView.getParent();
                    if (viewGroup != null)
                        viewGroup.removeView(mScannerView);

                    viewGroup_ordinal_parent.addView(mScannerView, param);

                }
            });

            dialog_QRCodeScanner.show();
            return;
        }


        transaction_go_qr.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull Transition transition) {
                state = STATE_SHOW_PURSE;
                GoToState();
            }

            @Override
            public void onTransitionEnd(@NonNull Transition transition) {

                transaction_go_qr.removeListener(this);
            }

            @Override
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            @Override
            public void onTransitionPause(@NonNull Transition transition) {
            }

            @Override
            public void onTransitionResume(@NonNull Transition transition) {
            }
        });

        TransitionManager.beginDelayedTransition(main_layout, transaction_go_qr);


        //  imageButton_search.setImageResource(R.drawable.ic_close_black_24dp);
        camera_container.setVisibility(View.VISIBLE);
        button_camera_flash.setVisibility(View.VISIBLE);


        back_frame.setVisibility(View.GONE);
        home_frame.setVisibility(View.GONE);



     /*   imageButton_search.setOnClickListener(view -> {

            mScannerView.stopCamera();

            camera_container.animate().setStartDelay(0).scaleX(0.5f).scaleY(0.0f).withEndAction(() -> RequestShowHomePage()).start();
        });*/

        //  textView_not_top.setText("کد QR را اسکن نمایید");


        topToolbar.goToQRScanState(view -> {
            mScannerView.stopCamera();
            camera_container.animate().setStartDelay(0).scaleX(0.5f).scaleY(0.0f).withEndAction(() -> showHomePage()).start();
        });


        camera_container.setScaleX(0.5f);
        camera_container.setScaleY(0);

        camera_container.animate().setStartDelay(1200).scaleX(1.0f).scaleY(1.0f).setDuration(300).start();


    }

    @Override
    public void OnShowFragmentWithTransition(Fragment current, Fragment newFragment, String tag, final HashMap<View, String> transitions_view, int frame_id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        // check if the fragment is in back stack
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(tag, 0);
        if (fragmentPopped) {
            // fragment is pop from backStack
        } else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


                Transition default_transition = TransitionInflater.from(this).inflateTransition(R.transition.default_transition);
                default_transition.setStartDelay(300);
                default_transition.setDuration(480);

                Transition slide_left = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_left);
                slide_left.setDuration(300);


                Transition slide_right = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_right);
                slide_right.setDuration(700);

                Transition no_transition = TransitionInflater.from(this).inflateTransition(android.R.transition.no_transition);

                current.setSharedElementReturnTransition(default_transition);
                //   current.setExitTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.no_transition));
                current.setExitTransition(slide_left);

                //  newFragment.setExitTransition(slide_right);

                newFragment.setSharedElementEnterTransition(default_transition);
                newFragment.setEnterTransition(no_transition);
                //    newFragment.setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_back));


                // Added for return!
                //   newFragment.setExitTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.fade));
                // current.setEnterTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.no_transition));

                //  newFragment.setSharedElementReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.default_transition));
                //  current.setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.default_transition));

            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(frame_id, newFragment, tag);
            fragmentTransaction.addToBackStack(tag);

            for (View view : transitions_view.keySet()) {
                fragmentTransaction.addSharedElement(view, transitions_view.get(view));
            }

            fragmentTransaction.commit();

            getTopToolbar().goToShowBackButtonState(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    oneStepBack();
                }
            });

        }

    }


    // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ OnShowFragmentInteraction Interface ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    public class WebAppInterface {
        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Call by PWA when received shop data
         *
         * @param data_json Shop data
         */
        @JavascriptInterface
        public void passShop(String data_json) {
            Log.d(TAG, "passShop: " + data_json);

            Gson gson = new Gson();
            ShopDataPack shopDataPack = gson.fromJson(data_json, ShopDataPack.class);

            runOnUiThread(() -> onGetShopDataPack(shopDataPack));
        }

        /**
         * Call by PWA when received user data
         *
         * @param data_json User data
         */
        @JavascriptInterface
        public void passUser(String data_json) {
            Log.d(TAG, "passUser: " + data_json);

            if (data_json == null) {
                runOnUiThread(() -> onGetUser(null));
                return;
            }


            Gson gson = new Gson();
            User user = gson.fromJson(data_json, User.class);
            runOnUiThread(() -> onGetUser(user));
        }
    }
}
