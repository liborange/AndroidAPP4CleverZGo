package com.example.liborange.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.liborange.myapplication.connection.CWD;
import com.example.liborange.myapplication.connection.CmdService;
import com.example.liborange.myapplication.connection.RpcFramework;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━  Created by liborange on 15/12/21.
 */
public class CleverZGo extends AppCompatActivity {

    private CmdService service;
    private Button forward;
    private Button back;
    private Button left;
    private Button right;
    private Button FR;
    private Button FL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controller);
        forward = (Button)findViewById(R.id.forward);
        back = (Button) findViewById(R.id.back);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        FR = (Button) findViewById(R.id.FR);
        FL = (Button) findViewById(R.id.FL);


        forward.setOnTouchListener(new ButtonListener(CWD.forward));
        back.setOnTouchListener(new ButtonListener(CWD.back));
        left.setOnTouchListener(new ButtonListener(CWD.left));
        right.setOnTouchListener(new ButtonListener(CWD.right));
        FR.setOnTouchListener(new ButtonListener(CWD.fr));
        FL.setOnTouchListener(new ButtonListener(CWD.fl));
    }

    class ButtonListener implements View.OnTouchListener{

        private CWD identify;
        public ButtonListener(CWD identify){
            this.identify = identify;
        }
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
               sendCMD(identify);
            }else if (event.getAction() == MotionEvent.ACTION_UP){
                sendCMD("stop");
            }
            return false;
        }
    }

    //TODO: 初始化，按钮事件监听，发送命令。晚上回来再做，游泳去了。15:50 2015.12.21


    public void init(String ip,int port){
        try {
            service = RpcFramework.refer(CmdService.class,ip,port);
        } catch (Exception e) {
            Log.d("error","Rpc 连接失败.");
        }
    }
    /**
     *
     * @param cmd
     */
    public void sendCMD(Object  cmd){
        service.execute(cmd);
    }
}
