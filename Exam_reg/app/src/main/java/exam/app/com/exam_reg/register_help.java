package exam.app.com.exam_reg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by USER on 6/23/2016.
 */
public class register_help extends AppCompatActivity {


    Button btn;
    EditText fname;
    EditText lname;
    EditText address;
    EditText phone;
    EditText email;
    EditText pass;
    Sqlhelper sqh;
    String firstn,lastn,add,phn,ema,passw;
    int inserted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
sqh=new Sqlhelper(this);

        Button btn=(Button)findViewById(R.id.signup_bt);
        final EditText fname=(EditText)findViewById(R.id.edt_fname);
        final EditText lname=(EditText)findViewById(R.id.edt_lname);
        final EditText address=(EditText)findViewById(R.id.edt_address);
        final EditText phone=(EditText)findViewById(R.id.edt_phone);
        final EditText email=(EditText)findViewById(R.id.edt_email);
        final EditText pass=(EditText)findViewById(R.id.edt_password);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstn = fname.getText().toString();
                lastn = lname.getText().toString();
                add = address.getText().toString();
                phn = phone.getText().toString();
                ema = email.getText().toString();
                passw = pass.getText().toString();

                inserted = sqh.insertValues(firstn,lastn,add,phn,ema,passw);
                if (inserted == 0)
                {
                    Toast.makeText(getApplicationContext(), "data inserted", Toast.LENGTH_SHORT).show();
                    Intent inte=new Intent(getApplicationContext(),Login.class);
                    startActivity(inte);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "error inserting", Toast.LENGTH_SHORT).show();
                }

            }
        });







    }
}
