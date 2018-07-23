package es.masterd.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YetAnotherActivity extends AppCompatActivity {

    private final static int OK_RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);

        // Get view components
        TextView text = (TextView) findViewById(R.id.text);
        Button button = (Button) findViewById(R.id.button);
        TextView params = (TextView) findViewById(R.id.params);

        // Sets the text field content
        text.setText(R.string.other);

        // Sets the button field text
        button.setText(R.string.quit);

        // Assigns behavior to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnParams();
            }
        });

        // Display received params
        Intent intent = getIntent();
        Bundle allParams = intent.getExtras();
        params.setText(allParams.getString("firstParam"));
    }

    protected void returnParams() {
        Intent data = new Intent();
        data.putExtra("result", "returned text");
        setResult(OK_RESULT_CODE, data);
        finish();
    }
}
