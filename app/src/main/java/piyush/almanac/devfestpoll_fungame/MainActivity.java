package piyush.almanac.devfestpoll_fungame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
  EditText name,email;
    String out;
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

        int id=0;

        sendid(id,name.getText().toString(),email.getText().toString());


        Intent g=new Intent(MainActivity.this,showid.class);
        saveemail(email.getText().toString());
        savename(name.getText().toString());
        saveid(String.valueOf(id));
        startActivity(g);
        finish();

    }

    void sendid(int id,String name, String email){

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
