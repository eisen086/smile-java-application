package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import classes.*;
import fields.*;
import org.json.me.JSONObject;
import threads.*;

/**
 *
 * @author Евгений
 */
public class JavaFXController implements Initializable {

    @FXML
    private TextArea inputText;
    @FXML
    private TextArea chatArea;
    private VKApi api = new VKApi();
    private Messager messager = new Messager(api);
    private ArrayList<Friend> friends;
    private long currentFriend;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
    }

    @FXML
    private void sendMessage(ActionEvent event) {
       String message = inputText.getText().replaceAll(" ", "%20").replaceAll("\n", "%0A");
       messager.startMessageSender(new MessageToPass(211760821, message, ""));
       chatArea.appendText(inputText.getText()+'\n');
       inputText.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            api.doLogin("your_login", "your_password");
            JSONObject jo = api.executeApiMethod("friends.get?", "fields=uid,first_name,second_name,sex,photo&order=hints");
            friends = Friend.parse(jo.toString());
            currentFriend = friends.get(0).getUid();
        } catch (Exception e) {System.out.println("just exception");}
    }

}