package com.jerek.drone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    private EditText ip_input_1;
    private EditText ip_input_2;
    private EditText ip_input_3;
    private EditText ip_input_4;
    private EditText port_input;
    private EditText command_input;

    private int ip_address_1 = 192;
    private int ip_address_2 = 168;
    private int ip_address_3 = 1;
    private int ip_address_4 = 4;
    private int ip_port = 8080;
    private String ip_command = "?action=stream";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP, ActionBar.DISPLAY_HOME_AS_UP);
        }

        Bundle extras = getIntent().getExtras();

        ip_input_1 = (EditText) findViewById(R.id.settings_ip_1);
        ip_input_2 = (EditText) findViewById(R.id.settings_ip_2);
        ip_input_3 = (EditText) findViewById(R.id.settings_ip_3);
        ip_input_4 = (EditText) findViewById(R.id.settings_ip_4);
        port_input = (EditText) findViewById(R.id.settings_port);
        command_input = (EditText) findViewById(R.id.settings_command);

        if(extras != null) {
            ip_address_1 = extras.getInt("ip_address_1", ip_address_1);
            ip_address_2 = extras.getInt("ip_address_2", ip_address_2);
            ip_address_3 = extras.getInt("ip_address_3", ip_address_3);
            ip_address_4 = extras.getInt("ip_address_4", ip_address_4);
            ip_port = extras.getInt("ip_port", ip_port);
            ip_command = extras.getString("ip_command");

            ip_input_1.setText(String.valueOf(ip_address_1));
            ip_input_2.setText(String.valueOf(ip_address_2));
            ip_input_3.setText(String.valueOf(ip_address_3));
            ip_input_4.setText(String.valueOf(ip_address_4));
            port_input.setText(String.valueOf(ip_port));
            command_input.setText(String.valueOf(ip_command));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                String s;

                s = ip_input_1.getText().toString();
                if (!"".equals(s)) {
                    ip_address_1 = Integer.parseInt(s);
                }
                s = ip_input_2.getText().toString();
                if (!"".equals(s)) {
                    ip_address_2 = Integer.parseInt(s);
                }
                s = ip_input_3.getText().toString();
                if (!"".equals(s)) {
                    ip_address_3 = Integer.parseInt(s);
                }
                s = ip_input_4.getText().toString();
                if (!"".equals(s)) {
                    ip_address_4 = Integer.parseInt(s);
                }

                s = port_input.getText().toString();
                if (!"".equals(s)) {
                    ip_port = Integer.parseInt(s);
                }

                s = command_input.getText().toString();
                ip_command = s;

                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("ip_address_1", ip_address_1);
                intent.putExtra("ip_address_2", ip_address_2);
                intent.putExtra("ip_address_3", ip_address_3);
                intent.putExtra("ip_address_4", ip_address_4);
                intent.putExtra("ip_port", ip_port);
                intent.putExtra("ip_command", ip_command);

                setResult(RESULT_OK, intent);
                finish();
                return true;
            }
        }
        return false;
    }
 }
