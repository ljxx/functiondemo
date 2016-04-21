package www.function.com.functiondemo.ui.function.twocode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import www.function.com.functiondemo.R;

/**
 * 得到请求结果
 */
public class ResultScanActivity extends AppCompatActivity {

    String result = "";
    TextView mTextView;
    ImageView mBackIv;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_scan);
        mTextView = (TextView) findViewById(R.id.textView);
        mWebView = (WebView) findViewById(R.id.webview);
        mBackIv = (ImageView) findViewById(R.id.back);
        Intent intent = this.getIntent();
        if (intent != null) {
            result = intent.getStringExtra("result");
        }
        if (!TextUtils.isEmpty(result)) {
            mTextView.setText("扫描结果：" + result);
        }
        mWebView.loadUrl(result);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                view.loadUrl(result);
                return true;
            }
        });

        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultScanActivity.this.finish();
            }
        });
    }
}
