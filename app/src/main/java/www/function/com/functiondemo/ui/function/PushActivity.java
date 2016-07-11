package www.function.com.functiondemo.ui.function;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;

/**
 * 极光推送
 */
public class PushActivity extends BaseActivity {

    @BindView(R.id.custom_text)
    TextView customText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        ButterKnife.bind(this);
        customText.setText("极光推送");
    }
}
