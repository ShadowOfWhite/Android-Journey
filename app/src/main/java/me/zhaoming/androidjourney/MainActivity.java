package me.zhaoming.androidjourney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import me.zhaoming.ui.UiMarqueeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton toMarquee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toMarquee = findViewById(R.id.btn_marquee);
        toMarquee.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_marquee:
                startActivity(new Intent(getApplicationContext(), UiMarqueeActivity.class));
                break;

                default:
                    break;
        }
    }
}
