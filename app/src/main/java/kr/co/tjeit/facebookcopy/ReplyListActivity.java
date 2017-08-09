package kr.co.tjeit.facebookcopy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.adapter.ReplyAdapter;
import kr.co.tjeit.facebookcopy.data.ReplyData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class ReplyListActivity extends AppCompatActivity {


    private android.widget.ListView replyListView;
    private ReplyAdapter replyAdapter;
    List<ReplyData> replyDatas = new ArrayList<>();
    private android.widget.EditText contentEdt;
    private android.widget.Button sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);

        bindViews();
        setupEvents();
        setValues();
        addDatas();
    }

    private void addDatas() {
        replyDatas.clear();
        replyDatas.add(new ReplyData(1, 0, "김태희", "김태희입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(2, 1, "아이유", "아이유입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(3, 1, "수지", "수지입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(5, 1, "조경진", "조경진입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(4, 0, "비", "비입니다", Calendar.getInstance()));
        replyAdapter.notifyDataSetChanged();
    }

    private void setValues() {

        replyAdapter = new ReplyAdapter(ReplyListActivity.this, replyDatas);
        replyListView.setAdapter(replyAdapter);

    }

    private void setupEvents() {

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = contentEdt.getText().toString();


                int dataPos = 0;
                if(GlobalDatas.replyPos != 0){
                    dataPos = GlobalDatas.replyPos;
                    replyDatas.add(dataPos+1,new ReplyData((replyDatas.size()+1),GlobalDatas.replyPos,GlobalDatas.loginUserName,
                            content,Calendar.getInstance()));
                    GlobalDatas.replyPos = 0;
                }
                else{
                    replyDatas.add(new ReplyData((replyDatas.size()+1),0,GlobalDatas.loginUserName,content,Calendar.getInstance()));
                }

                //리스트뷰 맨 밑으로 끌어내리기

                replyListView.setSelection(replyAdapter.getCount() - 1);


                replyAdapter.notifyDataSetChanged();
                contentEdt.setText("");


            }
        });

    }

    private void bindViews() {

        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.replyListView = (ListView) findViewById(R.id.replyListView);
    }
}
