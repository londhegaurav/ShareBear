package com.example.glondhe.sharebear;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText usernameInput;
    EditText passwordInput;
    TextView gauravsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.gauravseditText);
        passwordInput = (EditText) findViewById(R.id.gauravseditText2);
        gauravsText = (TextView) findViewById(R.id.gauravsTextView);
    }

    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved!", Toast.LENGTH_LONG).show();
    }

    public void displayInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");

        gauravsText.setText(name+" "+pw);

        Toast.makeText(this,"Saved!", Toast.LENGTH_LONG).show();
    }
}
