package selldone.ui.interfaces;

import android.view.View;

import java.util.HashMap;

import androidx.fragment.app.Fragment;

public interface OnShowFragmentInteraction {

    void OnShowFragmentWithTransition(Fragment current, Fragment newFragment, String tag, HashMap<View, String> transitions_view, int frame_id);
}
