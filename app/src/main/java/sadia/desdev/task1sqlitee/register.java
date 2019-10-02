package sadia.desdev.task1sqlitee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
  EditText reg_username,reg_pass,reg_email;
  Button reg;
  DatabaseHelper db;
  TextView alreadyaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        reg_username=findViewById(R.id.regusername);
        reg_email=findViewById(R.id.regemail);
        reg_pass=findViewById(R.id.regpass);
        reg=findViewById(R.id.register);
        alreadyaccount=findViewById(R.id.reg_log);
        db = new DatabaseHelper(this);
        alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent=new Intent(register.this,login.class);
                startActivity(loginIntent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=reg_username.getText().toString().trim();
                String pwd=reg_pass.getText().toString().trim();
                long val=db.AddUser(user,pwd);
                if(val>0)
                {
                    Toast.makeText(register.this,"registered successfully",Toast.LENGTH_SHORT).show();
                    Intent movetologin =new Intent(register.this,login.class);
                    startActivity(movetologin);
                }
                else
                {
                    Toast.makeText(register.this,"registeration error",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
