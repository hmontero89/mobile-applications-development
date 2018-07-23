package es.masterd.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);

        // Get the view components
        TextView text = (TextView) findViewById(R.id.text);
        Button button = (Button) findViewById(R.id.button);

        // Sets the text field content
        text.setText(R.string.other);

        // Sets the button field text
        button.setText(R.string.quit);

        // Assigns behavior to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
