package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();

        String all_values = intentFromParent.getStringExtra("all_terms");
//        assert all_values != null;
//        String[] values = all_values.split("");


        String anotherValue = "3";

        Intent intentToParent = new Intent();
        intentToParent.putExtra("another_key", "3");
        setResult(RESULT_OK, intentToParent);
        finish();
    }
}