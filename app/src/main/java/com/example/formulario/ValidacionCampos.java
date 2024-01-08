package com.example.formulario;

import android.util.Patterns;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import java.util.regex.Pattern;

public class ValidacionCampos {

    private String name;
    private String lastName;
    private String dni;
    private int phoneNumber;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;



    public ValidacionCampos(String name, String lastName, String dni, int phoneNumber, String username,
                            String email, String password, String confirmPassword) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public ValidacionCampos(){

    }

    public static boolean checkValue(String data){
        if(data == null || data.equals("")){
            return false;
        }
        return true;
    }

    public static boolean checkNumbers(String data){
        if(!checkValue(data)){
            return false;
        }

        for(int i = 0; i < data.length(); i++){
            char c = data.charAt(i);
            if(c < '0' || c < '9'){
                return false;
            }
        }
        return true;
    }

    public static boolean checkDni(String number){
        if(!checkValue(number)){
            return false;
        }

        if(number.length() != 9){
            return false;
        }

        checkNumbers(number.substring(0, 8));

        int numDni = Integer.parseInt(number.substring(0, 8));

        String letra = number.substring(9, 9);

        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for(int i = 0; i < abecedario.length; i++){
            if(!letra.contains(abecedario[i])){

                return false;
            }
        }
        return true;
    }
    public static boolean onlyLetters(String data){
        String toValidateLetters = "^[a-zA-Z]+$";

        if(!checkValue(data)){
            return false;
        }

        if(!Pattern.matches(toValidateLetters, data)){
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static boolean validEmail(String email, View view){
        if(!checkValue(email)){
            return false;
        }

        if(!checkEmail(email)){
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Error");
            builder.setMessage("Email no valido");
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        }
        return true;
    }

    public static boolean checkLenghtUsername(String username){
        if(!checkValue(username)){
            return false;
        }

        if(username.length() < 5){
            return false;
        }
        return true;
    }
}
