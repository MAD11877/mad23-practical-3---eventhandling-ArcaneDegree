package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.user.name = "MAD " + getIntent().getExtras().getInt("RandomInteger");

        this.user.description = getString(R.string.user_description_textview_placeholder_text);

        this.user.followed = false;

        this.user.id = 1;

        ((TextView) findViewById(R.id.UserNameTextView)).setText(this.user.name);

        ((TextView) findViewById(R.id.UserDescriptionTextView)).setText(this.user.description);

        ((Button) findViewById(R.id.FollowButton)).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.user.followed = !MainActivity.this.user.followed;

                    if (MainActivity.this.user.followed == true)
                    {
                        ((Button) v).setText(R.string.unfollow_button_text);

                        Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ((Button) v).setText(R.string.follow_button_text);

                        Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        );

        ((Button) findViewById(R.id.MessageButton)).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MessageGroupActivity.class);

                    startActivity(intent);
                }
            }
        );
    }
}