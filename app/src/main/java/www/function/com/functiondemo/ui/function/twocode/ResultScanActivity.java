package www.function.com.functiondemo.ui.function.twocode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import www.function.com.functiondemo.R;

/**
 * 得到请求结果
 */
public class ResultScanActivity extends AppCompatActivity {

    private String result = "";
    private TextView mTextView;
    private ImageView mBackIv;
    private WebView mWebView; //webview网页加载
    private ProgressBar loadingProgressBar; //网络加载进度条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_scan);
        mTextView = (TextView) findViewById(R.id.textView);
        mWebView = (WebView) findViewById(R.id.webview);
        mBackIv = (ImageView) findViewById(R.id.back);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);
        Intent intent = this.getIntent();
        if (intent != null) {
            result = intent.getStringExtra("result");
        }
        if (!TextUtils.isEmpty(result)) {
            mTextView.setText("扫描结果：" + result);
        }
        //启用支持javascript
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl(result);
        setListener();
    }

    private void setListener(){
        //返回事件
        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否返回浏览过的网页
                if(mWebView.canGoBack()){
                    mWebView.goBack();
                } else {
                    finish();
                }
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient(){
            /**
             * 网络加载进度条
             * @param view
             * @param newProgress
             */
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                    if(newProgress == 100){ //网页加载完毕
                        loadingProgressBar.setVisibility(View.INVISIBLE); //此处采用INVISIBLE,是因为防止页面加载完毕后，页面出现闪动现象
                    } else { //网页正在加载中...
                        if(View.INVISIBLE == loadingProgressBar.getVisibility()){
                            loadingProgressBar.setVisibility(View.VISIBLE);
                        }
                        loadingProgressBar.setProgress(newProgress);
                    }
            }
        });

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                view.loadUrl(result);
                return true;
            }
        });
    }

    /**
     * 改写无论按键——浏览网页时返回的逻辑
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(mWebView.canGoBack()){
                mWebView.goBack();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
