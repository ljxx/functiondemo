package www.function.com.functiondemo.ui.function.twocode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import www.function.com.functiondemo.R;

/**
 * 二维码
 */
public class TwoDimensionCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_dimension_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String _code = data.getStringExtra("SCAN_RESULT");
        }
    }
}
