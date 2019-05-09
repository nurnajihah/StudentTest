package sg.edu.rp.c346.studenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;
    Button btnInsert, btnRetrieve;
    TextView tvInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editText2);
        etGPA = findViewById(R.id.editText3);
        btnInsert = findViewById(R.id.button);
        btnRetrieve = findViewById(R.id.button2);
        tvInfo = findViewById(R.id.textView2);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertStudent(etName.getText().toString(), etGPA.getText().toString());
                db.close();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Student> data = db.getTasks();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                Log.d("Database Content", i +". " + data.get(i).getName());
                txt += i + ". " + data.get(i).getId() + " " + data.get(i).getName() + " " + data.get(i).getGpa() + "\n";
                 }
                 tvInfo.setText(txt);
            }
        });
    }
}
