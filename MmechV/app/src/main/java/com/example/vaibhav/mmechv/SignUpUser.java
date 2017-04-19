package com.example.vaibhav.mobilemechanic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpUser extends AppCompatActivity {


    EditText tvName, etContact, etEmail1, etPassword1,etConfirmPassword;
    View myView;
    View btnSubmit1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);
        Intent i = getIntent();

        btnSubmit1=findViewById(R.id.btnSubmit1);
        tvName= (EditText) findViewById(R.id.tvName);
        etContact= (EditText) findViewById(R.id.etContact);
        etEmail1= (EditText) findViewById(R.id.etEmail1);
        etPassword1= (EditText) findViewById(R.id.etPassword1);
        etConfirmPassword= (EditText) findViewById(R.id.etConfirmPassword);


        btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = tvName.getText().toString();
                String contact = etContact.getText().toString();
                String email1 = etEmail1.getText().toString();
                String password = etPassword1.getText().toString();
                String Confirmpassword = etConfirmPassword.getText().toString();


                if (tvName.getText().toString().length() == 0) {
                    tvName.setError("Name Required");
                    tvName.requestFocus();
                } else if (etContact.getText().toString().length() == 0) {
                    etContact.setError("Invalid Contact");
                    etContact.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail1.getText().toString()).matches()) {
                    etEmail1.setError("Invalid Email ID");
                    etEmail1.requestFocus();
                } else if (etPassword1.getText().toString().length() == 0) {
                    etPassword1.setError("Incorrect password");
                    etPassword1.requestFocus();
                } else if (etConfirmPassword.getText().toString().length() == 0) {
                    etConfirmPassword.setError("Invalid password");
                    etPassword1.requestFocus();
                } else {
                    Intent i = new Intent(SignUpUser.this, HomeActivity.class);
                    startActivity(i);

                }
            }


                });}}




