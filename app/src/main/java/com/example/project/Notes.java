package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class Notes extends AppCompatActivity {

    private final String PREFE_KEY = "myprefe";
    EditText ed1, dateEd;
    String input = "";
    ImageView delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.MONTH));

        delete = findViewById(R.id.deleteNotes);
        dateEd = findViewById(R.id.text);
        ed1 = findViewById(R.id.Title);
        ed1.setText(getValueNoteActivity1(getApplicationContext()));

        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                saveValue1(getApplicationContext(), charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void saveValue1(Context context1, String text1) {
        SharedPreferences settings = context1.getSharedPreferences(PREFE_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString("EditText", text1);
        editor.apply();
    }

    public String getValueNoteActivity1(Context context1) {
        SharedPreferences preferences = context1.getSharedPreferences(PREFE_KEY, MODE_PRIVATE);

        return preferences.getString("EditText", "");

    }

    public void deleteN(View view) {

        DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        input = "";
                        ed1.setText("");
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:

                        break;
                }
            }
        };
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Delete");
        ab.setIcon(R.drawable.ic_delete);
        ab.setMessage("Are you sure you want to delete everything inside your notes?").setPositiveButton("yes", dialog)
                .setNegativeButton("no", dialog).show();
    }

    public void arrowBackOption(View view) {


        if (!ed1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Your notes are saved.", Toast.LENGTH_SHORT).show();

        } else {
            if (ed1.getText().toString().isEmpty()) {
                Toast.makeText(this, "There`s nothing to save. \n Your notes will be dismissed.", Toast.LENGTH_SHORT).show();

            }
        }
        finish();

    }

    public void dismiss(View view) {
        DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:

                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:

                        break;
                }
            }
        };
        if (!ed1.getText().toString().isEmpty()) {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setTitle("Close");
            ab.setIcon(R.drawable.ic_close);
            ab.setMessage("All your changes will be dismissed, are you sure you want to close your notes?").setPositiveButton("yes", dialog)
                    .setNegativeButton("no", dialog).show();
        } else {
            finish();
        }
    }
}