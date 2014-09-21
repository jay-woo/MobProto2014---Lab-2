package lab2.jwoo.lab2;

import android.content.Context;
import android.view.View;

/**
 * Created by wooj on 9/14/14.
 */
public class ChatItem {
    private String username;
    private String chat;
    private String time;

    public ChatItem(String username, String chat, String time) {
        this.username = username;
        this.chat = chat;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public String getChat() {
        return chat;
    }

    public String getTime() {
        return time;
    }
}
