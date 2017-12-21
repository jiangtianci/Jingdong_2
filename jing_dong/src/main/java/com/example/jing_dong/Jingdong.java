package com.example.jing_dong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.jing_dong.fr.Fragment1;
import com.example.jing_dong.fr.Fragment2;
import com.example.jing_dong.fr.Fragment3;
import com.example.jing_dong.fr.Fragment4;
import com.example.jing_dong.fr.Fragment5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */

public class Jingdong extends AppCompatActivity{

    List<Fragment> list_fr = new ArrayList<>();
    private List<String> list_tab = new ArrayList<>();;
    String[] name = {"首页","分类","发现","购物车","我的"};
    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jingdong);
        //隐藏标题栏
        getSupportActionBar().hide();
        inittab();
    }

    private void inittab() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        for (String sr: name ) {
            list_tab.add(sr);
            tab.addTab(tab.newTab().setText(sr));
        }

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();
        Fragment5 fragment5 = new Fragment5();

        list_fr.add(fragment1);
        list_fr.add(fragment2);
        //list_fr.add(fragment3);
        list_fr.add(fragment4);
        list_fr.add(fragment5);
        //绑定适配器
        PagerAdapter adapter = new Pageradaper(getSupportFragmentManager(),list_fr,list_tab);
        vp.setAdapter(adapter);
        //tab关联vp
        tab.setupWithViewPager(vp);


        //添加图片
        tab.getTabAt(0).setText(list_tab.get(0)).setIcon(R.drawable.tab1);
        tab.getTabAt(1).setText(list_tab.get(1)).setIcon(R.drawable.f2);
        //tab.getTabAt(2).setText(list_tab.get(2)).setIcon(R.drawable.f3);
        tab.getTabAt(2).setText(list_tab.get(3)).setIcon(R.drawable.f4);
        tab.getTabAt(3).setText(list_tab.get(4)).setIcon(R.drawable.f5);
    }

    //适配器
    class Pageradaper extends FragmentPagerAdapter{
        List<Fragment> list_fr;
        List<String> list_tab;

        public Pageradaper(FragmentManager fm, List<Fragment> list_fr, List<String> list_tab) {
            super(fm);
            this.list_fr = list_fr;
            this.list_tab = list_tab;
        }

        @Override
        public Fragment getItem(int position) {
            return list_fr.get(position);
        }

        @Override
        public int getCount() {
            return list_fr.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list_tab.get(position);
        }
    }

}
