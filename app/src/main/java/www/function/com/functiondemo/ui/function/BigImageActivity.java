package www.function.com.functiondemo.ui.function;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;
import www.function.com.functiondemo.photodraweeview.PhotoDraweeView;
import www.function.com.functiondemo.utils.MultiTouchViewPager;

public class BigImageActivity extends BaseActivity {

    @BindView(R.id.custom_text)
    TextView customText;
    @BindView(R.id.mViewPager)
    MultiTouchViewPager mViewPager;
    private String[] mUrl = {"http://img5.cdn.zhao-cloud.com/2016/05/11/1450289680_HN3591.JPG",
            "http://img5.cdn.zhao-cloud.com/2016/03/11/1434262368_评32建党A.jpg",
            "http://img5.cdn.zhao-cloud.com/2016/05/06/1402169969_HN4743_1.jpg",
            "http://img5.cdn.zhao-cloud.com/2016/05/11/1510077902_SS1356.JPG",
            "http://img5.cdn.zhao-cloud.com/2016/05/11/1543567028_HN4142.JPG",
            "http://img5.cdn.zhao-cloud.com/2016/05/11/1510077902_SS1356.JPG",
            "http://img5.cdn.zhao-cloud.com/2016/05/13/1334550160_SS1423.JPG",
            "http://img5.cdn.zhao-cloud.com/2016/05/30/1437083920_HN5187.JPG",
            "http://img3.cdn.zhao-cloud.com/2016/23/216332002A.jpg",
            "http://img3.cdn.zhao-cloud.com/2016/23/216332003A.jpg",
            "http://img3.cdn.zhao-cloud.com/2016/23/216332006A.jpg",
            "http://img3.cdn.zhao-cloud.com/2016/23/216332006B.jpg",
            "http://img3.cdn.zhao-cloud.com/2016/23/216332006C.jpg",
            "http://img3.cdn.zhao-cloud.com/2016/23/216332005B.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(BigImageActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);
        ButterKnife.bind(this);
        customText.setText("大图加载（Fresco）");
        mViewPager.setAdapter(new ZoomableDraweeViewAdapter());
    }

    private class ZoomableDraweeViewAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mUrl.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (View) object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.i("=========", "====destroyItem====:" + position);
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final PhotoDraweeView photoDraweeView = new PhotoDraweeView(container.getContext());
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
            Log.i("==原始==:", "=position=" + mUrl[position]);
            Log.i("==转码==:", "=position=" + Uri.encode(mUrl[position], "utf-8").replaceAll("%3A", ":").replaceAll("%2F", "/"));
            controller.setUri(Uri.parse(Uri.encode(mUrl[position], "utf-8").replaceAll("%3A", ":").replaceAll("%2F", "/")));
            controller.setOldController(photoDraweeView.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if (imageInfo == null) {
                        return;
                    }
                    photoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                }
            });
            photoDraweeView.setController(controller.build());

            try {
                container.addView(photoDraweeView, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return photoDraweeView;
        }
    }
}
