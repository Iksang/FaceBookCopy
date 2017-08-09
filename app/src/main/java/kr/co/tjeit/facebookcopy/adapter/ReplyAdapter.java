package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.ReplyData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by tjoeun on 2017-08-09.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {

    Context mContext;
    List<ReplyData> mList;
    LayoutInflater inf;



    public ReplyAdapter (Context context, List<ReplyData> list){
        super(context, R.layout.reply_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row==null){
            row = inf.inflate(R.layout.reply_list_item,null);
        }

        LinearLayout replyLayout = (LinearLayout)row.findViewById(R.id.replyLayout);
        LinearLayout replyOfReplyLayout = (LinearLayout)row.findViewById(R.id.replyOfReplyLayout);
        TextView nameTxt = (TextView)row.findViewById(R.id.nameTxt);
        TextView contentTxt = (TextView)row.findViewById(R.id.contentTxt);
        TextView commentNameTxt = (TextView)row.findViewById(R.id.commentNameTxt);
        TextView commentContentTxt = (TextView)row.findViewById(R.id.commentContentTxt);

        TextView replyBtnTxt = (TextView)row.findViewById(R.id.replyBtnTxt);
        TextView replyOfReplyBtnTxt =(TextView)row.findViewById(R.id.replyOfReplyBtnTxt);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDatas.replyPos = position;
            }
        };
        replyBtnTxt.setOnClickListener(clickListener);
        replyOfReplyBtnTxt.setOnClickListener(clickListener);

        ReplyData data = mList.get(position);

        if(data.getParentReplyId() == 0){
            //댓글인 상황
            replyLayout.setVisibility(View.VISIBLE);
            replyOfReplyLayout.setVisibility(View.GONE);
            nameTxt.setText(data.getWriterName());
            contentTxt.setText(data.getReplyContent());
        }
        else{
            //대댓글인 상황
            replyLayout.setVisibility(View.GONE);
            replyOfReplyLayout.setVisibility(View.VISIBLE);
            commentNameTxt.setText(data.getWriterName());
            commentContentTxt.setText(data.getReplyContent());
        }

        // Adapter처럼 부속품으로 활용되는 코드에서
        // Activity에 접근을 해야하는 상황이 발생.

        // 그럴때 처리하는 방법?
        // => ((액티비티이름) mContext). 활용
        // 액티비티에서는 반드시 public 열어줘야함.
        // getter setter 활용해서 메쏘드만 public으로 열어줘도 됨.

        return row;
    }

}
