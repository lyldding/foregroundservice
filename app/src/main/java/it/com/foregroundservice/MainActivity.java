package it.com.foregroundservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button startService = (Button) findViewById(R.id.start);
        Button stopService = (Button) findViewById(R.id.stop);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });

        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });

    }

    private void startService() {
        Intent intent = new Intent(this,ForegroundService.class);
        startForegroundService(intent);
    }

    private void stopService() {
        Intent intent = new Intent(this,ForegroundService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService();
    }
}
