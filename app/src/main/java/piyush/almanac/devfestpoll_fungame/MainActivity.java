package piyush.almanac.devfestpoll_fungame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
  EditText name,email;
    String out;
    int min = 65;
    int max = 200;
    String name1,email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
     if(!loademail().equals(NULL))
     {
         startActivity(new Intent(MainActivity.this,showid.class));
         finish();
     }

    }
    public void register(View view){
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        Random r = new Random();
        int id = r.nextInt(max - min + 1) + min;
        try {
            name1 = URLEncoder.encode(name.getText().toString(), "utf-8");
            email1 = URLEncoder.encode(email.getText().toString(), "utf-8");
        }catch (Exception e){

        }
        sendid(id,name1,email1);

        Intent g=new Intent(MainActivity.this,showid.class);
        saveemail(email.getText().toString());
        savename(name.getText().toString());
        saveid(String.valueOf(id));
        startActivity(g);
        finish();


    }


    public void sendid(int id,String name, String email) {
        try {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://myDomain.com:8888/");
            UrlEncodedFormEntity form;
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


                nameValuePairs.add(new BasicNameValuePair("name", name));
                nameValuePairs.add(new BasicNameValuePair("email", email));
                nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(id)));


                form = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
                httppost.setEntity(form);

                HttpResponse response = httpclient.execute(httppost);


            } catch (ClientProtocolException e) {
                Log.e("HTTP Post", "Protocol error = " + e.toString());
            } catch (IOException e) {
                Log.e("HTTP Post", "IO error = " + e.toString());
            }
        } catch (Exception e) {

        }
    }

    protected void saveemail(String email){
        String FILENAME1 = "auth_email.txt";
        String verifyme=email;

        try {
            FileOutputStream fos1 = getApplication().openFileOutput(FILENAME1, Context.MODE_PRIVATE);
            fos1.write(verifyme.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void savename(String name){
        String FILENAME1 = "auth_name.txt";
        String verifyme=name;

        try {
            FileOutputStream fos1 = getApplication().openFileOutput(FILENAME1, Context.MODE_PRIVATE);
            fos1.write(verifyme.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void saveid(String id){
        String FILENAME1 = "auth_id.txt";
        String verifyme=id;

        try {
            FileOutputStream fos1 = getApplication().openFileOutput(FILENAME1, Context.MODE_PRIVATE);
            fos1.write(verifyme.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String loademail() {
        String FILENAME = "auth_email.txt";

        try {
            out="";
            FileInputStream fis1 = getApplication().openFileInput(FILENAME);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(fis1));
            String sLine1 = null;

            while (((sLine1 = br1.readLine()) != null)) {
                out += sLine1;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return out;
    }

}
