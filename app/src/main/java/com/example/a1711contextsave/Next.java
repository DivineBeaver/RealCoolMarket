package com.example.a1711contextsave;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a1711contextsave.databinding.NextBinding;

public class Next extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NextBinding next = NextBinding.inflate(getLayoutInflater());
        setContentView(next.getRoot());

        SharedPreferences pref = MainActivity.pref;
        SharedPreferences.Editor edit = pref.edit();

        //Сброс пароля и логина
        next.Sbros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putString(MainActivity.PASSWORDSTRING, "-");
                edit.putString(MainActivity.LOGINSTRING, "-");
                edit.commit();
                finish();
            }
        });
        next.ButNewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.LOGINTRUE = next.NewLoginString.getText().toString();
            }
        });
        next.ButNewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.PASSWORDTRUE = next.NewPasswordString.getText().toString();
            }
        });
        next.ToMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Next.this, CoolMarket.class);
                startActivity(intent);
            }
        });
    }
}
