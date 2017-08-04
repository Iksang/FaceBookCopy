package kr.co.tjeit.facebookcopy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.tjeit.facebookcopy.fragment.MessageFragment;
import kr.co.tjeit.facebookcopy.fragment.NewSpeedFragment;
import kr.co.tjeit.facebookcopy.fragment.NoticeFragment;
import kr.co.tjeit.facebookcopy.fragment.RequestFragment;
import kr.co.tjeit.facebookcopy.fragment.ViewMoreFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager myViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewPager = (ViewPager)findViewById(R.id.myViewPager);

        myViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));


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
