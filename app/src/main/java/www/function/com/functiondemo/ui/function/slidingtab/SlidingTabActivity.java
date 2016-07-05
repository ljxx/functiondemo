package www.function.com.functiondemo.ui.function.slidingtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

public class SlidingTabActivity extends AppCompatActivity {

    @BindView(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tab);
        ButterKnife.bind(this);

        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        fragments.add(new FiveFragment());
        fragments.add(new SixFragment());

        if(viewPager == null){
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

    private class MyFragmentAdapter extends FragmentPagerAdapter{

        private String[] pagerTitles = {"HOME页","第二页","第三页","第四页","第五页","第六页"};

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
}
