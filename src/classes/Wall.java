package classes;

import java.util.ArrayList;
import org.json.me.*;

public class Wall  {

    public long from_id; // кто запостил
    public long to_id; // чья стена
    public long date;
    public String text; // текст
    public long id; // id сообщения
    public String online; // online ли автор сообщения
    public long signer_id; // id юзера, который запостил сообщение от имени группы
    public long copy_owner_id; // id юзера, у чье сообщение перепостили
    public long copy_post_id; // id перепощенного сообщения
    public String copy_text; // комментарий над перепостом

    public static Wall parse(JSONObject jsono) throws JSONException {
        Wall wm = new Wall();
        wm.id = jsono.getLong("id");
        wm.from_id = jsono.getLong("from_id");
        wm.to_id = jsono.getLong("to_id");
        wm.date = jsono.getLong("date");
        wm.online = jsono.getString("online");
        wm.text = jsono.getString("text");
        if (jsono.has("signer_id"))
            wm.signer_id = jsono.getLong("signer_id");
        if (jsono.has("copy_owner_id"))
            wm.copy_owner_id = jsono.getLong("copy_owner_id");
        if (jsono.has("copy_post_id"))
            wm.copy_post_id = jsono.getLong("copy_post_id");
        if (jsono.has("copy_text"))
            wm.copy_text = jsono.getString("copy_text");
        return wm;
    }

    public static ArrayList<Wall> parse(String source) throws JSONException {

        ArrayList<Wall> result = new ArrayList<Wall>();
        JSONObject js = new JSONObject(source);
        JSONArray response = js.getJSONArray("response"); ///this throws exception

        for (int i=1; i< response.length(); i++){
            Wall wall = new Wall();
            JSONObject jsono = response.getJSONObject(i);
            wall.from_id = jsono.getLong("from_id");
            wall.id = jsono.getLong("id");
            wall.to_id = jsono.getLong("to_id");
            wall.date = jsono.getLong("date");
            wall.online = jsono.getString("online");
            wall.text = jsono.getString("text");
            if (jsono.has("signer_id"))
                wall.signer_id = jsono.getLong("signer_id");
            if (jsono.has("copy_owner_id"))
                wall.copy_owner_id = jsono.getLong("copy_owner_id");
            if (jsono.has("copy_post_id"))
                wall.copy_post_id = jsono.getLong("copy_post_id");
            if (jsono.has("copy_text"))
                wall.copy_text = jsono.getString("copy_text");

            result.add(wall);
            System.out.println(wall.toString()); // for test
        }
        return result;
    }

    public String toString() {
        return  "from_id = " + from_id + '\n' +
                "to_id = " + to_id + '\n' +
                "date = " + date + '\n' +
                "text = " + text + '\n' +
                "id = " + id + '\n' +
                "online = " + online + '\n' +
                "signer_id = " + signer_id + '\n' +
                "copy_owner_id = " + copy_owner_id + '\n' +
                "copy_post_id = " + copy_post_id + '\n' +
                "copy_text = " + copy_text + '\n';
    }
}
