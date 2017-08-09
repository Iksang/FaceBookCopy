package kr.co.tjeit.facebookcopy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditStatusActivity extends AppCompatActivity {

    private android.widget.TextView titleTxt;
    private android.widget.LinearLayout photoVideoLayout;
    private android.widget.LinearLayout liveBroadcastingLayout;
    private android.widget.LinearLayout checkInLayout;
    private android.widget.LinearLayout moodActivityStickerLayout;
    private android.widget.EditText postContentEdt;
    private android.widget.Button cancelBtn;
    private android.widget.Button postingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_status);


        bindViews();
        setupEvents();
        setValues();

    }

    private void setValues() {
    }

    private void setupEvents() {

        postContentEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    postingBtn.setTextColor(Color.parseColor("#3333FF"));
                }
                else{
                    postingBtn.setTextColor(Color.parseColor("#A0A0A0"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        postingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(postingBtn.getCurrentTextColor()==Color.parseColor("#3333FF")){
                    Toast.makeText(EditStatusActivity.this, "게시글이 등록됩니다", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(EditStatusActivity.this, "게시글을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        View.OnClickListener preparingLinstener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditStatusActivity.this, "준비중인 기능입니다", Toast.LENGTH_SHORT).show();
            }
        };



        moodActivityStickerLayout.setOnClickListener(preparingLinstener);
        photoVideoLayout.setOnClickListener(preparingLinstener);
        liveBroadcastingLayout.setOnClickListener(preparingLinstener);
        checkInLayout.setOnClickListener(preparingLinstener);
    }

    private void bindViews() {
        this.moodActivityStickerLayout = (LinearLayout) findViewById(R.id.moodActivityStickerLayout);
        this.checkInLayout = (LinearLayout) findViewById(R.id.checkInLayout);
        this.liveBroadcastingLayout = (LinearLayout) findViewById(R.id.liveBroadcastingLayout);
        this.photoVideoLayout = (LinearLayout) findViewById(R.id.photoVideoLayout);
        this.postContentEdt = (EditText) findViewById(R.id.postContentEdt);
        this.postingBtn = (Button) findViewById(R.id.postingBtn);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
        this.cancelBtn = (Button) findViewById(R.id.cancelBtn);
    }
}
