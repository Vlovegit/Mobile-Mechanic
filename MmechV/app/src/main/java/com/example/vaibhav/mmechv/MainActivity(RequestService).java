package com.example.siddhesh.m_mechanic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnRateCard, btnConfirmRequest;
    RadioGroup rgrpType;
    RadioButton rbtnHeavy, rbtnLight;
    Spinner spnProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnRateCard = (Button) findViewById(R.id.btnRateCard);
//        btnConfirmRequest = (Button) findViewById(R.id.btnConfirmRequest);
//        rgrpType = (RadioGroup) findViewById(R.id.rgrpType);
//        rbtnHeavy = (RadioButton) findViewById(R.id.rbtnHeavy);
//        rbtnLight = (RadioButton) findViewById(R.id.rbtnLight);
//        spnProblem = (Spinner) findViewById(R.id.spnProblem);
/*
        LocationManager loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = loc.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double clong = location.getLongitude();
        double clat = location.getLatitude();
        //addresses = geocoder.getFromLocation(clong, clat, 1);
        Toast.makeText(getApplicationContext(),clong+" and "+clat,Toast.LENGTH_LONG).show();
        */
        final ArrayList<String> problems=new ArrayList<String>();
        problems.add("Tyre Burst");
        problems.add("Flat Tyre");
        problems.add("Engine");
        problems.add("Break Failure");

        ArrayAdapter<String> problemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,problems);
        spnProblem.setAdapter(problemsAdapter);

        btnRateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                return;
            }
        });

        btnConfirmRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t=rgrpType.getCheckedRadioButtonId();
                RadioButton r=(RadioButton)findViewById(t);
                String type=r.getText().toString();
                String problem=(String)spnProblem.getSelectedItem();

                Toast.makeText(getApplicationContext(),"Type = "+type+"   problem = "+problem,Toast.LENGTH_LONG).show();


            }
        });
    }
}
