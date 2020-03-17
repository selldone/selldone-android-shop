package selldone.ui.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import selldone.com.shop.R;
import selldone.ui.interfaces.FrameInterface;


public class ShopAdminFragment extends DialogFragment implements FrameInterface {

    final static String TAG = ShopAdminFragment.class.getSimpleName();


    ViewGroup rootView;


    public ShopAdminFragment() {

    }

    public static ShopAdminFragment newInstance() {
        ShopAdminFragment fragment = new ShopAdminFragment();
        Bundle args = new Bundle();


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }


    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);


        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow()
                    .getAttributes().windowAnimations = R.style.DialogAnimation;

            Window window = getDialog().getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        return super.onCreateDialog(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.admin_page, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rootView = (ViewGroup) view;

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "onStart");

    }


    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "onStop");


    }


    @Override
    public int getTitle() {
        return R.string.TopToolbar_ShopAdminFragment;
    }
}
