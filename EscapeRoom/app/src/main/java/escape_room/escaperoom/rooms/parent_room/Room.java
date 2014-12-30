package escape_room.escaperoom.rooms.parent_room;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import escape_room.escaperoom.rooms.RoomHandler;
import escape_room.escaperoom.services.DataService;

/**
 * Created by Dell on 20.12.2014.
 */
public abstract class Room extends Fragment {

    protected View thisRoom;
    protected int layoutId;
    protected static RoomHandler roomHandler;

    public static void setRoomHandler(RoomHandler roomHandler) {
        Room.roomHandler = roomHandler;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    protected DataService dataService;

    protected DataService getDataService() {
        return dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        thisRoom = inflater.inflate(layoutId,container,false);

        //onReturn();

        roomInit();

        return thisRoom;
    }

    abstract protected void roomInit();

    //abstract protected void onReturn();
}
