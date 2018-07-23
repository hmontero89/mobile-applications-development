package es.masterd.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final int REQUEST_CODE = 100;
    protected static final int ADD_NUMBERS_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Getting the button components
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);

        // Button one launches an activity onclick
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), OtherActivity.class);
                startActivity(intent);
            }
        });

        // Button two launches an activity onclick and passes parameters, to be returned modified
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), YetAnotherActivity.class);
                // Passing first parameter
                intent.putExtra("firstParam", "This is the first param");
                // Calling the activity specifying expecting return in the const specified
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        // Button three launches an activity onclick and passes parameters, to be returned added
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), AddNumbersActivity.class);
                // Passing first parameter
                intent.putExtra("firstNumber", 2);
                intent.putExtra("secondNumber", 4);
                // Calling the activity specifying expecting return in the const specified
                startActivityForResult(intent, ADD_NUMBERS_REQUEST_CODE);
            }
        });

        // Button four launches the logger activity
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), LoggerActivity.class);
                startActivity(intent);
            }
        });

        // Button four launches the logger activity
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            // Get the result
            String result = data.getStringExtra("result");
            // Display a user message
            Toast toast = Toast.makeText(getApplicationContext(), "Returned Value: " + result, Toast.LENGTH_LONG);
            toast.show();
        } else if (requestCode == ADD_NUMBERS_REQUEST_CODE) {
            // Get the result
            int result = data.getIntExtra("result", 0);
            // Display a user message
            Toast toast = Toast.makeText(getApplicationContext(), "Result of Sum: " + result, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
