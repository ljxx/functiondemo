package www.function.com.functiondemo.ui.function;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;

/**
 * 拍照/录像
 */
public class PhotographVideoActivity extends BaseActivity {

    @BindView(R.id.custom_text)
    TextView customText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photograph_video);
        ButterKnife.bind(this);
        customText.setText("拍照");
    }
}
