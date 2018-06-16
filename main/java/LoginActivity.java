package com.mdd.slide.activity;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.mdd.slide.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private Dialog dlgExit;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        player = MediaPlayer.create(this, R.raw.fxsn);
        Log.d("testing", "onCreate got called; Bundle=" + savedInstanceState);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        createDialog();
    }

    public void onPause() {
        super.onPause();
        player.stop();
        Log.d("testing", "onPause got called");
    }

    public void onResume() {
        super.onResume();
        if (player != null) {
            player.setLooping(true);
            player.start();
        }
        Log.d("testing", "onResume got called");
    }

    public void onStart() {
        super.onStart();
        Log.d("testing", "onStart got called");
    }

    public void onStop() {
        super.onStop();
        Log.d("testing", "onStop got called");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("testing", "onDestroy got called");
    }

    private void createDialog(){
        Builder builder = new Builder(this);

        builder.setTitle("退出确认框");
        builder.setMessage("是否确认退出程序");
        builder.setIcon(R.drawable.question);
        builder.setPositiveButton("是", new ExitOnClickListenerImpl());
        builder.setNegativeButton("否", null);

        this.dlgExit = builder.create();
    }

    public void login(View v) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if("mdd".equals(username) && "123".equals(password)){
            Intent intent = new Intent(LoginActivity.this, TestActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);

            intent.putExtras(bundle);
            startActivityForResult(intent, 1);
        }else{
            Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            String  result = data.getStringExtra("result");
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }
    }

    public void exit(View v){
        //显示确认对话框
        this.dlgExit.show();
    }

    private class ExitOnClickListenerImpl implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int id) {

            if(id==Dialog.BUTTON_POSITIVE){
                System.exit(0);
            }
        }
    }
}