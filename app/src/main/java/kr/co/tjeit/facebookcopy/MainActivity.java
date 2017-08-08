package kr.co.tjeit.facebookcopy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import kr.co.tjeit.facebookcopy.fragment.MessageFragment;
import kr.co.tjeit.facebookcopy.fragment.NewSpeedFragment;
import kr.co.tjeit.facebookcopy.fragment.NoticeFragment;
import kr.co.tjeit.facebookcopy.fragment.RequestFragment;
import kr.co.tjeit.facebookcopy.fragment.ViewMoreFragment;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class MainActivity extends AppCompatActivity {

    private ViewPager myViewPager;
    private android.widget.LinearLayout newsFeedBtnLayout;
    private android.widget.LinearLayout friendRequestBtnLayout;
    private android.widget.LinearLayout messageBtnLayout;
    private android.widget.LinearLayout notificationBtnLayout;
    private android.widget.LinearLayout seeMoreBtnLayout;
    private android.widget.TextView titleTxt;
    private LinearLayout newsFeedBtnsLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();


    }

    private void setValues() {
        GlobalDatas.initDatas();
        myViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }

    private void setupEvents() {
        newsFeedBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewPager.setCurrentItem(0);
            }
        });
        friendRequestBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewPager.setCurrentItem(1);
            }
        });
        messageBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewPager.setCurrentItem(2);
            }
        });
        ;
        notificationBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewPager.setCurrentItem(3);
            }
        });
        ;
        seeMoreBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewPager.setCurrentItem(4);
            }
        });
        ;

        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 한장의 페이지로 자리를 잡았을 때.

                // 페이지에 맞는 제목 설정
                switch (position) {
                    case 0:
                        titleTxt.setText("뉴스피드");
                        break;
                    case 1:
                        titleTxt.setText("요청");
                        break;
                    case 2:
                        titleTxt.setText("메시지");
                        break;
                    case 3:
                        titleTxt.setText("알림");
                        break;
                    case 4:
                        titleTxt.setText("더보기");
                        break;
                    default:
                        break;
                }

                // 뉴스피드 일때만 버튼들을 보여주고, 그외엔 숨김.
                if(position == 0){
                    newsFeedBtnsLayout.setVisibility(View.VISIBLE);
                }
                else{
                    newsFeedBtnsLayout.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void bindViews() {
        this.seeMoreBtnLayout = (LinearLayout) findViewById(R.id.seeMoreBtnLayout);
        this.notificationBtnLayout = (LinearLayout) findViewById(R.id.notificationBtnLayout);
        this.messageBtnLayout = (LinearLayout) findViewById(R.id.messageBtnLayout);
        this.friendRequestBtnLayout = (LinearLayout) findViewById(R.id.friendRequestBtnLayout);
        this.newsFeedBtnLayout = (LinearLayout) findViewById(R.id.newsFeedBtnLayout);
        this.myViewPager = (ViewPager) findViewById(R.id.myViewPager);
        this.newsFeedBtnsLayout = (LinearLayout) findViewById(R.id.newsFeedBtnsLayout);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
    }


    class MyViewPagerAdapter extends FragmentStatePagerAdapter{

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new NewSpeedFragment();

                case 1:
                    return new RequestFragment();

                case 2:
                    return new MessageFragment();

                case 3:
                    return new NoticeFragment();

                case 4:
                    return new ViewMoreFragment();

                default:
                    return null;
            }
        }
    }
}
