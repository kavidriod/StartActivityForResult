package com.apps.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.apps.startactivityforresult.R.id.phoneNoEditeText;

public class SecondActivity extends AppCompatActivity {

    TextView nameTextview,phoneTextview;
    Button goBackButton;
    TextInputLayout emailTextInputLayout;
    EditText emailEditeText;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nameTextview = (TextView) findViewById(R.id.nameTextview);
        phoneTextview = (TextView) findViewById(R.id.phoneTextview);
        goBackButton = (Button) findViewById(R.id.goBackButton);
        emailEditeText = (EditText) findViewById(R.id.emailEditeText);
        emailTextInputLayout = (TextInputLayout) findViewById(R.id.emailTextInputLayout);

        emailEditeText.addTextChangedListener(new TextWatcher());

        //Get Values from Calling Activity

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("NAME");
        int phoneNo = bundle.getInt("PHONENO");

        nameTextview.setText("Name ? "+name);
        phoneTextview.setText("PhoneNo ? "+phoneNo);


        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    goBackIntent();
            }
        });



    }

    private void goBackIntent() {

        if (!validateEmail()){
            return;
        }


        Intent intent = new Intent();
        intent.putExtra("EMAIL",emailEditeText.getText().toString());
        setResult(REQUEST_CODE,intent);
        finish();
    }



    class  TextWatcher implements android.text.TextWatcher{



        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                      validateEmail();
        }
    }

    private boolean validateEmail() {
        if (emailEditeText.getText().toString().trim().isEmpty()){
            emailTextInputLayout.setError("Please Enter Email");
            return false;

        }else {
            emailTextInputLayout.setErrorEnabled(false);
        }
        return true;
    }



}
