package com.bigbang.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bigbang.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.user_email_edittext)
    EditText userEmail;

    @BindView(R.id.password_edittext)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.login_button)
    public void onLogin(View view){
     String userEmailText = userEmail.getText().toString().trim();
     String userPasswordText = password.getText().toString().trim();


        FirebaseAuth.getInstance().signInWithEmailAndPassword(userEmailText, userPasswordText)
                .addOnCompleteListener(task -> {

                    if(task.isSuccessful()) {
                        if(FirebaseAuth.getInstance().getCurrentUser().isEmailVerified())
                            Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();//Open home activity
                        else
                            Toast.makeText(this, "Please check verification email.", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(this, ":( "+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                });

    }
}
