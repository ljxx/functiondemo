package www.function.com.functiondemo.ui.function;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaInterfaceImpl;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewEngine;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.ui.function.pulign.Rss;
import www.function.com.functiondemo.utils.HtmlUrl;

public class MainCordovaActivity extends CordovaActivity {

    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mSystemWebView)
    SystemWebView mSystemWebView;
    @BindView(R.id.tv_select)
    TextView tvSelect;
    @BindView(R.id.go_refresh)
    TextView goRefresh;
    @BindView(R.id.rl_no_net)
    RelativeLayout rlNoNet;

    private CordovaWebView mCordovaWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cordova);
        System.out.println("==MainCordovaActivity==onCreate===执行啦=======");
        ButterKnife.bind(this);
        loadUrl(HtmlUrl.HOMEURL);
        System.out.println("==MainCordovaActivity==onCreate==123=执行啦=======");
    }

    @Override
    protected CordovaWebView makeWebView() {
        return new CordovaWebViewImpl(new SystemWebViewEngine(mSystemWebView));
    }

    @Override
    protected void createViews() {
        if (preferences.contains("BackgroundColor")) {
            int backgroundColor = preferences.getInteger("BackgroundColor", Color.BLACK);
            // Background of activity:
            appView.getView().setBackgroundColor(backgroundColor);
        }

        appView.getView().requestFocusFromTouch();
    }

    @OnClick({R.id.mTitle, R.id.mSystemWebView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mTitle:
                mSystemWebView.loadUrl("javascript:native('filterData','receive')");
                break;
            case R.id.mSystemWebView:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("===MainCordovaActivity===onActivityResult===执行啦=======");
    }
}
