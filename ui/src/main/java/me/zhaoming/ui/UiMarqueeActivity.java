package me.zhaoming.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class UiMarqueeActivity extends AppCompatActivity implements  View.OnTouchListener {
    private TextView tv_marquee;
    private boolean bPause = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_marquee);
        tv_marquee = findViewById(R.id.tv_marquee);
        tv_marquee.setClickable(true);
        tv_marquee.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.tv_marquee && event.getAction() == MotionEvent.ACTION_UP) {
            bPause = !bPause;
            if (bPause) {
                Log.d("UiMarqueeActivity", "失去焦点***");
                tv_marquee.setFocusable(false);
                tv_marquee.setFocusableInTouchMode(false);
            } else {
                Log.d("UiMarqueeActivity", "得到焦点***");
                tv_marquee.setFocusable(true);
                tv_marquee.setFocusableInTouchMode(true);
            }
        }

        return false;
    }
}
