package www.function.com.functiondemo.ui.function;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;

/**
 * 百度地图
 */
public class BaiduMapActivity extends BaseActivity {

    @BindView(R.id.custom_text)
    TextView customText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_map);
        ButterKnife.bind(this);
        customText.setText("百度地图");
    }
}
