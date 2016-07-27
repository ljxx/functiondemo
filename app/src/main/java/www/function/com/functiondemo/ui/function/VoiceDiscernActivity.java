package www.function.com.functiondemo.ui.function;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.iflytek.sunflower.FlowerCollector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;

/**
 * 极光推送
 */
public class VoiceDiscernActivity extends BaseActivity {

    @BindView(R.id.custom_text)
    TextView customText;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.btn_speech)
    Button btnSpeech;

    private SpeechRecognizer mIat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_discern);
        ButterKnife.bind(this);
        customText.setText("语音识别");

        //1.创建SpeechRecognizer对象，第二个参数：本地听写时传InitListener
        mIat= SpeechRecognizer.createRecognizer(this, null);
        //2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
        /*mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");*/
        mIat.setParameter(SpeechConstant.ENGINE_TYPE,"cloud");
        mIat.setParameter(SpeechConstant.SUBJECT,"asr");
    }

    @OnClick({R.id.et_content, R.id.btn_speech})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_content:
                break;
            case R.id.btn_speech:
                //1.创建RecognizerDialog对象
               /* RecognizerDialog mDialog = new RecognizerDialog(this, mInitListener);
                //2.设置accent、language等参数
                mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
                mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
                //若要将UI控件用于语义理解，必须添加以下参数设置，设置之后onResult回调返回将是语义理解//结果
                // mDialog.setParameter("asr_sch", "1");
                // mDialog.setParameter("nlp_version", "2.0");
                //3.设置回调接口
                mDialog.setListener(mRecognizerDialogListener);
                //4.显示dialog，接收语音输入
                mDialog.show();*/
                int ret = mIat.startListening(mRecoListener);
                if(ret != ErrorCode.SUCCESS){
                    System.out.println("识别失败ret");
                }
                break;
        }
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            System.out.println("===SpeechRecognizer init()=code==：" + code);
            if (code != ErrorCode.SUCCESS) {
                System.out.println("===初始化失败，错误码：==：" + code);
            }
        }
    };

    /**
     * 听写UI监听器
     */
    private RecognizerDialogListener mRecognizerDialogListener = new RecognizerDialogListener() {
        public void onResult(RecognizerResult results, boolean isLast) {
            System.out.println("===听写UI监听器==：" + results);
            etContent.setText(results.toString());
        }

        /**
         * 识别回调错误.
         */
        public void onError(SpeechError error) {
            System.out.println("===听写UI监听器Error==：" + error.toString());
        }
    };

    //听写监听器
    private RecognizerListener mRecoListener = new RecognizerListener(){

        //音量值0~30
        @Override
        public void onVolumeChanged(int i, byte[] bytes) {

        }

        //开始录音
        @Override
        public void onBeginOfSpeech() {
            System.out.println("===onBeginOfSpeech=开始语音==");
        }

        //结束录音
        @Override
        public void onEndOfSpeech() {
            System.out.println("===onEndOfSpeech=语音结束==");
        }

        //听写结果回调接口(返回Json格式结果，用户可参见附录12.1)；
        //一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；
        //关于解析Json的代码可参见MscDemo中JsonParser类；
        //isLast等于true时会话结束。
        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            System.out.println("===recognizerResult===:" + recognizerResult);
            etContent.setText(recognizerResult.toString());
        }

        //会话发生错误回调接口
        @Override
        public void onError(SpeechError speechError) {
            System.out.println("===onError=语音识别有误==");
        }

        //扩展用接口
        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
