package kr.co.tjeit.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.NewSpeedAdapter;
import kr.co.tjeit.facebookcopy.data.NewSpeedData;

/**
 * Created by tjoeun on 2017-08-04.
 */

public class NewSpeedFragment extends Fragment {
    private ListView newSpeedListView;
    List<NewSpeedData> newSpeedList = new ArrayList<>();
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
        newSpeedList.add(new NewSpeedData());
        newSpeedList.add(new NewSpeedData());
        newSpeedList.add(new NewSpeedData());
        newSpeedList.add(new NewSpeedData());
        newSpeedList.add(new NewSpeedData());
        newSpeedAdapter = new NewSpeedAdapter(getActivity(), newSpeedList);
        newSpeedListView.setAdapter(newSpeedAdapter);
    }
}
