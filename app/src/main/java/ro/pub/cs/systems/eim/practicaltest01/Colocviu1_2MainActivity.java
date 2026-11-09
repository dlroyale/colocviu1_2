package ro.pub.cs.systems.eim.practicaltest01;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_2MainActivity extends AppCompatActivity {
    final private static int ANOTHER_ACTIVITY_REQUEST_CODE = 2017;
    //    private EditText leftEditText;
//    private EditText rightEditText;
//    private Button pressMeButton, pressMeTooButton;
    private Button add_button;
    private Button compute_button;
    private EditText next_term;
    private EditText all_terms;

    private AddButtonClickListener addButtonClickListener = new AddButtonClickListener();
    private ComputeButtonClickListener computeButtonClickListener = new ComputeButtonClickListener();
    private class AddButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String numberToAdd = next_term.getText().toString();
            if (numberToAdd.isBlank()) {
                return;
            }
            if (all_terms.getText().toString().isEmpty()) {
                all_terms.setText(all_terms.getText().toString() + numberToAdd);
            } else {
                all_terms.setText(all_terms.getText().toString() + "+" + numberToAdd);
            }
        }
    }

    private class ComputeButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(Colocviu1_2MainActivity.this, Colocviu1_2SecondaryActivity.class);
            String all_string = all_terms.getText().toString();
//            String final_string = "";
//            for (int i = 0; i < all_string.length(); i++) {
//                if (all_string.charAt(i) != '+') {
//                    final_string += all_string.charAt(i);
//                } else {
//                    final_string += "a";
//                }
//            }
            intent.putExtra("all_terms", all_string);
            startActivityForResult(intent, ANOTHER_ACTIVITY_REQUEST_CODE);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == ANOTHER_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
//                Bundle data = intent.getExtras();
                Toast.makeText(getApplication(), "Compute returned: " + intent.getStringExtra("another_key"), Toast.LENGTH_LONG).show();
            }
        }
    }


//    private ButtonClickListener buttonClickListener = new ButtonClickListener();
//    private class ButtonClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            int leftNumberOfClicks = Integer.valueOf(leftEditText.getText().toString());
//            int rightNumberOfClicks = Integer.valueOf(rightEditText.getText().toString());
//
//            int id = view.getId();
//            if (id == R.id.press_me_button) {
//                leftNumberOfClicks++;
//                leftEditText.setText(String.valueOf(leftNumberOfClicks));
//            } else if (id == R.id.press_me_too_button) {
//                rightNumberOfClicks++;
//                rightEditText.setText(String.valueOf(rightNumberOfClicks));
//            }
//        }
//    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2main);

        all_terms = (EditText)findViewById(R.id.all_terms);
        add_button = (Button)findViewById(R.id.add_button);
        next_term = (EditText)findViewById(R.id.next_term);
        compute_button = (Button)findViewById(R.id.compute_button);

        add_button.setOnClickListener(addButtonClickListener);
        compute_button.setOnClickListener(computeButtonClickListener);
//        leftEditText = (EditText)findViewById(R.id.left_edit_text);
//        rightEditText = (EditText)findViewById(R.id.right_edit_text);
//
//        pressMeButton = (Button)findViewById(R.id.press_me_button);
//        pressMeTooButton = (Button)findViewById(R.id.press_me_too_button);
//
//        leftEditText.setText(String.valueOf(0));
//        rightEditText.setText(String.valueOf(0));
//
//        pressMeButton.setOnClickListener(buttonClickListener);
//        pressMeTooButton.setOnClickListener(buttonClickListener);
    }
}