package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.TextView modeTxt;
    private android.widget.EditText idEdt;
    private android.widget.Button loginBtn;
    private android.widget.Button signUpBtn;
    private android.widget.Button facebookLoginBtn;
    private EditText passwordEdt;
    Button visitBtn;
    Button mailContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        setupEvents();
    }

    void setupEvents() {
        // 버튼들이 눌릴때 하는 일들을 설정.
        // 이벤트 처리 모음

        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
        facebookLoginBtn.setOnClickListener(this);
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


    void bindViews() {
        this.facebookLoginBtn = (Button) findViewById(R.id.facebookLoginBtn);
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.modeTxt = (TextView) findViewById(R.id.modeTxt);
        visitBtn = (Button) findViewById(R.id.visitBtn);
        mailContactBtn = (Button) findViewById(R.id.mailContactBtn);;
    }

    @Override
    public void onClick(View v) {
        // 모든 버튼에 대한 클릭 이벤트를 처리 할 수 있음
        if (v.getId() == R.id.loginBtn) {
            String inputId = idEdt.getText().toString();
            String inputPw = passwordEdt.getText().toString();
            if (inputId.equals("user") && inputPw .equals("1234")){
                Intent myIntend = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(myIntend);
                finish();
            }
            else {
                Toast.makeText(this, "로그인에 실패 했습니다. \n아이디와 비번을 확인해주세요.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.signUpBtn) {
            Intent myIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(myIntent);

        } else if (v.getId() == R.id.facebookLoginBtn) {
            AlertDialog.Builder facebookAlert = new AlertDialog.Builder(LoginActivity.this);
            facebookAlert.setTitle("페이스북 로그인 알림");
            facebookAlert.setMessage("준비중인 기능입니다.");
            facebookAlert.setPositiveButton("확인", null);
            facebookAlert.show();
        }

    }
}
