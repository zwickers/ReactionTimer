package justinzwick.reactiontimer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class WaitActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private int secondsWaiting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.redLayout);
        secondsWaiting = (int) (3 + (4 * Math.random())); //generates random integer between 3 and 6

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Green "click me now!" activity */
                Intent mainIntent = new Intent(WaitActivity.this,ClickActivity.class);
                WaitActivity.this.startActivity(mainIntent);
                WaitActivity.this.finish();
            }
        }, secondsWaiting * 1000);   //starts the next Activity after
                                    //secondsWaiting * 1000 milliseconds,
    }                              //where secondsWaiting is a random integer between 3 and 6

}
