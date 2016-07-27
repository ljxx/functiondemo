package www.function.com.functiondemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;
import www.function.com.functiondemo.ui.function.BaiduMapActivity;
import www.function.com.functiondemo.ui.function.BigImageActivity;
import www.function.com.functiondemo.ui.function.CommunicationActivity;
import www.function.com.functiondemo.ui.function.CustomViewActivity;
import www.function.com.functiondemo.ui.function.MainCordovaActivity;
import www.function.com.functiondemo.ui.function.MusicVideoActivity;
import www.function.com.functiondemo.ui.function.PhotographVideoActivity;
import www.function.com.functiondemo.ui.function.ShareActivity;
import www.function.com.functiondemo.ui.function.VoiceDiscernActivity;
import www.function.com.functiondemo.ui.function.slidingtab.SlidingTabActivity;
import www.function.com.functiondemo.ui.function.twocode.QRcodeActivity;
import www.function.com.functiondemo.ui.function.twocode.TwoDimensionCodeActivity;

public class MainActivity extends BaseActivity {

    private MainActivity act;

    @BindView(R.id.two_dimension_code)
    Button twoDimensionCode;
    @BindView(R.id.photograph)
    Button photograph;
    @BindView(R.id.video)
    Button video;
    @BindView(R.id.push_message)
    Button pushMessage;
    @BindView(R.id.play_music)
    Button playMusic;
    @BindView(R.id.play_video)
    Button playVideo;
    @BindView(R.id.communication)
    Button communication;
    @BindView(R.id.baidu_map)
    Button baiduMap;
    @BindView(R.id.share)
    Button share;
    @BindView(R.id.mBigImageLoading)
    Button mBigImageLoading;
    @BindView(R.id.btn_SlidingTab)
    Button btnSlidingTab;
    @BindView(R.id.btn_CordovaActivity)
    Button btnCordovaActivity;
    @BindView(R.id.btn_customView)
    Button btnCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = this;
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.two_dimension_code, R.id.photograph, R.id.video, R.id.push_message,
            R.id.play_music, R.id.play_video, R.id.communication, R.id.baidu_map,
            R.id.share, R.id.mBigImageLoading, R.id.btn_SlidingTab,
            R.id.btn_CordovaActivity, R.id.btn_customView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.two_dimension_code:
                jumpActivity(act, QRcodeActivity.class);
                break;
            case R.id.photograph:
                jumpActivity(act, PhotographVideoActivity.class);
                break;
            case R.id.video:
                jumpActivity(act, PhotographVideoActivity.class);
                break;
            case R.id.push_message:
                jumpActivity(act, VoiceDiscernActivity.class);
                break;
            case R.id.play_music:
                jumpActivity(act, MusicVideoActivity.class);
                break;
            case R.id.play_video:
                jumpActivity(act, MusicVideoActivity.class);
                break;
            case R.id.communication:
                jumpActivity(act, CommunicationActivity.class);
                break;
            case R.id.baidu_map:
                jumpActivity(act, BaiduMapActivity.class);
                break;
            case R.id.share:
                jumpActivity(act, ShareActivity.class);
                break;
            case R.id.mBigImageLoading:
                jumpActivity(act, BigImageActivity.class);
                break;
            case R.id.btn_SlidingTab:
                jumpActivity(act, SlidingTabActivity.class);
                break;
            case R.id.btn_CordovaActivity:
                jumpActivity(act, MainCordovaActivity.class);
                break;
            case R.id.btn_customView:
                jumpActivity(act, CustomViewActivity.class);
                break;
        }
    }
}
