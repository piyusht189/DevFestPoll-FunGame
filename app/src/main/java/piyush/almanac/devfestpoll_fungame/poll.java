package piyush.almanac.devfestpoll_fungame;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class poll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);


    }

    public void good(View view){
        sendvote("good");
        Button btn=(Button) findViewById(R.id.good);
        
        SystemClock.sleep(10000);
        startActivity(new Intent(poll.this,poll.class));
        finish();
    }
    public void bad(View view){
        sendvote("bad");
        SystemClock.sleep(10000);
        startActivity(new Intent(poll.this,poll.class));
        finish();
    }

    public void sendvote(String result){

    }
}
