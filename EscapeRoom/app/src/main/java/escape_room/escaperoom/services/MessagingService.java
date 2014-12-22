package escape_room.escaperoom.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 21.12.2014.
 */
public class MessagingService {

    public static final int ADJUSTED_UPDATE_FLAG = 0;
    public static final int LAZER_BITSET_UPDATE = 1;
    public static final int FORM_BITSET_UPDATE = 2;

    Map<Integer,Object> messages = new HashMap<Integer, Object>();

    public void sendMessage(int id,Object data){
        messages.put(id,data);
    }

    public Object getMessage(int id){
        return messages.get(id);
    }

    public void removeMessage(Object data){
        messages.remove(data);
    }

}
