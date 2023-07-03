package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroupActivity extends AppCompatActivity {
    private Button group1Button = null;

    private Button group2Button = null;

    private MessageGroupFragment mainMessageGroupFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message_group);

        this.group1Button = this.findViewById(R.id.Group1Button);

        this.group1Button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MessageGroupActivity.this.mainMessageGroupFragment.updateCurrentlySelectedMessageGroup(
                        MessageGroupFragment.MessageGroups.GROUP_1
                    );
                }
            }
        );

        this.group2Button = this.findViewById(R.id.Group2Button);

        this.group2Button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MessageGroupActivity.this.mainMessageGroupFragment.updateCurrentlySelectedMessageGroup(
                        MessageGroupFragment.MessageGroups.GROUP_2
                    );
                }
            }
        );

        this.mainMessageGroupFragment = (MessageGroupFragment) this.getSupportFragmentManager().findFragmentById(
            R.id.MainMessageGroupFragment
        );
    }
}