package com.young.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.young.mvp.bean.User;
import com.young.mvp.model.UserModel;
import com.young.mvp.presenter.UserPresenter;
import com.young.mvp.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView {

    Button btn1, btn2, btn3;
    EditText et1, et2, et3;
    UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);

        userPresenter = new UserPresenter(this, new UserModel());
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(et1.getText().toString(), et2.getText().toString());
                userPresenter.saveUser(user);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPresenter.readUser(et3.getText().toString());
            }
        });
    }


    @Override
    public void setUserName(String name) {
        et1.setText(name);
    }

    @Override
    public void setUserPassword(String password) {
        et2.setText(password);
    }

    @Override
    public void errorMsg(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
