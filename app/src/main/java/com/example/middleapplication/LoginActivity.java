package com.example.middleapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText editUsername;
    private EditText editPassword;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this::btnLoginOnClick);
        mediaPlayer = MediaPlayer.create(this, R.raw.ding_dong);
    }

    public void btnLoginOnClick(View view) {
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        if (username.equals("admin") && password.equals("admin")) {
            mediaPlayer.start();
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
            return;
        }
        Toast.makeText(this, "Login not successful", Toast.LENGTH_LONG).show();
    }
}