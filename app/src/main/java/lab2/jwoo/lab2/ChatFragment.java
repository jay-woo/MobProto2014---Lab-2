package lab2.jwoo.lab2;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by wooj on 9/14/14.
 */
public class ChatFragment extends Fragment {
    private ArrayList<ChatItem> chatItems;

    public ChatFragment () {
        this.chatItems = new ArrayList<ChatItem>();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final ListView myListView = (ListView) rootView.findViewById(R.id.chatbox);
        final ChatAdapter myChatAdapter = new ChatAdapter(getActivity(), this.chatItems);
        final Calendar myCalendar = Calendar.getInstance();
        myListView.setAdapter(myChatAdapter);

        Button sendButton = (Button) rootView.findViewById(R.id.sendButton);
        final EditText textBox = (EditText) rootView.findViewById(R.id.textBox);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatItems.add(new ChatItem("me", textBox.getText().toString(), myCalendar.getTime().toString()));
                myChatAdapter.notifyDataSetChanged();
                myListView.setSelection(chatItems.size() - 1);
                textBox.setText("");
            }
        });

        return rootView;
    }
}