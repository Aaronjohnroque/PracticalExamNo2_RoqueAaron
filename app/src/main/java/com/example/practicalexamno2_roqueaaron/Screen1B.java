package com.example.practicalexamno2_roqueaaron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Screen1B extends AppCompatActivity {

    private static final String fileName = "subjects.txt";
    private static final String comment = "comment.txt";
    TextView TextView;
    TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1_b);
        TextView = findViewById(R.id.TextView);
        editText = findViewById(R.id.editText);



        FileInputStream cat = null;

        try {
            cat = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(cat);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
            }

            TextView.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cat != null) {
                try {
                    cat.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            cat = openFileInput(comment);
            InputStreamReader isr = new InputStreamReader(cat);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
            }

            editText.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cat != null) {
                try {
                    cat.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void Previous(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Send(View view)
    {
        Toast.makeText(this, "Registration Sent... " , Toast.LENGTH_LONG).show();
    }



}
