package www.function.com.functiondemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;
import www.function.com.functiondemo.ui.function.BaiduMapActivity;
import www.function.com.functiondemo.ui.function.CommunicationActivity;
import www.function.com.functiondemo.ui.function.MusicVideoActivity;
import www.function.com.functiondemo.ui.function.PhotographVideoActivity;
import www.function.com.functiondemo.ui.function.PushActivity;
import www.function.com.functiondemo.ui.function.ShareActivity;
import www.function.com.functiondemo.ui.function.TwoDimensionCodeActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private MainActivity act;

    private Button two_dimension_code; //二维码
    private Button photograph_video; //拍照/摄影
    private Button push_message; //极光推送
    private Button music_video; //音/视频
    private Button communication; //即使通讯
    private Button baidu_map; //百度地图
    private Button share; //平台分享

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act = this;
        initView();
    }

    private void initView() {
        two_dimension_code = (Button) findViewById(R.id.two_dimension_code);
        photograph_video = (Button) findViewById(R.id.photograph_video);
        push_message = (Button) findViewById(R.id.push_message);
        music_video = (Button) findViewById(R.id.music_video);
        communication = (Button) findViewById(R.id.communication);
        baidu_map = (Button) findViewById(R.id.baidu_map);
        share = (Button) findViewById(R.id.share);

        two_dimension_code.setOnClickListener(this);
        photograph_video.setOnClickListener(this);
        push_message.setOnClickListener(this);
        music_video.setOnClickListener(this);
        communication.setOnClickListener(this);
        baidu_map.setOnClickListener(this);
        share.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.two_dimension_code: //二维码
                jumpActivity(act, TwoDimensionCodeActivity.class);
                break;
            case R.id.photograph_video: //拍照/摄影
                jumpActivity(act, PhotographVideoActivity.class);
                break;
            case R.id.push_message: //极光推送
                jumpActivity(act, PushActivity.class);
                break;
            case R.id.music_video: //音/视频
                jumpActivity(act, MusicVideoActivity.class);
                break;
            case R.id.communication: //即使通讯
                jumpActivity(act, CommunicationActivity.class);
                break;
            case R.id.baidu_map: //百度地图
                jumpActivity(act, BaiduMapActivity.class);
                break;
            case R.id.share://平台分享
                jumpActivity(act, ShareActivity.class);
                break;
        }
    }
}