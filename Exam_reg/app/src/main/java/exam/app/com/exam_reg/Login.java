package exam.app.com.exam_reg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Sqlhelper sqh;
    EditText edt;
    EditText edt2;
    TextView txt;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
         sqh=new Sqlhelper(this);

Button btn=(Button)findViewById(R.id.button);


      edt=(EditText)findViewById(R.id.editText);
         edt2=(EditText)findViewById(R.id.editText2);
        txt=(TextView)findViewById(R.id.textView);

     txt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent inten=new Intent(getApplicationContext(),register_help.class);
        startActivity(inten);
    }
});
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String b=sqh.getSingleData(edt.getText().toString());
                if(b.equals("NOT EXIST"))
                {

                    Toast.makeText(getApplicationContext(),"No such account",Toast.LENGTH_LONG).show();
                }
                else if(b.equals(edt2.getText().toString()))
                {
                    Intent intent=new Intent(getApplicationContext(),home.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login error",Toast.LENGTH_LONG).show();

                }
            }
        });




    }


}
