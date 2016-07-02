package justinzwick.reactiontimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

public class ResultsActivity extends AppCompatActivity {

    private static final String ELAPSED_TIME_KEY = "elapsed time key";
    private RelativeLayout mRelativeLayout;
    private TextView mMillisecondTextView, mAverageMillisecondsLabel, mAttemptsLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.resultsLayout);
        mMillisecondTextView = (TextView) findViewById(R.id.millisecondTextView);
        mAverageMillisecondsLabel = (TextView) findViewById(R.id.averageMilliseconds);
        mAttemptsLabel = (TextView) findViewById(R.id.attemptsLabel);

        Intent pastIntent = getIntent();
        long milliseconds = pastIntent.getLongExtra(ELAPSED_TIME_KEY,0);

        //divides total time by attempts to get average time
        int attempts = Prefs.getInt(StartingActivity.ATTEMPTS_KEY,0);
        int totalTime = (int) Prefs.getLong(StartingActivity.TOTAL_TIME_KEY,0);
        int averageTime = (int) totalTime/attempts;

        mMillisecondTextView.setText(milliseconds + " milliseconds");

        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultsActivity.this, WaitActivity.class);
                startActivity(intent);
            }
        });

    }
}
