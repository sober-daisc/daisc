package com.example.daisc.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.add_item:
                showToast("you are going to Baidu");
                startIntentWeb();
                break;
            case R.id.remove_item:
                showToast("this is for remove item");
                break;
            case R.id.exitApp:
                finish();
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        bindListener();
    }

    private View.OnClickListener mBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.Button_1:
                    showToast(R.string.toast_test_1);
                    startIntentIndication();
                    break;
                case R.id.Button_Hide_Intent:
                    startIntentHiden();
                default:
                    break;
            }
        }
    };
    private void bindListener(){
        Button button = findViewById(R.id.Button_1);
        if (null != button){
            button.setOnClickListener(mBtnListener);
        }

        button = findViewById(R.id.Button_Hide_Intent);
        if (null != button){
            button.setOnClickListener(mBtnListener);
        }
    }

    private void showToast(int resId){
        Toast.makeText(MainActivity.this,resId,Toast.LENGTH_SHORT).show();
    }

    private void showToast(String strToast){
        Toast.makeText(MainActivity.this,strToast,Toast.LENGTH_SHORT).show();
    }

    //显示Intent
    private void startIntentIndication(){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    //隐式Intent
    private void startIntentHiden(){
        Intent intent = new Intent("com.example.activitytest.ACTION_START");
        intent.addCategory("com.example.activitytest.MY_CATEGORY");
        startActivity(intent);
    }

    //隐式intent 打开网页
    private void startIntentWeb(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }
}
