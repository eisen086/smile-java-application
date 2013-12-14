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

package vkstructures;

import java.util.ArrayList;
import vkstructures.fields.*;

public class MessageToPass {
    public long uid;
    long chat_id;
    public String message;
    ArrayList<Attachment> attachments;
    long[] forward_messages;
    String title;
    boolean type;
    long longitude;
    String guid;
    
    public MessageToPass(long uid, String message, String title) {
        this.uid = uid;
        this.message = message;
        this.title = title;
    }
    
    public String setQuery(long uid, String message) {
        return "uid=" + String.valueOf(uid) + '&' +
                "message=" + message;
    }
}