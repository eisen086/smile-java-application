package vkstructures.fields;

import org.json.me.*;

public abstract class WallImage {
    public long pid;
    public long owner_id;
    public String src;
    public String src_big;
    
    public WallImage(String wall_image) {
        try {
            JSONObject jo = new JSONObject(wall_image);
            pid = jo.getLong("pid");
            owner_id = jo.getLong("owner_id");
            src = jo.getString("src");
            src_big = jo.getString("src_big");
        } catch (JSONException jsone) {System.out.println("wall_image");}
    }
}