package ravello.com.lifty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class LookupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup);

        Intent intent = getIntent();

        String carDriverName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_CAR_DRIVER_NAME);
        TextView driverNameTV = (TextView) findViewById(R.id.driverName);
        driverNameTV.setTextSize(40);
        driverNameTV.setText(carDriverName);

        String carNumberPlate = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_CAR_PLATE_NUMBER);
        TextView textView = (TextView) findViewById(R.id.carPlateNumberResolved);
        textView.setTextSize(40);
        textView.setText(carNumberPlate);


    }


}
