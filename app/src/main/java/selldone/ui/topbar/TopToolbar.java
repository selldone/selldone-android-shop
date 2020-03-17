package selldone.ui.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.PopupMenu;
import selldone.com.shop.R;
import selldone.ui.interfaces.FrameInterface;

public class TopToolbar extends FrameLayout {
    ImageButton imageButton_menu, imageButton_search;
    TextView textView_not_top, textView_sub_menu, textView_badge_animate_button;
    LottieAnimationView animation_button;
    TopBarInterface mTopBarInterface;
    PopupMenu.OnMenuItemClickListener shop_menu_listener = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mTopBarInterface == null) return true;

            switch (item.getItemId()) {
                case R.id.history:

                    //  webView.addJavascriptInterface(null,"");
                    mTopBarInterface.goToHistory();

                    break;
                case R.id.favorites:
                    mTopBarInterface.goToFavorites();

                    break;
                case R.id.gift_cards:

                    break;
                case R.id.return_requests:

                    break;
                case R.id.basket:

                    break;
                case R.id.logout:
                    mTopBarInterface.logout();

                    break;


            }
            return false;
        }
    };

    public TopToolbar(@NonNull Context context) {
        this(context, null);
    }

    public TopToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopToolbar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.top_toolbar, this, true);


        textView_not_top = findViewById(R.id.textView_not_top);

        imageButton_menu = findViewById(R.id.imageButton_menu);
        imageButton_search = findViewById(R.id.imageButton_search);
        textView_sub_menu = findViewById(R.id.textView_sub_menu);

        animation_button = findViewById(R.id.animation_button);
        textView_badge_animate_button = findViewById(R.id.textView_badge_animate_button);
        textView_badge_animate_button.setVisibility(GONE);


        ImageButton imageButton_shopMenu = findViewById(R.id.imageButton_shopMenu);
        imageButton_shopMenu.setOnClickListener(v -> showPopup(v));
        textView_not_top.setOnClickListener(v -> showPopup(v));

        imageButton_menu.setOnClickListener(v -> mTopBarInterface.goToHome());

        HideAnimateButton();
    }

    public void registerListener(TopBarInterface topBarInterface) {
        this.mTopBarInterface = topBarInterface;
    }


    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this.getContext(), v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.samin_shop_menu, popup.getMenu());
        popup.show();

        popup.setOnMenuItemClickListener(shop_menu_listener);
    }


    public void ShowAnimateButton(AnimateButtonType animateButtonType, OnClickListener onCloseListener, int badge_count) {
        animation_button.setVisibility(View.VISIBLE);
        animation_button.setAnimation(animateButtonType.happy_birthday);
        animation_button.playAnimation();
        animation_button.setOnClickListener(onCloseListener);

        textView_badge_animate_button.setVisibility(badge_count == 0 ? GONE : VISIBLE);
        textView_badge_animate_button.setText(badge_count < 10 ? String.valueOf(badge_count) : "+9");

    }

    public void HideAnimateButton() {
        animation_button.setVisibility(View.GONE);
        animation_button.cancelAnimation();
        animation_button.setOnClickListener(null);

    }


    public void goToShowBackButtonState(OnClickListener onCloseListener) {
        imageButton_search.setImageResource(R.drawable.ic_keyboard_backspace_black_24dp);
        imageButton_search.setOnClickListener(onCloseListener);
        //textView_not_top.setText(currentBackFrame == null ? "کیف پول ثمین" : currentBackFrame.getTitle());
    }

    public void goToBackFrameState(FrameInterface currentBackFrame, OnClickListener onCloseListener) {
        imageButton_search.setImageResource(R.drawable.ic_close_black_24dp);
        imageButton_search.setOnClickListener(onCloseListener);
        textView_not_top.setText(currentBackFrame == null ? R.string.TopToolbar_MainPage : currentBackFrame.getTitle());
    }

    public void goToHomeState(FrameInterface currentBackFrame, OnClickListener onQRScanListener) {
        imageButton_search.setImageResource(R.drawable.ic_center_focus_weak_black_24dp);
        imageButton_search.setOnClickListener(onQRScanListener);
        textView_not_top.setText(currentBackFrame == null ? R.string.TopToolbar_MainPage : currentBackFrame.getTitle());
    }

    public void goToQRScanState(OnClickListener onCloseListener) {
        imageButton_search.setImageResource(R.drawable.ic_close_black_24dp);
        imageButton_search.setOnClickListener(onCloseListener);
        textView_not_top.setText(R.string.TopToolbar_QRScanState);
    }

    public void setMenu(@DrawableRes int icon, OnClickListener onClickListener, @StringRes int menu_name) {
        textView_sub_menu.setText(menu_name);
        imageButton_menu.setImageResource(icon);
        imageButton_menu.setOnClickListener(onClickListener);
    }


    public enum AnimateButtonType {
        GIFT(R.raw.happy_birthday),
        LOADING(R.raw.loader),
        EMOJI_WINK(R.raw.emoji_wink),


        ;
        @RawRes
        public int happy_birthday;

        AnimateButtonType(@RawRes int happy_birthday) {
            this.happy_birthday = happy_birthday;
        }
    }
}
