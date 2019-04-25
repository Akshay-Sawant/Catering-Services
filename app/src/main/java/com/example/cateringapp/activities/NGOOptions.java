package com.example.cateringapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cateringapp.R;

public class NGOOptions extends AppCompatActivity implements View.OnClickListener {

    private EditText selectNGO;
    private Button GetChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngooptions);

        selectNGO = findViewById(R.id.SelectChoice);
        GetChoice = findViewById(R.id.GoToNext);
        initializeEditTextFunc();
    }

    public void initializeEditTextFunc() {
        GetChoice.setOnClickListener(this);
    }

    public void onClick(View view) {
        String check = selectNGO.getText().toString().trim();
        if (check.equals("y") || check.equals("yes") || check.equals("Y") || check.equals("Yes")) {
            startActivity(new Intent(NGOOptions.this, NGOInformation.class));
        } else if (check.equals("n") || check.equals("no") || check.equals("N") || check.equals("No")) {
            NGOOptions.this.finish();
        }
    }
}
