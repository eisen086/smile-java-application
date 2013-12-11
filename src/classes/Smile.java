package classes;

import org.json.me.*;
import java.util.*;
import fields.*;

public class Smile {
    public static void main(String args[]) {
        VKApi api = new VKApi();
            try
            {
                api.doLogin("your_login", "your_password");
                JSONObject jo = api.executeApiMethod("friends.get?", "fields=uid,first_name,second_name,sex,photo");
                ArrayList<Friend> friends = Friend.parse(jo.toString());
                    for (int i=0; i<friends.size(); ++i)
                System.out.println(friends.get(i).toString());
            } catch (Exception e) {System.out.println("just exception");}
        //} catch (IOException ioe) {System.out.println("ioexception");}
        //catch (classes.VKException vke) {System.out.println("vkexception");}
    }
}
