package co.nz.littleroom.bmiapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private TextView ageTextView;
    private TextView feetTextView;
    private TextView inchesTextView;
    private TextView weightTextView;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void findViews() {
        maleRadioButton = findViewById(R.id.radio_button_male);
        femaleRadioButton = findViewById(R.id.radio_button_female);
        ageTextView = findViewById(R.id.edit_text_age);
        feetTextView = findViewById(R.id.edit_text_feet);
        inchesTextView = findViewById(R.id.edit_text_inches);
        weightTextView = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageText = ageTextView.getText().toString();
        String feetText = feetTextView.getText().toString();
        String inchesText = inchesTextView.getText().toString();
        String weightText = weightTextView.getText().toString();

        // Calculate BMI
        if (!ageText.isEmpty() && !feetText.isEmpty() && !inchesText.isEmpty() && !weightText.isEmpty()) {
            int age = Integer.parseInt(ageText);
            int feet = Integer.parseInt(feetText);
            int inches = Integer.parseInt(inchesText);
            double weight = Double.parseDouble(weightText);
            double heightInInches = feet * 12 + inches;

            // Convert height to meters
            double heightInMeters = heightInInches * 0.0254;

            // Calculate BMI with formula = weight in kg divided by height in meters squared
            double bmi = weight / (heightInMeters * heightInMeters);

            // Display the result
            resultText.setText(String.format("Your BMI is %.2f", bmi));
        } else {
            if (ageText.isEmpty() || feetText.isEmpty() || inchesText.isEmpty() || weightText.isEmpty()) {
                resultText.setText("Please enter all values");
                return;
            }
        }
    }
}