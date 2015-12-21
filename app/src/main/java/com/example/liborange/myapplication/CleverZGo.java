package com.example.liborange.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
    public void sendCMD(String  cmd){
        service.execute(cmd);
    }
}
