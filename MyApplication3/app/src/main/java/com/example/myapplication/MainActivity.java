package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button Button;
    private EditText name;
    private EditText email;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Button=findViewById(R.id.button);
            name=findViewById(R.id.name);
            email=findViewById(R.id.email);
            textView=findViewById(R.id.textView);
            return insets;
        });
    }

    public void getSetupViews() {
        return setupViews;
    }
    public void onClick(View view){
        String name=name.getText().toString();
        String email=email.getText().toString();
        int id=rdGroup.getcheckedaRadianButtonId();
        




    }
}