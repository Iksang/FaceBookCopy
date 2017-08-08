package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.NotificationData;
import kr.co.tjeit.facebookcopy.util.TimeAgoUtil;

/**
 * Created by tjoeun on 2017-08-08.
 */

public class NotificationAdapater extends ArrayAdapter<NotificationData>{

    private Context mContext;
    private List<NotificationData> mList;
    LayoutInflater inf;

    public NotificationAdapater(Context context, List<NotificationData> list){
        super(context, R.layout.notification_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.notification_list_item,null);
        }

        // 1. 뿌려줄 데이터를 가져오기
        // 어떤 데이터? 알림 데이터. 변수로 저장.

        NotificationData data = mList.get(position);

        // 2. 데이터가 들어갈 뷰들을 바인딩

        TextView notificationTxt = (TextView)row.findViewById(R.id.notificationTxt);
        TextView minuteAgoTxt = (TextView)row.findViewById(R.id.minuteAgoTxt);

        // 3. 데이터 세팅 (setText)

        notificationTxt.setText(data.getNotificationText());


        // 2분 이내 : 방금 전, 2~59 : ??분 전, 60~119분 : 1시간 전
        // 2분 이내 : 방금 전
        // 2~40 : ??분 전
        // 41~90분 : 한시간 전
        // 91~510분 : ??시간 전 Ex. 91~150 2시간 전, 151 ~ 210 3시간 전. => 알고리즘
        // 그 외 : 오래 전
        minuteAgoTxt.setText(TimeAgoUtil.getTimeAgoString(data.getMinuteAgo()));

        return row;
    }

}
