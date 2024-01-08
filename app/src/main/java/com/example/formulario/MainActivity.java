package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputPassword;
    private CheckBox checkPassword;
    private CheckBox checkPassword2;

    private String name;
    private String lastName;
    private String dni;
    private int phoneNumber;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    ValidacionCampos validacionCampos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ValidacionCampos(name, lastName, dni,
                phoneNumber, username, email, password, confirmPassword);

        inputPassword = findViewById(R.id.inputPassword);
        checkPassword = findViewById(R.id.checkPassword);
        checkPassword2 = findViewById(R.id.checkPassword2);

        checkPassword.setOnCheckedChangeListener((buttonView, isChecked) ->{
            if(isChecked){
                inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }else {
                inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

        checkPassword2.setOnCheckedChangeListener((buttonView, isChecked) ->{
            if(isChecked){
                inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }else {
                inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

    }

    public void validate(){

    }

}