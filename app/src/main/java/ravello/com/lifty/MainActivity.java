package ravello.com.lifty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    public final static String EXTRA_MESSAGE_CAR_PLATE_NUMBER = "ravello.com.lifty.CAR_PLATE_NUMBER";
    public final static String EXTRA_MESSAGE_CAR_DRIVER_NAME = "ravello.com.lifty.CAR_DRIVER_NAME";
    public final static String EXTRA_MESSAGE_CAR_DRIVER_EMAIL = "ravello.com.lifty.CAR_DRIVER_EMAIL";
    public final static String EXTRA_MESSAGE_CAR_DRIVER_PHONE = "ravello.com.lifty.CAR_DRIVER_PHONE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lookup(View view){

        Intent intent = new Intent(MainActivity.this, LookupActivity.class);


        //TODO: run ocr to get number
        EditText carPlateNumber = (EditText) findViewById(R.id.carPlateNumber);
        String num = carPlateNumber.getText().toString();

        //TODO: go to google drive to get driver info

        intent.putExtra(EXTRA_MESSAGE_CAR_PLATE_NUMBER, num);
        intent.putExtra(EXTRA_MESSAGE_CAR_DRIVER_NAME, "bat hen");
        intent.putExtra(EXTRA_MESSAGE_CAR_DRIVER_EMAIL, "anna.itin@gmail.com");
        intent.putExtra(EXTRA_MESSAGE_CAR_DRIVER_PHONE, "0545726619");

        startActivity(intent);
    }
}
