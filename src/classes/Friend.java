package classes;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Евгений
 * Date: 11.12.13
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
public class Friend {
    private long uid;
    private String first_name;
    private String last_name;
    private int sex;
    private String photo;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public static Friend parse(JSONObject jsono) throws JSONException {
        Friend friend = new Friend();
        friend.uid = jsono.getLong("uid");
        friend.first_name = jsono.getString("first_name");
        friend.last_name = jsono.getString("last_name");
        friend.sex = jsono.getInt("sex");
        friend.photo = jsono.getString("photo");
        return friend;
    }

    public static ArrayList<Friend> parse(String source) throws JSONException {

        ArrayList<Friend> result = new ArrayList<Friend>();
        JSONObject js = new JSONObject(source);
        JSONArray response = js.getJSONArray("response"); ///this throws exception

        for (int i=1; i< response.length(); i++){
            result.add(parse((JSONObject)response.get(i)));
        }
        return result;
    }

    public String toString() {
        return  "uid = " + uid + '\n' +
                "first_name = " + first_name + '\n' +
                "last_name = " + last_name + '\n' +
                "sex = " + sex + '\n' +
                "photo = " + photo + '\n';
    }
}
