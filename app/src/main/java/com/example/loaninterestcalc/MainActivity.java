package com.example.loaninterestcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText p, r, t;
    TextView res;
    Button btn;
    DecimalFormat formatter = new DecimalFormat("#0.00");
    String sub = "SUBMIT", rb = "RESET";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p = findViewById(R.id.principalUI);
        r = findViewById(R.id.rateUI);
        t = findViewById(R.id.timeUI);

        btn = findViewById(R.id.btnSubmitUI);
        res = findViewById(R.id.tvResultsUI);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn.getText().toString().equals(sub)){
                    try{
                        double vp = Double.parseDouble(p.getText().toString());
                        double vr = Double.parseDouble(r.getText().toString());
                        double vt = Double.parseDouble(t.getText().toString());

                        double SI = vp*vr*vt/100;
                        String d = "Interest: "+formatter.format(SI)+"\n"+"Amount to Repay: "+formatter.format(vp+SI);
                        res.setText(d);
                        btn.setText(rb);
                    }
                    catch(Exception e){
                        res.setText(e.toString());
                    }
                    finally {
                        res.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    res.setVisibility(View.GONE);
                    p.setText(null);
                    r.setText(null);
                    t.setText(null);
                    btn.setText(sub);
                }
            }
        });

    }
}