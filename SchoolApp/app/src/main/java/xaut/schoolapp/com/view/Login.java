package xaut.schoolapp.com.view;

        import android.content.Intent;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import xaut.schoolapp.com.model.AppData;
        import xaut.schoolapp.com.controller.RequestWebServece;
        import xaut.schoolapp.com.schoolapp.R;
        import xaut.schoolapp.com.controller.ActivityControl;


public class Login extends AppCompatActivity {
    private Button login_button;
    private String username;
    private String password;
    private EditText mUEditText;
    private EditText mPEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityControl.addActivity(this);
        login_button = (Button)findViewById(R.id.login_button);
        mUEditText = (EditText)findViewById(R.id.username);
        mPEditText = (EditText)findViewById(R.id.password);

        username = mUEditText.getText().toString();
        password = mPEditText.getText().toString();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                Intent intent = new Intent(Login.this, MapActivity.class);
                startActivity(intent);
            }
           /* @Override
            public void onClick(View v) {
                if(username.equals("") || password.equals("")){
                    Toast.makeText(Login.this,"用户名或者密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            *//**//*java.util.Map<String,String> params = null;
                            params.put("username",username);
                            params.put("password",password);

                            AppData url = new AppData();

                            String res = RequestWebServece.submitdata(url.login_url,params);*//**//*
                            Intent intent = new Intent(Login.this, Map.class);
                            startActivity(intent);
                        }
                    }).start();*//*

                }
            }*/
        });
    }
}
