package xaut.schoolapp.com.schoolapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import xaut.schoolapp.com.map.Map;
        import xaut.schoolapp.com.method.ActivityControl;

public class Login extends AppCompatActivity {
    private Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityControl.addActivity(this);
        login_button = (Button)findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Map.class);
                startActivity(intent);
            }
        });
    }
}
