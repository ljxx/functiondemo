package www.function.com.functiondemo.ui.function;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
import www.function.com.functiondemo.utils.HtmlUrl;

public class MainCordovaActivity extends CordovaActivity {

    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mSystemWebView)
    SystemWebView mSystemWebView;

    private CordovaWebView mCordovaWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cordova);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        /*ConfigXmlParser mParser = new ConfigXmlParser();
        mParser.parse(this);
        mCordovaWebView = new CordovaWebViewImpl(new SystemWebViewEngine(mSystemWebView));
        mCordovaWebView.init(new CordovaInterfaceImpl(this), mParser.getPluginEntries(), mParser.getPreferences());
        mCordovaWebView.loadUrl(HtmlUrl.HOMEURL);*/
        loadUrl(HtmlUrl.HOMEURL);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("===MainCordovaActivity===onActivityResult===执行啦=======");
    }
}
