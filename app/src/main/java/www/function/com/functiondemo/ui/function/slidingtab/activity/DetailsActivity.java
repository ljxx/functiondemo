package www.function.com.functiondemo.ui.function.slidingtab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.function.com.functiondemo.R;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;

    private String mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        mData = getIntent().getStringExtra("rawArgs");
        tvContent.setText("该藏品的详细信息是：" + mData);
    }

    @OnClick(R.id.tv_content)
    public void onClick() {
        Intent mIntent = new Intent();
        mIntent.putExtra("rawArgs",mData);
        setResult(RESULT_OK,mIntent);
        finish();
    }
}
