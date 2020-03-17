package selldone.ui.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import selldone.com.shop.R;
import selldone.ui.interfaces.FrameInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopInfoFragment extends Fragment implements FrameInterface {
    final static String TAG = ShopInfoFragment.class.getSimpleName();


    public ShopInfoFragment() {
        // Required empty public constructor
    }

    public static ShopInfoFragment newInstance() {
        ShopInfoFragment fragment = new ShopInfoFragment();
        Bundle args = new Bundle();


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.shop_info_page, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


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
        return R.string.TopToolbar_ShopInfoFragment;
    }


}
