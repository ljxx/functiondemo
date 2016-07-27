package www.function.com.functiondemo.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import www.function.com.functiondemo.R;

/**
 * ============================================================
 * 
 * 版 权 ： 上海赵涌信息技术有限公司 版权所有 (c) 2015
 * 
 * 作 者 : 杨理想
 * 
 * 版 本 ： 3.0.1
 * 
 * 创建日期 ：2016/7/27 16:27
 * 
 * 描 述 ：
 * 
 * 修订历史 ：
 * 
 * ============================================================
 **/
public class SwitchView extends View implements View.OnTouchListener {
    
    private Bitmap mOn, mOff, mSlipper; //开，关，拖动

    /**
     * downX 按下时的X
     * nowX 当前的X
     */
    private float downX , nowX;

    /**
     * 记录用户是否在滑动
     */
    private boolean onSlip = false;

    /**
     * 当前的状态
     */
    private boolean nowStatus = false;
    
    public SwitchView(Context context) {
        super(context);
        init();
    }

    public SwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //载入图片资源
        mOn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_on);
        mOff = BitmapFactory.decodeResource(getResources(),R.drawable.btn_off);
        mSlipper = BitmapFactory.decodeResource(getResources(),R.drawable.btn_slipper);
        
        setOnTouchListener(this);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = new Matrix(); //形状
        Paint paint = new Paint(); //画笔
        float x = 0;
        
        //根据nowX的值来设置背景图，开或关
        if(nowX < (mOn.getWidth()/2)){
            canvas.drawBitmap(mOff, matrix, paint); //画出关闭时的背景           
        } else {
            canvas.drawBitmap(mOn, matrix, paint); //画出打开时的背景
        }
        
        if(onSlip){ //是否在滑动状态
            if(nowX >= mOn.getWidth()){ //是否划出指定范围,不能让滑块跑到外头,必须做这个判断  
                x = mOn.getWidth() - mSlipper.getWidth()/2; //减去滑块的1/2长
            } else {
                x = nowX - mSlipper.getWidth()/2;
            }
        } else {
            if(nowStatus){ //根据当前的状态设置滑块的x值  
                x = mOn.getWidth() - mSlipper.getWidth();
            } else {
                x = 0;
            }
        }
        
        //对滑块进行异常处理，不能让其出界；
        if(x < 0){
            x = 0;
        } else if(x > mOn.getWidth() - mSlipper.getWidth()){
            x = mOn.getWidth() - mSlipper.getWidth();
        }
        canvas.drawBitmap(mSlipper, x, 0, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(event.getX() > mOff.getWidth() || event.getY() > mOff.getHeight()){
                    return false;
                } else {
                    onSlip = true;
                    downX = event.getX();
                    nowX = downX;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                nowX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                onSlip = false;
                if(event.getX() >= (mOn.getWidth()/2)){
                    nowStatus = true;
                    nowX = mOn.getWidth(); //mOn.getWidth() - mSlipper.getWidth()
                } else {
                    nowStatus = false;
                    nowX = 0;
                }
                break;
        }
        //刷新界面
        invalidate();
        return true;
    }
}
