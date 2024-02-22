package com.example.healthmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView HeartRateTV, GlucoseTV, OxygenTV, StressTV;
    DatabaseReference databaseReference;
    String HeartRateValue, GlucoseValue, OxygenValue, StressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeartRateTV = findViewById(R.id.HeartRateTextView);
        GlucoseTV = findViewById(R.id.GlucoseTextView);
        OxygenTV = findViewById(R.id.OxygenTextView);
        StressTV = findViewById(R.id.StressTextView);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HeartRateValue = dataSnapshot.child("Heartbeat").getValue().toString();
                HeartRateTV.setText(HeartRateValue);
                GlucoseValue = dataSnapshot.child("Glucose").getValue().toString();
                GlucoseTV.setText(GlucoseValue);
                OxygenValue = dataSnapshot.child("Oxygen").getValue().toString();
                OxygenTV.setText(OxygenValue);
                StressValue = dataSnapshot.child("Stress").getValue().toString();
                StressTV.setText(StressValue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
