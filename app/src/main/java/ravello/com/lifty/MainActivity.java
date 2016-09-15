package ravello.com.lifty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                readData("4060270");
            }
        });
        t.start();
        try {
            t.join();
        }catch (InterruptedException e){

        }

        //TODO: go to google drive to get driver info

        intent.putExtra(EXTRA_MESSAGE_CAR_PLATE_NUMBER, num);
        intent.putExtra(EXTRA_MESSAGE_CAR_DRIVER_NAME, "bat hen");
        intent.putExtra(EXTRA_MESSAGE_CAR_DRIVER_EMAIL, "anna.itin@gmail.com");
        intent.putExtra(EXTRA_MESSAGE_CAR_DRIVER_PHONE, "0545726619");

        startActivity(intent);
    }


    public class UserData{
        private String firstName;
        private String lastName;
        private String email;

        public UserData(String firstName, String lastNAme, String email){
            this.firstName = firstName;
            this.lastName = lastNAme;
            this.email = email;
        }
    }

    private UserData readData(String hashCarNumber){

        //https://docs.google.com/spreadsheets/d/1Q96-Z-t539AuYKADBphe8aNdcjVBBTMliPO8anhaJHU/edit?usp=sharing

        SpreadsheetService service = new SpreadsheetService("ravello.com.lifty");

        try {
            service.setUserCredentials("anna.itin@gmail.com", "Itin30041986");
            // Notice that the url ends
            // with default/public/values.
            // That wasn't obvious (at least to me)
            // from the documentation.
            String urlString = "https://spreadsheets.google.com/feeds/list/1Q96-Z-t539AuYKADBphe8aNdcjVBBTMliPO8anhaJHU/default/public/values";
                   // "https://docs.google.com/feeds/list/1Q96-Z-t539AuYKADBphe8aNdcjVBBTMliPO8anhaJHU/default/public/values";
                    //"https://spreadsheets.google.com/feeds/list/0AsaDhyyXNaFSdDJ2VUxtVGVWN1Yza1loU1RPVVU3OFE/default/public/values";

            // turn the string into a URL
            URL url = new URL(urlString);

            // You could substitute a cell feed here in place of
            // the list feed
            ListFeed feed = service.getFeed(url, ListFeed.class);

            for (ListEntry entry : feed.getEntries()) {
                CustomElementCollection elements = entry.getCustomElements();
                String name = elements.getValue("name");
                System.out.println(name);
                String number = elements.getValue("Number");
                System.out.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }catch(Exception e2){
            e2.printStackTrace();
        }
        return null;
    }
}
