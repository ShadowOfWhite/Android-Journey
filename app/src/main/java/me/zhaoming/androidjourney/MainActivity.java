package me.zhaoming.androidjourney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import me.zhaoming.ui.UiMarqueeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton toMarquee;
    AppCompatSpinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toMarquee = findViewById(R.id.btn_marquee);
        spinner = findViewById(R.id.spinner);
        toMarquee.setOnClickListener(this);

        initSpinner();

    }

    private void initSpinner() {
        String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};
        ArrayAdapter<String> starAdapter = new ArrayAdapter<String>(this,
                R.layout.item_select, starArray);
        starAdapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner.setPrompt("请选择行星");
        spinner.setAdapter(starAdapter);
        spinner.setSelection(0);

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
