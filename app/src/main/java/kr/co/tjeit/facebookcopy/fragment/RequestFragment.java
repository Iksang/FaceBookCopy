package kr.co.tjeit.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.FriendRequestAdapter;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by tjoeun on 2017-08-04.
 */

public class RequestFragment extends Fragment {

    ListView friendRequestListView;
    FriendRequestAdapter friendRequestAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_request, container, false);
        // XML, JAVA 매핑 => bindViews 역할.
        friendRequestListView = (ListView) v.findViewById(R.id.friendRequestListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // fragment에서 onCreate 대신 사용하는 메쏘드드

        setupEvents();
        setValues();
    }



    private void setupEvents() {
        // 객체들이 터치된 이벤트를 처리
        friendRequestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("터치이벤트", position+"번 줄에서 발생!");
            }
        });
    }


    private void setValues() {
        // 화면에 표시될 데이터 가공 / set
        friendRequestAdapter = new FriendRequestAdapter(getActivity(), GlobalDatas.friendRequestDatas);
        friendRequestListView.setAdapter(friendRequestAdapter);
    }


}