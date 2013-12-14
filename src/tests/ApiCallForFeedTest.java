package tests;

import org.json.me.JSONObject;
import vkstructures.*;
import classes.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Евгений
 * Date: 14.12.13
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public class ApiCallForFeedTest {

    public static void main(String args[]) throws Exception {
        VKApi api = new VKApi();
        api.logIn("your_login", "your_password");
        JSONObject jo = api.executeApiMethod("wall.get?", "");
        ArrayList<Wall> feed = Wall.parse(jo.toString());
        System.out.println(feed.toString());
    }
}