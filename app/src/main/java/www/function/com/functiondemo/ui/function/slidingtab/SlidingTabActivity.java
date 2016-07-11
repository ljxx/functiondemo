package www.function.com.functiondemo.ui.function.slidingtab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.ui.function.slidingtab.fragment.FiveFragment;
import www.function.com.functiondemo.ui.function.slidingtab.fragment.FourFragment;
import www.function.com.functiondemo.ui.function.slidingtab.fragment.HomeFragment;
import www.function.com.functiondemo.ui.function.slidingtab.fragment.SecondFragment;
import www.function.com.functiondemo.ui.function.slidingtab.fragment.SixFragment;
import www.function.com.functiondemo.ui.function.slidingtab.fragment.ThreeFragment;

public class SlidingTabActivity extends FragmentActivity {

    @BindView(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.custom_text)
    TextView customText;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tab);
        ButterKnife.bind(this);
        customText.setText("滑动导航/Hybrid开发（Cordova）");

        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        fragments.add(new FiveFragment());
        fragments.add(new SixFragment());

        if (viewPager == null) {
            System.out.println("===viewPager为Null====");
        }
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        viewpagertab.setViewPager(viewPager);
    }

    @OnClick({R.id.viewpagertab, R.id.viewPager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.viewpagertab:
                break;
            case R.id.viewPager:
                break;
        }
    }

    private class MyFragmentAdapter extends FragmentPagerAdapter {

        private String[] pagerTitles = {"HOME页", "第二页", "第三页", "第四页", "第五页", "第六页"};

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pagerTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("===SlidingTabActivity===onActivityResult===执行啦=======");
    }
}
