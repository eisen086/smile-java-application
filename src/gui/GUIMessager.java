/*
 * Copyright 2013 Евгений.
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import threads.*;
import classes.*;
import java.util.concurrent.*;

public class GUIMessager extends JFrame {
    JPanel panel;
    JTextArea messages;
    JTextArea messagesToSend;
    JButton commit;
    
    
    public GUIMessager(Messager messager) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        messages = new JTextArea();
        messagesToSend = new JTextArea();
        commit = new JButton("commit");
        commit.addMouseListener(new SendMessageListener(messager));
        panel.add(messages);
        panel.add(messagesToSend);
        panel.add(commit);
        add(panel);
    }
    
    private class ReceiveMessageListener implements ActionListener {
        private Messager messager;
        
        public ReceiveMessageListener(Messager messager) {
            this.messager = messager;
        }
        
        public void actionPerformed(ActionEvent event) {
            if (messager.messagesReceived != 0)
                messages.setText(messager.toString());
                
        }
    }
    
    private class SendMessageListener extends MouseAdapter {
        private Messager messager;
        
        public SendMessageListener(Messager messager) {
            this.messager = messager;
        }
        
        public void mousePressed(MouseEvent event) {
            MessageToPass mtp = new MessageToPass(211760821, messagesToSend.getText().replace(" ", "%20"), "title");
            messagesToSend.setText("");
            Runnable mtpRunnable = messager.get(mtp);
            Thread mtpThread = new Thread(mtpRunnable);
            mtpThread.start();
            //ExecutorService mtpStream = Executors.newSingleThreadExecutor();
            //mtpStream.submit(mtpThread);
        }
    }
}