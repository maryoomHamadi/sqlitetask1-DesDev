package sadia.desdev.task1sqlitee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
   EditText log_username;
   EditText log_password;
   Button loginbtn;
   TextView gotoreg;
   DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db=new DatabaseHelper(this);
    log_username=findViewById(R.id.login_username);
    log_password=findViewById(R.id.login_pass);
    loginbtn=findViewById(R.id.loginbutton);
    gotoreg=findViewById(R.id.lg_reg);
    gotoreg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent regIntent=new Intent(login.this,register.class);
            startActivity(regIntent);
        }
    });
    loginbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String user=log_username.getText().toString().trim();
            String passwrd=log_password.getText().toString().trim();
            Boolean res=db.checkUser(user,passwrd);
            if(res==true)
            {
             Intent Loginscreen=new Intent(login.this,MainActivity.class);
             startActivity(Loginscreen);
                        }
            else
            {
                Toast.makeText(login.this," login error ",Toast.LENGTH_SHORT).show();

            }
        }
    });

    }
}
