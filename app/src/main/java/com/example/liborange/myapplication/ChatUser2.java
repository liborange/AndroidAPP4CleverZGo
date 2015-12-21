package com.example.liborange.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatUser2 extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;
    private TextView smallText;
    private TextView welcome;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_user_2);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        smallText = (TextView) findViewById(R.id.smallTV);
        welcome = (TextView) findViewById(R.id.welcome);
        //Log.e("create", "user2\t:create");
        i = getIntent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //i = getIntent();
        welcome.setText(String .format("欢迎%s,正在和%s聊天,祝您愉快",i.getStringExtra("user2"),i.getStringExtra("user1")));
        textView.setText(String .format(textView.getText().toString()+"\n"+i.getStringExtra("content")));
        Log.e("start", "user2\t:" + i.getStringExtra("content"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chat = editText.getText().toString().trim();
                Intent intent;
                if (chat.equals("")) {
                    smallText.setText("⬇️⬇️输入不能为空⬇️⬇️️输入想说的话⬇️⬇️");
                } else {

                    intent = new Intent(ChatUser2.this, ChatUser1.class);
                    intent.putExtra("content", chat);
                    intent.putExtra("user1", i.getStringExtra("user1"));
                    intent.putExtra("user2", i.getStringExtra("user2"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                    //setResult(1, intent);
                    //startActivityForResult(intent,0);
                    //finish();
                }
            }
        });
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        i = intent;
        //overridePendingTransition(in, out);
        //Log.e("newIntent\t", "user2:"+intent.getStringExtra("content"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //i = getIntent();
        //Log.e("restart", "user2\t:"+i.getStringExtra("content").toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //i = getIntent();
        //Log.e("resume", "user2\t:"+i.getStringExtra("content").toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        //i = getIntent();
        textView.setText(String.format(textView.getText() + "\n\t" + editText.getText().toString().trim()));
        editText.setText("");
        //Log.e("pause", "user2\t:"+i.getStringExtra("content").toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        //i = getIntent();
        //Log.e("stop", "user2\t:"+i.getStringExtra("content").toString());
    }
}
