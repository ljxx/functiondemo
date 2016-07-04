package www.function.com.functiondemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;
import www.function.com.functiondemo.ui.function.BaiduMapActivity;
import www.function.com.functiondemo.ui.function.BigImageActivity;
import www.function.com.functiondemo.ui.function.CommunicationActivity;
import www.function.com.functiondemo.ui.function.MusicVideoActivity;
import www.function.com.functiondemo.ui.function.PhotographVideoActivity;
import www.function.com.functiondemo.ui.function.PushActivity;
import www.function.com.functiondemo.ui.function.ShareActivity;
import www.function.com.functiondemo.ui.function.slidingtab.SlidingTabActivity;
import www.function.com.functiondemo.ui.function.twocode.QRcodeActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private MainActivity act;

    private Button two_dimension_code; //二维码
    private Button photograph; //拍照
    private Button video; //摄影
    private Button push_message; //极光推送
    private View play_music; //音乐播放
    private Button play_video; //视频播放
    private Button communication; //即使通讯
    private Button baidu_map; //百度地图
    private Button share; //平台分享
    private Button mBigImageLoading; // 大图加载
    private Button btn_SlidingTab; //SlidingTab导航栏

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act = this;
        initView();
    }

    private void initView() {
        two_dimension_code = (Button) findViewById(R.id.two_dimension_code);
        photograph = (Button) findViewById(R.id.photograph);
        video = (Button) findViewById(R.id.video);
        push_message = (Button) findViewById(R.id.push_message);
        play_music = findViewById(R.id.play_music);
        play_video = (Button) findViewById(R.id.play_video);
        communication = (Button) findViewById(R.id.communication);
        baidu_map = (Button) findViewById(R.id.baidu_map);
        share = (Button) findViewById(R.id.share);
        mBigImageLoading = (Button) findViewById(R.id.mBigImageLoading);
        btn_SlidingTab = (Button) findViewById(R.id.btn_SlidingTab);

        two_dimension_code.setOnClickListener(this);
        photograph.setOnClickListener(this);
        play_music.setOnClickListener(this);
        video.setOnClickListener(this);
        push_message.setOnClickListener(this);
        play_video.setOnClickListener(this);
        communication.setOnClickListener(this);
        baidu_map.setOnClickListener(this);
        share.setOnClickListener(this);
        mBigImageLoading.setOnClickListener(this);
        btn_SlidingTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.two_dimension_code: //二维码
                jumpActivity(act, QRcodeActivity.class);
                break;
            case R.id.photograph: //拍照
                jumpActivity(act, PhotographVideoActivity.class);
                break;
            case R.id.video:
                jumpActivity(act,PhotographVideoActivity.class);
                break;
            case R.id.push_message: //极光推送
                jumpActivity(act, PushActivity.class);
                break;
            case R.id.play_music:
                jumpActivity(act,MusicVideoActivity.class);
                break;
            case R.id.play_video: //视频播放
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
            case R.id.mBigImageLoading: //大图加载
                jumpActivity(act, BigImageActivity.class);
                break;
            case R.id.btn_SlidingTab: //SlidingTab导航栏
                jumpActivity(act, SlidingTabActivity.class);
                break;
        }
    }
}
