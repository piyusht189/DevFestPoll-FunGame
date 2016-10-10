package piyush.almanac.devfestpoll_fungame;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class poll extends AppCompatActivity {
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        btn=(Button) findViewById(R.id.good);
        btn1=(Button) findViewById(R.id.bad);
        btn.setEnabled(true);
        btn1.setEnabled(true);
    }

    public void good(View view){
        sendvote("good");

        btn.setEnabled(false);
        SystemClock.sleep(10000);
        startActivity(new Intent(poll.this,poll.class));
        finish();
    }
    public void bad(View view){
        sendvote("bad");

        btn1.setEnabled(false);
        SystemClock.sleep(10000);
        startActivity(new Intent(poll.this,poll.class));
        finish();
    }

    public void sendvote(String result){

    }
}
