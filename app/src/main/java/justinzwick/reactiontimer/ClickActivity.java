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

        final long currentTime = System.currentTimeMillis();
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ClickActivity.this, ResultsActivity.class);

                startActivity(intent);
            }
        });
    }

    private long countTime(long startTime) { //returns the elapsed time, which is endTime - startTime
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
