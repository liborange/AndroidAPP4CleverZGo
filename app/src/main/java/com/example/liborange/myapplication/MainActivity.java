package com.example.liborange.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView textView;
    private TextView user1;
    private TextView user2;
    private Button cleverZGo;
    private Button startChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textView);
        user1 = (TextView) findViewById(R.id.user1);
        user2 = (TextView) findViewById(R.id.user2);
        startChat = (Button) findViewById(R.id.startChat);
        cleverZGo = (Button) findViewById(R.id.cleverZGo);

        cleverZGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CleverZGo.class);
                startActivity(intent);
            }
        });
        textView.setText("oh no hah , you were modified");
        textView.setBackgroundColor(Color.GREEN);
        Button button = (Button) findViewById(R.id.countButton);
        ButtonLisener lisener = new ButtonLisener();
        button.setOnClickListener(lisener);
        button.setOnTouchListener(lisener);
        button.setOnHoverListener(lisener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        startChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChatUser1.class);
                intent.putExtra("user1",user1.getText()+"");
                intent.putExtra("user2",user2.getText()+"");
                intent.putExtra("content","");
                startActivity(intent);
            }
        });
    }

    class cleverZGoLisener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }
    class ButtonLisener implements View.OnClickListener,View.OnTouchListener,View.OnHoverListener {

        @Override
        public void onClick(View v) {
            Log.d("test", "click the button");
            //count ++;
            textView.setText(textView.getText() + "\tclick:"+count++);
        }


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() ==  MotionEvent.ACTION_DOWN)
                Log.d("action", "button down");
            else if (event.getAction() == MotionEvent.ACTION_UP)
                Log.d("action", "button up");
            count ++;
            return false;
        }

        @Override
        public boolean onHover(View v, MotionEvent event) {
            Log.d("test", "hove the button");
            textView.setText(textView.getText() + "\thove:" + count++);
            return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
