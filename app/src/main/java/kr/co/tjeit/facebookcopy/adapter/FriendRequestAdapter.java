package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.FriendRequestData;

/**
 * Created by tjoeun on 2017-08-08.
 */

public class FriendRequestAdapter extends ArrayAdapter<FriendRequestData> {

    Context mContext;
    List<FriendRequestData> mList;
    LayoutInflater inf;


    public FriendRequestAdapter(Context context, List<FriendRequestData> list){
        super(context, R.layout.friend_request_list_item,list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.friend_request_list_item, null);
        }

        FriendRequestData data = mList.get(position);
        TextView nameText = (TextView)row.findViewById(R.id.nameText);
        TextView friendCountTxt = (TextView)row.findViewById(R.id.friendCountTxt);

        nameText.setText(data.getName());

        String coutnStr = String.format(Locale.KOREA, "%d명", data.getCommonFreindsCount());
        friendCountTxt.setText(coutnStr);

        return row;
    }


}
