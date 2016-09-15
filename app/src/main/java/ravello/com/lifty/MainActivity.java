package ravello.com.lifty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    public final static String EXTRA_MESSAGE_CAR_PLATE_NUMBER = "ravello.com.lifty.CAR_PLATE_NUMBER";


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

        startActivity(intent);
    }
}
