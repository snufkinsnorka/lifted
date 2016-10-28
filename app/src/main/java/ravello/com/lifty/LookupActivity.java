package ravello.com.lifty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    public void emailOnClick(View view) {
        Intent oldIntent = getIntent();
        String email = oldIntent.getStringExtra(MainActivity.EXTRA_MESSAGE_CAR_DRIVER_EMAIL);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "Your car was lifted me");
        i.putExtra(Intent.EXTRA_TEXT   , "");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(LookupActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void callOnClick(View view) {
        Intent oldIntent = getIntent();
        String email = oldIntent.getStringExtra(MainActivity.EXTRA_MESSAGE_CAR_DRIVER_EMAIL);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "Your car was lifted me");
        i.putExtra(Intent.EXTRA_TEXT   , "");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(LookupActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void smsOnClick(View view) {
        Intent oldIntent = getIntent();
        String email = oldIntent.getStringExtra(MainActivity.EXTRA_MESSAGE_CAR_DRIVER_EMAIL);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "Your car was lifted me");
        i.putExtra(Intent.EXTRA_TEXT   , "");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(LookupActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
