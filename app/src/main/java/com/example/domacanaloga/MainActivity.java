package com.example.domacanaloga;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.button).setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "My first Android Studio application!", Toast.LENGTH_SHORT).show();
        });
        findViewById(R.id.floatingActionButton2).setOnClickListener(view -> {
            //Snackbar snackbar1 = Snackbar.make(MainActivity.this,view,"Just another option for button1.",Snackbar.LENGTH_SHORT);
            Snackbar snackbar = Snackbar.make(MainActivity.this,view,"Just another option for button.",Snackbar.LENGTH_SHORT);
            View snackbarView = snackbar.getView();

            GradientDrawable background = new GradientDrawable();
            background.setColor(Color.parseColor("#F5F5F5"));
            background.setCornerRadius(50);

            snackbarView.setBackground(background);

            ViewGroup.LayoutParams params = snackbarView.getLayoutParams();
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            snackbarView.setLayoutParams(params);

            TextView textView = snackbarView.findViewById(
                    com.google.android.material.R.id.snackbar_text
            );

            textView.setTextColor(Color.BLACK);
            textView.setTextSize(14);
            textView.setGravity(Gravity.CENTER);
            textView.setMaxLines(3);

            FrameLayout.LayoutParams layoutParams =
                    (FrameLayout.LayoutParams) snackbarView.getLayoutParams();

            layoutParams.gravity = Gravity.CENTER;
            snackbarView.setLayoutParams(layoutParams);


            snackbar.show();
            //snackbar1.show();
        });
    }
}