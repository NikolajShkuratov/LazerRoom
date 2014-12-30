package escape_room.escaperoom.rooms;

import android.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import escape_room.escaperoom.rooms.parent_room.Room;
import escape_room.escaperoom.services.MessagingService;

/**
 * Created by Dell on 20.12.2014.
 */
public class RoomHandler {

    public static final int LAZER_ROOM = 0;
    public static final int ADJUSTING_ROOM = 1;
    public static final int FORM_MODIFICATION_ROOM = 2;

    private FragmentManager fragmentManager;

    private int mainFrameId;

    MessagingService messagingService = new MessagingService();

    public MessagingService getMessagingService() {
        return messagingService;
    }

    public int getMainFrameId() {
        return mainFrameId;
    }

    public void setMainFrameId(int mainFrameId) {
        this.mainFrameId = mainFrameId;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    List<Room> roomStack = new ArrayList<Room>();

    public void addRoom(Room room){
        roomStack.add(room);
    }
    public void deleteRoom(int indexOfRoom){
        if ((indexOfRoom>=0)&(indexOfRoom<roomStack.size())){
            roomStack.remove(indexOfRoom);
        }
    }

    public void goToDirectRoom(int indexOfRoom){

        if (indexOfRoom<roomStack.size()){
            fragmentManager.executePendingTransactions();
            if (fragmentManager.getBackStackEntryCount()==0){
                fragmentManager.beginTransaction()
                        .add(mainFrameId, roomStack.get(0))
                        .addToBackStack(null)
                        .commit();
            }
            else {
                fragmentManager.beginTransaction()
                        .replace(mainFrameId, roomStack.get(indexOfRoom))
                        .addToBackStack(null)
                        .commit();
            }
        }
        else{
            throw new NullPointerException();
        }

    }

    public void goToPreviousRoom(){

        fragmentManager.executePendingTransactions();
        if (fragmentManager.getBackStackEntryCount()!=0){
            fragmentManager.popBackStack();
        }
        else{
            throw new NullPointerException();
        }

    }


}
