package com.mercacortex.manageproductrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class operate the classic login screen using MVP method.
 * @Author Jaime
 * @Version 1.0
 */

public class LoginRelative_Activity extends AppCompatActivity implements ILoginMvp.View {

    private ILoginMvp.Presenter loginMvp;
    private EditText edtPassword;
    private EditText edtUser;
    private Button btnOk;
    private final String TAG = "loginrelative";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative_);

        loginMvp = new LoginPresenter(this);
        edtUser = (EditText) findViewById(R.id.edt_user);
        edtPassword = (EditText) findViewById(R.id.edt_password);

        btnOk = (Button) findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginMvp.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString())) {
                    Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                    startActivity(intent);
                }
            }
        });

        //Comprobar la persistencia del objeto Application
        //if (((LoginAplication)getApplicationContext()).getUser() != null)
        //    Log.d("TAG", ((LoginAplication)getApplicationContext()).getUser().toString());
    }

    private void resetValues() {
        edtUser.setText("");
        edtPassword.setText("");
    }

    @Override
    public void setMessageError(String messageError, int idView) {
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
        switch (idView){
            case R.id.edt_user:
                edtUser.setError(messageError);
                break;
            case R.id.edt_password:
                edtPassword.setError(messageError);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity finalizada");
    }
}
