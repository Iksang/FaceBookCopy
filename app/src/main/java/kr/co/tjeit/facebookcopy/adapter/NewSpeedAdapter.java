package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.NewSpeedData;

/**
 * Created by tjoeun on 2017-08-04.
 */

public class NewSpeedAdapter extends ArrayAdapter<NewSpeedData> {

    private Context mContext;
    private List<NewSpeedData> mList;
    LayoutInflater inf;

    public NewSpeedAdapter(Context context, List<NewSpeedData> list){
        super(context, R.layout.newspeed_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null)
        {
            row = inf.inflate(R.layout.newspeed_list_item, null);
        }

        return row;
    }
}
