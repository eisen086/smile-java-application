/*
 * Copyright 2013 Евгений Алексеев.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gui;

import java.io.IOException;
import java.util.ArrayList;

import classes.VKApi;
import org.json.me.*;
import vkstructures.MessagePassed;
import vkstructures.MessageToPass;
import java.util.concurrent.*;

// deprecated

public class Messenger {
    
    VKApi api;
    public int messagesReceived = 0;
    public ArrayList<MessagePassed> message = null;
    
    public Messenger(VKApi api) {
        this.api = api;
    }
    
    public Send get(MessageToPass message) {
            return new Send(message);
        }
    
    public void startMessageReceiver() {
        Runnable receive = new Receive();
        //Thread messageInputStream = new Thread(receive);
        ScheduledExecutorService messageReceiver = Executors.newSingleThreadScheduledExecutor();
        messageReceiver.scheduleWithFixedDelay(receive, 0, 1, TimeUnit.SECONDS);
    }
    
    public void startMessageSender(MessageToPass mtp) {
        Runnable send = new Send(mtp);
        Thread messageOutputStream = new Thread(send);
        messageOutputStream.start();
    }
    
    private class Receive implements Runnable {
        public void run() {
            try {
                    JSONObject jo = api.executeApiMethod("messages.get?", "time_offset=1");
                    System.out.println(jo.toString());
                    //message = MessagePassed.parse(jo.toString());
                    //messagesReceived = message.size();
            }   catch (JSONException ioe) {System.out.println("JSONException");}
                catch (Exception e) {System.out.println("another exception");}
        }
    }
        
    
    private class Send implements Runnable {
        
        private MessageToPass mtp;
        
        public Send(MessageToPass mtp) {
            this.mtp = mtp;
        }
        
        public void run() {
            try {
            JSONObject jo = api.executeApiMethod("messages.send?", mtp.setQuery(mtp.uid, mtp.message));
            System.out.println(jo.toString());
            } catch (JSONException jse) {System.out.println("send jse");}
              catch (IOException ioe) {System.out.println("send jioe");}
              //catch (Exception e) {System.out.println("send e");}
        }
    }
}