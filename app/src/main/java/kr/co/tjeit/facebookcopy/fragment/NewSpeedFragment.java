package kr.co.tjeit.facebookcopy.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.NewSpeedAdapter;
import kr.co.tjeit.facebookcopy.data.NewSpeedData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by tjoeun on 2017-08-04.
 */

public class NewSpeedFragment extends Fragment {
    private ListView newSpeedListView;
    NewSpeedAdapter newSpeedAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newspeed,container,false);
        newSpeedListView = (ListView)v.findViewById(R.id.newSpeedListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newSpeedAdapter = new NewSpeedAdapter(getActivity(), GlobalDatas.newSpeedDatas);
        newSpeedListView.setAdapter(newSpeedAdapter);
        setupEvents();
        setValues();

    }

    private void setValues() {

    }

    private void setupEvents() {

        newSpeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
            }
        });
    }
}
