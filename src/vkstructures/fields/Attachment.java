package vkstructures.fields;
import org.json.me.*;

public class Attachment {
    public Photo photo;
    public PostedPhoto posted_photo;
    public Link link;
    public App app;
    public Attachment(String attachment) {
        try {
        JSONObject jo = new JSONObject(attachment);
        photo = new Photo(jo.getString("photo"));
        posted_photo = new PostedPhoto(jo.getString("posted_photo"));
        } catch (JSONException jsone) {System.out.println("attachment");}
    }
}