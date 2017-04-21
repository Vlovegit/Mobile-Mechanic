package com.example.sahil.mobilemechanic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import static com.example.sahil.mobilemechanic.R.styleable.View;

public class ReviewActivity extends AppCompatActivity {

    EditText etName, etLocation, etEmail, etReview;
    TextView tvRating;
    Button btSubmit;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        etName = (EditText) findViewById(R.id.etName);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etReview = (EditText) findViewById(R.id.etReview);
        tvRating = (TextView) findViewById(R.id.tvRating);
        btSubmit = (Button) findViewById(R.id.btSubmit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String Location = etLocation.getText().toString();
                String email = etEmail.getText().toString();

                if (etName.getText().toString().length() == 0) {
                    etName.setError("Name Required");
                    etName.requestFocus();
                } else if (etLocation.getText().toString().length() == 0) {
                    etLocation.setError("Invalid Location");
                    etLocation.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches())
                {
                    etEmail.setError("Invalid Email ID");
                    etEmail.requestFocus();
                }

                Intent i=new Intent(ReviewActivity.this,BlankActivity.class);
                startActivity (i);

            }
        });
    }
}

