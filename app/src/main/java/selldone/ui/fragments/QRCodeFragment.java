package selldone.ui.fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import selldone.com.shop.R;
import selldone.helpers.FormatHelper;
import selldone.helpers.QRCodeHelper;
import selldone.ui.interfaces.FrameInterface;


public class QRCodeFragment extends DialogFragment implements FrameInterface {
    final static String TAG = QRCodeFragment.class.getSimpleName();

    private static final String ARG_QR_URI = "ARG_QR_URI";
    private static final String ARG_URL = "ARG_QR_DATA";
    private static final String ARG_AMOUNT = "ARG_AMOUNT";
    private static final String ARG_CURRENCY = "ARG_CURRENCY";
    private static final String ARG_DESCRIPTION = "ARG_DESCRIPTION";
    ImageView imageView_icon_currency;
    LottieAnimationView animation_scan;
    private String qr_uri;
    private String url;
    private double amount;
    private String description;
    private ImageButton imageView_qrcode;


    public QRCodeFragment() {

    }

    public static QRCodeFragment newInstance(Object receipt) {
        QRCodeFragment fragment = new QRCodeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, null);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppThemeDark);

        if (getArguments() != null) {
            qr_uri = getArguments().getString(ARG_QR_URI);
            url = getArguments().getString(ARG_URL);
            amount = getArguments().getDouble(ARG_AMOUNT);
            description = getArguments().getString(ARG_DESCRIPTION);

            if (url == null) url = qr_uri;
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_qr_code_show, container, false);
        //    return inflater.inflate(R.layout.fragment_receipt_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        animation_scan = view.findViewById(R.id.animation_scan);

        if (qr_uri == null) return;


        imageView_qrcode = view.findViewById(R.id.imageView_qrcode);
        imageView_icon_currency = view.findViewById(R.id.imageView_icon_currency);


        imageView_icon_currency.setScaleX(0.5f);
        imageView_icon_currency.setScaleY(0);

        imageView_qrcode.setScaleX(0.5f);
        imageView_qrcode.setScaleY(0);

        Log.v(TAG, "uri= " + qr_uri);
        QRCodeHelper.GenerateQRCode(qr_uri, DpToPixel(168)).subscribe(new SingleObserver<Bitmap>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Bitmap bitmap) {
                imageView_qrcode.setImageBitmap(bitmap);
                imageView_qrcode.animate().setStartDelay(200).scaleY(1).scaleX(1).start();
                imageView_icon_currency.animate().setStartDelay(250).scaleY(1).scaleX(1).start();
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        TextView textView_description = view.findViewById(R.id.textView_description);
        TextView textView_amount = view.findViewById(R.id.textView_amount);


        textView_amount.setText(getAmountText());


        textView_description.setText(description);


        ImageButton imageButton_share = view.findViewById(R.id.imageButton_share);
        imageButton_share.setOnClickListener(view1 -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = String.format("%s \nمبلغ: %s\nآدرس رسید: %s", description, getAmountText(), url);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "رسید پرداخت");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "اشتراک گذاری رسید"));
        });


        View imageButton_close = view.findViewById(R.id.imageButton_close);

        if (getDialog() != null) {
            imageButton_close.setOnClickListener(view12 -> {
                getView().postDelayed(this::dismiss, 100);
            });
        } else
            imageButton_close.setVisibility(View.GONE);

    }

    private String getAmountText() {
        String amount_text = FormatHelper.FormatNumber(amount);

        return amount_text;
    }


    protected int DpToPixel(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getContext().getResources().getDisplayMetrics());
    }


    @Override
    public int getTitle() {
        return R.string.TopToolbar_QRCodeFragment;
    }
}
