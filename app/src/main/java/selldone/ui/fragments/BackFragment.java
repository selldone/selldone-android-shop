package selldone.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.ArcMotion;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import selldone.activities.MainActivity;
import selldone.com.shop.R;
import selldone.ui.interfaces.FrameInterface;


public class BackFragment extends Fragment implements FrameInterface {


    ConstraintLayout constraintLayout;
    ConstraintSet constraintSet = new ConstraintSet();
    View clicked_view;
    private OnFragmentInteractionListener mListener;

    public BackFragment() {
        // Required empty public constructor
    }

    public static BackFragment newInstance() {
        BackFragment fragment = new BackFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        constraintLayout = (ConstraintLayout) inflater.inflate(R.layout.back_page, container, false);
        return constraintLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        AutoTransition transition = new AutoTransition();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            transition.setPathMotion(new ArcMotion());
        }

        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                if (clicked_view != null)
                    switch (clicked_view.getId()) {
                        case R.id.button_payment_form:
                            ((MainActivity) getActivity()).showShopInfoPage();
                            break;

                        case R.id.button_payment_qr:
                            ((MainActivity) getActivity()).showQRCodeScanner(null);
                            break;

                        case R.id.button_new_recipt:
                            ((MainActivity) getActivity()).showShopAdminPage();
                            break;


                    }
                clicked_view = null;
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
        constraintSet.clone(getContext(), R.layout.back_page);

        view.findViewById(R.id.button_payment_form).setOnClickListener(view1 -> {
            clicked_view = view1;
            TransitionManager.beginDelayedTransition(constraintLayout, transition);

            constraintSet.setVisibility(R.id.button_payment_qr, ConstraintSet.GONE);
            constraintSet.setVisibility(R.id.button_payment_qr_label, ConstraintSet.GONE);

            constraintSet.setVisibility(R.id.button_new_recipt, ConstraintSet.GONE);
            constraintSet.setVisibility(R.id.button_receipt_label, ConstraintSet.GONE);

            constraintSet.connect(R.id.button_payment_form, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
            constraintSet.connect(R.id.button_payment_form, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.connect(R.id.button_payment_form, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            constraintSet.connect(R.id.button_payment_form, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

            constraintSet.constrainWidth(R.id.button_payment_form, DpToPixel(120));
            constraintSet.constrainHeight(R.id.button_payment_form, DpToPixel(120));

            constraintSet.applyTo(constraintLayout);


        });
        view.findViewById(R.id.button_payment_qr).setOnClickListener(view1 -> {
            clicked_view = view1;
            TransitionManager.beginDelayedTransition(constraintLayout, transition);


            constraintSet.setVisibility(R.id.button_payment_form, ConstraintSet.GONE);
            constraintSet.setVisibility(R.id.button_payment_form_label, ConstraintSet.GONE);


            constraintSet.setVisibility(R.id.button_new_recipt, ConstraintSet.GONE);
            constraintSet.setVisibility(R.id.button_receipt_label, ConstraintSet.GONE);

            constraintSet.connect(R.id.button_payment_qr, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
            constraintSet.connect(R.id.button_payment_qr, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.connect(R.id.button_payment_qr, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            constraintSet.connect(R.id.button_payment_qr, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

            constraintSet.constrainWidth(R.id.button_payment_qr, DpToPixel(120));
            constraintSet.constrainHeight(R.id.button_payment_qr, DpToPixel(120));


            constraintSet.applyTo(constraintLayout);

        });

        view.findViewById(R.id.button_new_recipt).setOnClickListener(view1 -> {
            clicked_view = view1;
            TransitionManager.beginDelayedTransition(constraintLayout, transition);

            constraintSet.setVisibility(R.id.button_payment_form, ConstraintSet.GONE);
            constraintSet.setVisibility(R.id.button_payment_form_label, ConstraintSet.GONE);

            constraintSet.setVisibility(R.id.button_payment_qr, ConstraintSet.GONE);
            constraintSet.setVisibility(R.id.button_payment_qr_label, ConstraintSet.GONE);

            constraintSet.connect(R.id.button_new_recipt, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
            constraintSet.connect(R.id.button_new_recipt, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.connect(R.id.button_new_recipt, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            constraintSet.connect(R.id.button_new_recipt, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

            constraintSet.constrainWidth(R.id.button_new_recipt, DpToPixel(120));
            constraintSet.constrainHeight(R.id.button_new_recipt, DpToPixel(120));


            constraintSet.applyTo(constraintLayout);

        });


    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }


    public void resetState() {
        if (!isAdded() || getContext() == null) return;
        constraintSet.clone(getContext(), R.layout.back_page);
        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintSet.applyTo(constraintLayout);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public int getTitle() {
        return R.string.TopToolbar_HomeFragment;
    }

    protected int DpToPixel(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getContext().getResources().getDisplayMetrics());
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
