package kr.co.tjeit.facebookcopy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    private Button doublechkBtn;
    private EditText idEdt;
    private Button signUpBtn;
    private EditText pwEdt;
    private EditText confirmPwEdt;

    private TextView pwGuideTxt;
    private ImageView iconImg;
    
    private TextView birthDayTxt;


    boolean isIdOk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();
        setupEvents();
    }

    void setupEvents(){
        doublechkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = idEdt.getText().toString();
                if(inputId .equals("user")){
                    Toast.makeText(SignUpActivity.this, "이미 사용중인 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(inputId.length() == 0){
                    Toast.makeText(SignUpActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(inputId.length() < 8){
                    Toast.makeText(SignUpActivity.this, "ID의 길이가 너무 짧습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUpActivity.this, "사용해도 좋습니다.", Toast.LENGTH_SHORT).show();
                    isIdOk = true;
                }
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = idEdt.getText().toString();
                String inputPw = pwEdt.getText().toString();
                String inputConfirmPw = confirmPwEdt.getText().toString();
                if(inputPw.length() >=8 && inputPw.equals(inputConfirmPw) && isIdOk){
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(SignUpActivity.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String changedStr = s.toString();
                Log.d("changedStr",changedStr);

                isIdOk = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confirmPwEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final Calendar tempCal = Calendar.getInstance();

        birthDayTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        birthDayTxt.setText(""+year+month+dayOfMonth);
                    }
                },
                tempCal.get(Calendar.YEAR),
                tempCal.get(Calendar.MONTH),
                tempCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    void checkPwAndChangeMessage(){
        String pw =pwEdt.getText().toString();
        String pwcheck =confirmPwEdt.getText().toString();
        if(pw.length()==0)
        {
            pwGuideTxt.setText("비밀번호를 입력해 주세요.");
            pwGuideTxt.setTextColor(Color.parseColor("#FF0000"));
            iconImg.setImageResource(R.drawable.red_alert_icon);
        }
        else if (pw.length()<8){
            pwGuideTxt.setText("비밀번호의 길이가 너무 짧습니다.");
            pwGuideTxt.setTextColor(Color.parseColor("#FF0000"));
            iconImg.setImageResource(R.drawable.red_alert_icon);
        }
        else if (!pw.equals(pwcheck)){
            pwGuideTxt.setText("두개의 비밀번호가 서로 다릅니다..");
            pwGuideTxt.setTextColor(Color.parseColor("#FF0000"));
            iconImg.setImageResource(R.drawable.red_alert_icon);
        }
        else {
            pwGuideTxt.setText("회원가입이 가능합니다.");
            iconImg.setImageResource(R.drawable.ok_icon);
            pwGuideTxt.setTextColor(Color.parseColor("#0000FF"));
        }

    }

    void bindViews() {
        idEdt = (EditText) findViewById(R.id.idEdt);
        doublechkBtn = (Button)findViewById(R.id.doublechkBtn);
        signUpBtn = (Button)findViewById(R.id.signUpBtn);
        pwEdt = (EditText)findViewById(R.id.pwEdt);
        confirmPwEdt = (EditText)findViewById(R.id.confirmPwEdt);
        pwGuideTxt = (TextView)findViewById(R.id.pwGuideTxt);
        iconImg = (ImageView)findViewById(R.id.iconImg);
        birthDayTxt = (TextView)findViewById(R.id.birthDayTxt);

    }
}
