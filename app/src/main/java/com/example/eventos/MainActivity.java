package com.example.eventos;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    TextView actionLabel;
    int counter = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionLabel = (TextView) findViewById(R.id.action);
    }

    @Override
    // catches the onKeyDown button event
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                actionLabel.setText("KEYCODE_BACK key pressed");
                Toast.makeText(this, "Press again back for exit", Toast.LENGTH_SHORT).show();
                counter++;
                if (counter > 1) {
                    super.onBackPressed();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                actionLabel.setText("VOLUME_UP key pressed");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                actionLabel.setText("VOLUME_DOWN key pressed");
                return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    // catches the onKeyUp button event
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                actionLabel.setText("KEYCODE_BACK key released");
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                actionLabel.setText("VOLUME_UP key released");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                actionLabel.setText("VOLUME_DOWN key released");
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // works for API level 5 and lower
    @Override
    public void onBackPressed() {
        actionLabel.setText("BACK key pressed");
        super.onBackPressed();
    }

    // catches the long press button event (longer than 2 seconds)
    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Toast.makeText(this, "Pressed for a long time", Toast.LENGTH_SHORT).show();
        return true;
    }

    // catches the on touch event on screen and shows the specific pixels
    // touched


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        actionLabel.setText("Touch press on x: " + x + " y: " + y);
        return true;
    }
}