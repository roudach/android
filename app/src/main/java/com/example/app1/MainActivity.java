package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton r1;
    private RadioButton r2;
    private EditText editTextAmount;
    private Button btnConvert;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=this.findViewById(R.id.radioButton);
        r2 =this.findViewById(R.id.radioButton2);
        editTextAmount = findViewById(R.id.editTextText);
        btnConvert = findViewById(R.id.button);
        resultTextView = findViewById(R.id.textView);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fctConvert();
            }
        });
    }
    private void fctConvert() {
        if(r1.isChecked()){
        String s = editTextAmount.getText().toString();
        double res = Float.parseFloat(s)/3.4;
        String resultat = getString(R.string.resultat, res, "euros");
        resultTextView.setText(resultat);}
        else if (r2.isChecked()) {
            res = Float.parseFloat(editTextAmount.getText().toString()) *3.4;




        }else {
            Toast t =  Toast.makeText(MainActivity.this,
                    "veillez selectionner un boutton radio",
                    Toast.LENGTH_LONG);
            t.show();
        }


        double amount;
        try {
            amount = Double.parseDouble(editTextAmount.getText().toString());
        } catch (NumberFormatException e) {
            resultTextView.setText("Please enter a valid amount.");
            return;
        }

        double conversionRate = r1.isChecked() ? 0.3 : 3.4;

        double result = amount * conversionRate;
        resultTextView.setText("Result: " + result +"!");
    }
}