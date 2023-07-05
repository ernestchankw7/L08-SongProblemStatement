package sg.edu.rp.c346.id22026341.l08_songproblemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText etTitle;
    TextView tv2;
    EditText etSingers;
    TextView tv3;
    EditText etYear;
    TextView tv4;
    RadioGroup rgStars;
    Button btnInsert;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textViewTitle);
        tv2 = findViewById(R.id.textViewSingers);
        tv3 = findViewById(R.id.textViewYear);
        tv4 = findViewById(R.id.textViewStars);
        etTitle = findViewById(R.id.editTextName);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        rgStars = findViewById(R.id.radio_group);
        btnInsert = findViewById(R.id.buttonInsert);
        btnShow = findViewById(R.id.buttonShow);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                int radioButtonID = rgStars.getCheckedRadioButtonId();
                RadioButton radioButton = rgStars.findViewById(radioButtonID);
                int stars = Integer.parseInt(radioButton.getText().toString());

                // Insert a task
                db.insertTask(etTitle.getText().toString(), etSingers.getText().toString(), Integer.parseInt(etYear.getText().toString()), stars);

            }
        });
    }
}