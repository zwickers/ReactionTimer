package justinzwick.reactiontimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.pixplicity.easyprefs.library.Prefs;

public class ClickActivity extends AppCompatActivity {
    private static final String ELAPSED_TIME_KEY = "elapsed time key";
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.greenLayout);

        ///-----increments the number of attempts by 1-----///
        int prevAttempts = Prefs.getInt(StartingActivity.ATTEMPTS_KEY,0);
        int currentAttempts = prevAttempts+1;
        Prefs.putInt(StartingActivity.ATTEMPTS_KEY,currentAttempts);


        final long initialTime = System.currentTimeMillis();
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long elapsedTime = ClickActivity.this.countTime(initialTime);
                Intent intent = new Intent(ClickActivity.this, ResultsActivity.class);
                intent.putExtra(ELAPSED_TIME_KEY, elapsedTime);

                long timeSoFar = Prefs.getLong(StartingActivity.TOTAL_TIME_KEY,0);
                Prefs.putLong(StartingActivity.TOTAL_TIME_KEY,timeSoFar+elapsedTime);


                startActivity(intent);
            }
        });
    }

    private long countTime(long startTime) { //returns the elapsed time, which is endTime - startTime
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
