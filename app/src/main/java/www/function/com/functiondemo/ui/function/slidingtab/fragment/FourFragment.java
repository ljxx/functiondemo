package www.function.com.functiondemo.ui.function.slidingtab.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.function.com.functiondemo.R;

/**
 * Created by admin on 2016/7/4.
 */
public class FourFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_four_tab,null);

        return mView;
    }
}
