package gui;

import classes.*;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Евгений
 * Date: 10.12.13
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class DesktopMessagerTest {
    public static void main(String args[]) {
        VKApi api = new VKApi();
        try {
            api.doLogin("your_login", "your_password");
            String response = api.executeApiMethod("wall.get?", "offset=9").toString();
            System.out.println(response);
            Messager messager = new Messager(api);
            GUIMessager gui = new GUIMessager(messager);
            gui.setVisible(true);
            gui.setSize(192, 384);
            gui.setLocation(832, 384);
            messager.start();
        } catch (Exception e) {System.out.println("just exception");}

    }
}
