package com.example.a1711contextsave;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a1711contextsave.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static final String LOGINSTRING = "login";
    static final String PASSWORDSTRING = "password";
    static String PASSWORDTRUE = "12345";
    static String LOGINTRUE = "1234";
    static SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        if(pref.getString(LOGINSTRING, "no value").equals(LOGINTRUE) && pref.getString(PASSWORDSTRING, "no value").equals(PASSWORDTRUE)){
            Intent intent = new Intent(MainActivity.this, Next.class);
            startActivity(intent);
        }
        binding.Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = binding.Login.getText().toString();
                String password = binding.Password.getText().toString();
                if(login.equals(LOGINTRUE)&&password.equals(PASSWORDTRUE)){
                    edit.putString(LOGINSTRING, login);
                    edit.putString(PASSWORDSTRING, password);
                    edit.apply();
                    Intent intent = new Intent(MainActivity.this, Next.class);
                    startActivity(intent);
                }else{
                    makeText(MainActivity.this,"Неверные данные.",Toast.LENGTH_SHORT).show();
                    //binding.TV.setText("не правильно введен пароль или логин");
                }
            }
        });
//        binding.Load.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String str  = pref.getString(LOGINSTRING, "no value");
//                binding.TV.setText(str);
//            }
//        });
    }
}