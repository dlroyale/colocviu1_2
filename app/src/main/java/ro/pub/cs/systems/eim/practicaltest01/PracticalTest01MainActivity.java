package ro.pub.cs.systems.eim.practicaltest01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01MainActivity extends AppCompatActivity {
    private EditText leftEditText;
    private EditText rightEditText;
    private Button pressMeButton, pressMeTooButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        leftEditText = (EditText)findViewById(R.id.left_edit_text);
        rightEditText = (EditText)findViewById(R.id.right_edit_text);

        pressMeButton = (Button)findViewById(R.id.press_me_button);
        pressMeTooButton = (Button)findViewById(R.id.press_me_too_button);

        leftEditText.setText(String.valueOf(0));
        rightEditText.setText(String.valueOf(0));
    }
}