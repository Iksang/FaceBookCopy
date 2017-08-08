package kr.co.tjeit.facebookcopy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import kr.co.tjeit.facebookcopy.MessageActivity;
import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.MessageAdapter;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by tjoeun on 2017-08-04.
 */

public class MessageFragment extends Fragment {

    ListView messageListView;
    MessageAdapter messageAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message,container, false);

        messageListView = (ListView)v.findViewById(R.id.messageListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setEvents();
        setValues();




    }

    private void setValues() {
        messageAdapter = new MessageAdapter(getActivity(), GlobalDatas.messageDatas);
        messageListView.setAdapter(messageAdapter);

    }

    private void setEvents() {
        messageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
            }
        });
    }

}
