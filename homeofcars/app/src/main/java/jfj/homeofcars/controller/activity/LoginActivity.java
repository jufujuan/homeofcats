package jfj.homeofcars.controller.activity;

import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MD5Coder;
import jfj.homeofcars.controller.base.AbsBaseActivity;

/**
 * 登录界面
 */
public class LoginActivity extends AbsBaseActivity implements OnClickListener {
    private EditText nameEt,passwordEt;
    private Button sureBtn;
    @Override
    protected int getLayout() {
        return R.layout.ac_login;
    }

    @Override
    protected void initView() {
        nameEt=bindView(R.id.ac_login_user_name_et);
        passwordEt=bindView(R.id.ac_login_user_password_et);
        sureBtn=bindView(R.id.ac_login_make_sure_btn);
    }

    @Override
    protected void initDatas() {
        sureBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ac_login_make_sure_btn:
                String nameMD5= null;
                String passwordMD5=null;
                try {
                    nameMD5 = MD5Coder.encodeMD5(nameEt.getText().toString().getBytes()).toString();
                    passwordMD5=MD5Coder.encodeMD5(passwordEt.getText().toString().getBytes()).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
                if (sp.getString("name","----错误----").equals("----错误----")){
                    SharedPreferences.Editor editor=sp.edit();
                        if (!nameEt.getText().toString().isEmpty()&&!passwordEt.getText().toString().isEmpty()) {
                            editor.putString("name", nameMD5);
                            editor.putString("password", passwordMD5);
                        }else{
                            Toast.makeText(this, "用户名或者密码不能为空!", Toast.LENGTH_SHORT).show();
                        }
                }else {
                    if (sp.getString("name","----错误----").equals(nameMD5)&&sp.getString("password","----错误----").equals(passwordMD5)){
                        finish();
                    }else{
                        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
