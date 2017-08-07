package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentPracticeActivity extends AppCompatActivity {

    Button dialBtn;
    Button callBtn;
    Button internetBtn;
    Button mapBtn;
    Button emailBtn;
    Button visitBtn;
    Button mailContactBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_practice);
        bindViews();
        setupEvent();

    }

    void setupEvent(){
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "dialBtn이 눌렀을때" 일어날 일들을 작성.

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:010-8664-1762"));
                startActivity(intent);
            }
        });
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:010-8664-1762"));
                startActivity(intent);
            }
        });

        internetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:37.584526, 126.986116"));
                startActivity(intent);
            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:cho881020@gmail.com"));
                startActivity(intent);
            }
        });

        visitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
            }
        });

        mailContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:contact@tje.co.kr"));
                startActivity(intent);

            }
        });

    }

    void bindViews(){
        dialBtn = (Button) findViewById(R.id.dialBtn);
        callBtn = (Button) findViewById(R.id.callBtn);
        internetBtn =(Button) findViewById(R.id.internetBtn );
        mapBtn = (Button) findViewById(R.id.mapBtn);
        emailBtn = (Button) findViewById(R.id.emailBtn);
        visitBtn = (Button) findViewById(R.id.visitBtn);
        mailContactBtn = (Button) findViewById(R.id.mailContactBtn);;

    }
}
