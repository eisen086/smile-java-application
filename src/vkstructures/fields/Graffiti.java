package vkstructures.fields;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class Graffiti {
    public long gid;
    public long owner_id;
    public String src;
    public String src_big;
    
    public Graffiti(String wall_image) {
        try {
            JSONObject jo = new JSONObject(wall_image);
            gid = jo.getLong("pid");
            owner_id = jo.getLong("owner_id");
            src = jo.getString("src");
            src_big = jo.getString("src_big");
        } catch (JSONException jsone) {System.out.println("wall_image");}
    }
}