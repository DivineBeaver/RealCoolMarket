package com.example.a1711contextsave;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a1711contextsave.databinding.CoolmarketBinding;

public class CoolMarket extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CoolmarketBinding binding = CoolmarketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+binding.phone.getText().toString()));
                startActivity(intent);
            }
        });

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"whitewoulf320@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Доставка продуктов");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            }
        });
        String s = "Вами были заказаны: ";
        for(int i=0; i<binding.LL.getChildCount();i++){
            for(int j = 0; i<((LinearLayout)binding.LL.getChildAt(i)).getChildCount(); j++){
                CheckBox ch = (CheckBox) ((LinearLayout)binding.LL.getChildAt(i)).getChildAt(j);
                if(ch.isChecked()){
                    s+= ch.getText();
                }

            }
        }
    }
}
