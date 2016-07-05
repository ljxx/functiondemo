package www.function.com.functiondemo.ui.function.slidingtab.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterfaceImpl;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewEngine;

import java.util.concurrent.ArrayBlockingQueue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.utils.HtmlUrl;

/**
 * Created by admin on 2016/7/4.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mSystemWebView)
    SystemWebView mSystemWebView;

    private CordovaWebView cordovaWebView;
    public final ArrayBlockingQueue<String> onPageFinishedUrl = new ArrayBlockingQueue<String>(5);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_home_tab, null);
        ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    protected CordovaInterfaceImpl cordovaInterface = new CordovaInterfaceImpl(getActivity()) {
        @Override
        public Object onMessage(String id, Object data) {
            if ("onPageFinished".equals(id)) {
                onPageFinishedUrl.add((String) data);
            }
            return super.onMessage(id, data);
        }
    };

    /**
     * 初始化webview
     */
    private void initView() {
//Set up the webview
        ConfigXmlParser parser = new ConfigXmlParser();
        parser.parse(getActivity());

        cordovaWebView = new CordovaWebViewImpl(new SystemWebViewEngine(mSystemWebView));
        cordovaWebView.init(new CordovaInterfaceImpl(getActivity()), parser.getPluginEntries(), parser.getPreferences());
        cordovaWebView.loadUrl(HtmlUrl.HOMEURL);
    }

    public CordovaWebView getCordovaWebView() {
        return cordovaWebView;
    }

    @OnClick({R.id.mTitle, R.id.mSystemWebView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mTitle:
                break;
            case R.id.mSystemWebView:
                break;
        }
    }
}
