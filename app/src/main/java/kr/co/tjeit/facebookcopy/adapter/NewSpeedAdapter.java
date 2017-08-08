package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.ReplyListActivity;
import kr.co.tjeit.facebookcopy.data.NewSpeedData;
import kr.co.tjeit.facebookcopy.util.TimeAgoUtil;

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

        NewSpeedData data = mList.get(position);

        LinearLayout previewLayout = (LinearLayout)row.findViewById(R.id.previewLayout);

        // Adapter의 getView에서 if를 통해 작업할때는
        // 반드시 else의 경우도 작업해주자.
        // 왜? Adapter를 활용하는 View는 재활용이 기본옵션.
        if(data.getLinkUtl().length()==0) {
            previewLayout.setVisibility(View.GONE);
        }
        else{
            previewLayout.setVisibility(View.VISIBLE);
        }

        TextView minuteAgoTxt =(TextView)row.findViewById(R.id.minuteAgoTxt);

        minuteAgoTxt.setText(TimeAgoUtil.getTimeAgoString(data.getMinuteAgo()));

        TextView contentTxt =(TextView)row.findViewById(R.id.contentTxt);
        contentTxt.setText(data.getContentText());

        TextView likeCountTxt = (TextView)row.findViewById(R.id.likeCountTxt);
        likeCountTxt.setText(String.format(Locale.KOREA, "%,d개",data.getLikeCount()));



        Button likeBtn = (Button)row.findViewById(R.id.likeBtn);
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "좋아요를 눌렀습니다", Toast.LENGTH_SHORT).show();
            }
        });

        Button replyBtn = (Button)row.findViewById(R.id.replyBtn);

        replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                mContext.startActivity(intent);
            }
        });

        return row;
    }


}
