package com.example.activityrecognition_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.sql.Blob;

public class SignUp extends AppCompatActivity {
    RadioButton radioButtonMale, radioButtonFemmel;
    EditText editTextName, editTextEmail, editTextPassword,editTextPhone, editTextFiliere;
    Button buttonChange;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        radioButtonFemmel =(RadioButton) findViewById(R.id.radioButtonFemmel);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        editTextName = (EditText) findViewById(R.id.editName);
        editTextEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextFiliere = (EditText) findViewById(R.id.editTextFiliere);
        buttonChange = (Button) findViewById(R.id.buttonChange);
        imageButton = (ImageButton) findViewById(R.id.imageButton);


        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,email,password,phoneNumber,sex,filiere;
                Blob photo;

                name = String.valueOf(editTextName.getText());
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                phoneNumber = String.valueOf(editTextPhone.getText());
                sex = String.valueOf(radioButtonFemmel.getText());
                if(radioButtonFemmel.isActivated()){
                    sex = String.valueOf(radioButtonFemmel.getText());
                } else if(radioButtonMale.isActivated()){
                    sex = String.valueOf(radioButtonMale.getText());
                }

                filiere = String.valueOf(editTextFiliere.getText());
                /*photo = (Blob) imageButton.getImage;*/

                if(!name.equals("") && !email.equals("") && !password.equals("") && !phoneNumber.equals("") && !sex.equals("") && !filiere.equals("") ) {


                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    String finalSex = sex;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[6];
                            field[0] = "name";
                            field[1] = "email";
                            field[2] = "password";
                            field[3] = "phoneNumber";
                            field[4] = "sex";
                            field[5] = "filiere";
                            //field[6] = "photo";
                            //Creating array for data
                            String[] data = new String[6];
                            data[0] = name;
                            data[1] = email;
                            data[2] = password;
                            data[3] = phoneNumber;
                            data[4] = finalSex;
                            data[5] = filiere;
                            PutData putData = new PutData("http://192.168.137.183/loginRegister/signUp.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")){
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }else {
                    Toast.makeText(getApplicationContext(), "Tous les champs sont obligatoire!", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}