package co.nz.littleroom.bmiapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.text_view_result);

        RadioButton maleRadioButton = findViewById(R.id.radio_button_male);
        RadioButton femaleRadioButton = findViewById(R.id.radio_button_female);
        TextView ageTextView = findViewById(R.id.edit_text_age);
        TextView feetTextView = findViewById(R.id.edit_text_feet);
        TextView inchesTextView = findViewById(R.id.edit_text_inches);
        TextView weightTextView = findViewById(R.id.edit_text_weight);
        Button calculateButton = findViewById(R.id.button_calculate);
        TextView resultText = findViewById(R.id.text_view_result);


    }
}