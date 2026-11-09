package ro.pub.cs.systems.eim.practicaltest01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01MainActivity extends AppCompatActivity {
    private EditText leftEditText;
    private EditText rightEditText;
    private Button pressMeButton, pressMeTooButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int leftNumberOfClicks = Integer.valueOf(leftEditText.getText().toString());
            int rightNumberOfClicks = Integer.valueOf(rightEditText.getText().toString());

            int id = view.getId();
            if (id == R.id.press_me_button) {
                leftNumberOfClicks++;
                leftEditText.setText(String.valueOf(leftNumberOfClicks));
            } else if (id == R.id.press_me_too_button) {
                rightNumberOfClicks++;
                rightEditText.setText(String.valueOf(rightNumberOfClicks));
            }
        }
    }

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
        
        pressMeButton.setOnClickListener(buttonClickListener);
        pressMeTooButton.setOnClickListener(buttonClickListener);
    }
}