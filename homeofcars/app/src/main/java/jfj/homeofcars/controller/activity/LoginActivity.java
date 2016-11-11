package jfj.homeofcars.controller.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.Hex;
import jfj.homeofcars.Utils.MD5Coder;
import jfj.homeofcars.View.AutoDeleteEditText;
import jfj.homeofcars.controller.base.AbsBaseActivity;

/**
 * 登录界面
 */
public class LoginActivity extends AbsBaseActivity implements OnClickListener {
    private AutoDeleteEditText nameEt,passwordEt;
    private Button sureBtn;
    private ImageView bgTopImg;
    private int height,width;//屏幕的宽高
    private TextView backBtn;//返回键
    @Override
    protected int getLayout() {
        return R.layout.ac_login;
    }

    @Override
    protected void initView() {
        nameEt=bindView(R.id.ac_login_user_name_et);
        passwordEt=bindView(R.id.ac_login_user_password_et);
        sureBtn=bindView(R.id.ac_login_make_sure_btn);
        bgTopImg=bindView(R.id.ac_login_top_bg_img);
        backBtn=bindView(R.id.ac_login_return);
    }

    @Override
    protected void initDatas() {
        sureBtn.setOnClickListener(this);
        //设置屏幕的宽高
        setScreenSize();
        //设置登录上方图片的宽高
        LayoutParams params= bgTopImg.getLayoutParams();
        params.height=height/3;
        params.width=width;
        bgTopImg.setLayoutParams(params);
        nameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0&&!passwordEt.getText().toString().isEmpty()){
                    sureBtn.setBackgroundColor(Color.parseColor("#1d9cec"));
                }else{
                    sureBtn.setBackgroundColor(Color.parseColor("#7ad1ed"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0&&!nameEt.getText().toString().isEmpty()){
                    sureBtn.setBackgroundColor(Color.parseColor("#1d9cec"));
                }else{
                    sureBtn.setBackgroundColor(Color.parseColor("#7ad1ed"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ac_login_make_sure_btn:
                String nameMD5= null;
                String passwordMD5=null;
                byte[] n,p;
                Hex hex=new Hex();
                try {
                    n=MD5Coder.encodeMD5(nameEt.getText().toString().getBytes());
                    p=MD5Coder.encodeMD5(passwordEt.getText().toString().getBytes());
                    nameMD5 =hex.encodeHexStr(n);
                    passwordMD5=hex.encodeHexStr(p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);//用来添加数据
                SharedPreferences spE=getSharedPreferences("user",MODE_PRIVATE);//用来获取数据库中是否有数据
                Log.d("aaa", "用户名:"+spE.getString("name", "sp中没有这个数据"));
                if (spE.getString("name","----没得到----").equals("----没得到----")){
                    //查sp发现没有就注册
                    SharedPreferences.Editor editor=sp.edit();
                        if (!nameEt.getText().toString().isEmpty()&&!passwordEt.getText().toString().isEmpty()) {
                            editor.putString("name", nameMD5);
                            editor.putString("password", passwordMD5);
                            editor.commit();
                            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent=getIntent();
                            intent.putExtra("name",nameEt.getText().toString());
                            setResult(103,intent);
                            this.finish();
                        }else{
                            Toast.makeText(this, "用户名或者密码不能为空!", Toast.LENGTH_SHORT).show();
                        }
                }else {
                    if (spE.getString("name","----错误----").equals(nameMD5)&&spE.getString("password","----错误----").equals(passwordMD5)){
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent=getIntent();
                        intent.putExtra("name",nameEt.getText().toString());
                        setResult(103,intent);
                        this.finish();
                    }else{
                        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.ac_login_return:
                this.finish();
                break;
        }
    }

    /**
     *  用来获取屏幕的宽高
     */
    public void setScreenSize(){
        WindowManager manager=getWindowManager();
        DisplayMetrics metrics=new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        width=metrics.widthPixels;
        height=metrics.heightPixels;
    }
}
