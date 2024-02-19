package com.example.app1;

import static android.provider.Settings.System.getString;

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
        double res;
        if (r1.isChecked()) {
            String s = editTextAmount.getText().toString();
            res = Float.parseFloat(s) / 3.4;
            resultTextView.setText(res + " euros ! ");
            String resAffich = getString(R.string.resultat, res, " Euros !");
            resultTextView.setText(resAffich);
        } else if (r2.isChecked()) {
            res = Float.parseFloat(editTextAmount.getText().toString()) * 3.4;
            resultTextView.setText(getString(R.string.resultat, res, " dinars"));


        } else {
            Toast.makeText(this, "veilez choisir une conversion", Toast.LENGTH_LONG).show();
        }





    }
}