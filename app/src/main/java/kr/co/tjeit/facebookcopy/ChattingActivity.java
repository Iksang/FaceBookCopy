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

import kr.co.tjeit.facebookcopy.adapter.ChattingAdapter;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class ChattingActivity extends AppCompatActivity {

    List<MessageData> messageDatas = new ArrayList<>();
    private android.widget.ListView chattingListView;
    ChattingAdapter chattingAdapter;
    private android.widget.EditText messageAddEdt;
    private android.widget.Button sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);


        bindView();
        setupEvents();
        setValues();
        addMessageDatas();
    }

    private void addMessageDatas() {

        messageDatas.clear();

        messageDatas.add(new MessageData(10, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅇㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㅋㅋㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "머함?", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "롤?", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㄴㄴ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅋㅇㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅂㄷㅂㄷ", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㅇㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇ", Calendar.getInstance()));

        chattingAdapter.notifyDataSetChanged();

    }

    private void setValues() {
        chattingAdapter = new ChattingAdapter(ChattingActivity.this, messageDatas);
        chattingListView.setAdapter(chattingAdapter);
//        chattingListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
//        chattingListView.setStackFromBottom(true);
    }

    private void setupEvents() {
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageAddEdt.getText().toString();
                messageDatas.add(new MessageData(GlobalDatas.loginUserId, message, Calendar.getInstance()));
                chattingAdapter.notifyDataSetChanged();

                messageAddEdt.setText("");

                View view = getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                //리스트뷰 맨 밑으로 끌어내리기
                chattingListView.setSelection(chattingAdapter.getCount() - 1);


            }
        });

    }

    private void bindView() {
        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.messageAddEdt = (EditText) findViewById(R.id.messageAddEdt);
        this.chattingListView = (ListView) findViewById(R.id.chattingListView);
    }
}
