package es.masterd.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddNumbersActivity extends AppCompatActivity {

    private final static int OK_RESULT_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_numbers);

        // Get view components
        TextView firstNumber = findViewById(R.id.firstNumber);
        TextView secondNumber = findViewById(R.id.secondNumber);
        Button button = findViewById(R.id.addButton);

        // Display received params
        Intent intent = getIntent();
        Bundle allParams = intent.getExtras();
        final int firstValue = allParams.getInt("firstNumber");
        final int secondValue = allParams.getInt("secondNumber");

        firstNumber.setText("" + firstValue);
        secondNumber.setText("" + secondValue);

        // Assigns behavior to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnParams(firstValue, secondValue);
            }
        });
    }

    protected void returnParams(int firstValue, int secondValue) {
        Intent data = new Intent();
        int result = firstValue + secondValue;
        data.putExtra("result", result);
        setResult(OK_RESULT_CODE, data);
        finish();
    }
}
