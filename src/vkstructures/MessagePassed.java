
package vkstructures;

import java.util.ArrayList;
import vkstructures.fields.*;
import java.util.Date;
import org.json.me.*;

public class MessagePassed {
    
    long mid; //
    long uid; //
    Date date; //
    int read_state; //
    int out; //
    String title; //
    String body; //
    ArrayList<Attachment> attachments;
    ArrayList<MessagePassed> fwd_messages;
    long chat_id;
    long chat_active;
    int users_count;
    long admin_id;
    boolean deleted; //
    boolean emoji; //
    
    public static MessagePassed parse(JSONObject jsono) throws JSONException {
        MessagePassed message = new MessagePassed();
        if (jsono.has("mid"))
            message.mid = jsono.getLong("mid");
        else message.mid = -1;
        message.uid = jsono.getLong("uid");
        message.date = new Date(jsono.getLong("date"));
        if (jsono.has("read_state"))
            message.read_state = jsono.getInt("read_state");
        else message.read_state = -1;
        if (jsono.has("out")) // 0 - recieved, 1 - sent
            message.out = jsono.getInt("out");
        else message.out = -1;
        message.title = jsono.getString("title");
        message.body = jsono.getString("body");
        if (jsono.has("deleted"))
            message.deleted = true;
        else message.deleted = false;
        if (jsono.has("emoji"))
            message.emoji = true;
        else message.emoji = false;
        System.out.println(message.toString());
        return message;
    }
    
    public static ArrayList<MessagePassed> parse(String source) throws JSONException {
        
        StringBuilder sb = new StringBuilder(source);
        int squareBracket = sb.indexOf("[");
        int closingSquareBracket = sb.indexOf("]");
        int curvyBracket = sb.indexOf("{", 2);
        if (curvyBracket>0)
            sb.delete(squareBracket+1, curvyBracket);
        else  { 
            sb.delete(squareBracket+1, closingSquareBracket); // лишнее
            return null;
        }
        source = sb.toString();
        System.out.println(source);
        ArrayList<MessagePassed> result = new ArrayList<MessagePassed>();
        JSONObject js = new JSONObject(source);
        JSONArray response = js.getJSONArray("response"); //this throws exception
        System.out.println(response.length());
        
        for (int i=0; i<response.length(); i++) {
            result.add(MessagePassed.parse(response.getJSONObject(i)));
        }
        return result;
    }
    
    public String toString() {
        return  "mid = " + mid + '\n' + 
                "uid = " + uid + '\n' +
                "date = " + date + '\n' +
                "read_state = " + read_state + '\n' +
                "out = " + out + '\n' +
                "title = " + title + '\n' +
                "body = " + body + '\n' +
                "deleted = " + deleted + '\n' +
                "emoji = " + emoji + '\n';
    }
            
}