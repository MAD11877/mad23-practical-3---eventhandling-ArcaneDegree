package sg.edu.np.mad.madpractical;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageGroupFragment extends Fragment
{
    private MessageGroups currentlySelectedMessageGroup = MessageGroups.NONE;

    private TextView messageGroupFragmentTextView = null;

    private ImageView messageGroupFragmentImageView = null;

    public MessageGroupFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_message_group, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        this.messageGroupFragmentTextView = view.findViewById(
            R.id.MessageGroupFragmentTextView
        );

        this.messageGroupFragmentImageView = view.findViewById(
            R.id.MessageGroupFragmentImageView
        );

        this.updateCurrentlySelectedMessageGroup(MessageGroups.NONE);
    }

    public void updateCurrentlySelectedMessageGroup(MessageGroups group)
    {
        this.currentlySelectedMessageGroup = group;

        switch (this.currentlySelectedMessageGroup)
        {
            case NONE:
                this.messageGroupFragmentTextView.setVisibility(
                    View.GONE
                );

                this.messageGroupFragmentImageView.setVisibility(
                    View.GONE
                );

                break;

            case GROUP_1:
                this.messageGroupFragmentTextView.setVisibility(
                    View.VISIBLE
                );

                this.messageGroupFragmentImageView.setVisibility(
                    View.GONE
                );

                break;

            case GROUP_2:
                this.messageGroupFragmentTextView.setVisibility(
                    View.GONE
                );

                this.messageGroupFragmentImageView.setVisibility(
                    View.VISIBLE
                );

                break;

            default:
                break;
        }
    }

    public enum MessageGroups
    {
        NONE,
        GROUP_1,
        GROUP_2
    }
}