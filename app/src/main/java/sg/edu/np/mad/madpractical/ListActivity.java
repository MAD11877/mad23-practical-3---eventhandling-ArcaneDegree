package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TimeUtils;
import android.view.View;
import android.widget.ImageView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private AlertDialog.Builder alertDialogBuilder = null;

    private AlertDialog alertDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        this.alertDialogBuilder = new AlertDialog.Builder(this);

        this.alertDialogBuilder.setNegativeButton(
            "CLOSE",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ListActivity.this.alertDialog.hide();
                }
            }
        );

        this.alertDialogBuilder.setPositiveButton(
            "VIEW",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Random random = new Random();

                    random.setSeed(
                        System.currentTimeMillis()
                    );

                    Intent intent = new Intent(ListActivity.this, MainActivity.class);

                    intent.putExtra("RandomInteger", random.nextInt());

                    startActivity(intent);
                }
            }
        );

        this.alertDialogBuilder.setTitle(
            "Profile"
        );

        this.alertDialogBuilder.setMessage(
            "MADness"
        );

        this.alertDialog = this.alertDialogBuilder.create();

        ((ImageView) findViewById(R.id.ListActivityImageView)).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListActivity.this.alertDialog.show();
                }
            }
        );
    }
}