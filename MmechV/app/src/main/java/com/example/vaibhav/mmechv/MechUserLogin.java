
package com.example.vaibhav.mobilemechanic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MechUserLogin extends AppCompatActivity {
    EditText etEmail,etPassword;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_user_login);

        etEmail= (EditText) findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);
        btnSubmit= (Button) findViewById(R.id.btnSubmit);

        Intent i=getIntent();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etEmail.getText().toString();
                String Password=etPassword.getText().toString();


                if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches())
                {
                    etEmail.setError("Invalid Email ID");
                    etEmail.requestFocus();
                }
                else if(etPassword.getText().toString().length()==0)
                {
                    etPassword.setError("Password Required");
                    etPassword.requestFocus();
                }
                else {
                    Intent i = new Intent(MechUserLogin.this, MainActivity.class);
                    startActivity(i);
                }
            }


        });



    }
}
