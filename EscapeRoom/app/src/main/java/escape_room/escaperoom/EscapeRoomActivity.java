package escape_room.escaperoom;

import android.app.Activity;
import android.os.Bundle;

import escape_room.escaperoom.rooms.RoomHandler;
import escape_room.escaperoom.rooms.adjusting_room.FormAdjustingRoom;
import escape_room.escaperoom.rooms.lazer_rooms.childs.LazerFormEditRoom;
import escape_room.escaperoom.rooms.lazer_rooms.childs.LazerInitializationRoom;
import escape_room.escaperoom.services.DataService;

/**
 * Created by Dell on 19.12.2014.
 */
public class EscapeRoomActivity extends Activity{

    RoomHandler roomHandler = new RoomHandler();
    DataService dataService = new DataService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        roomsInit();

        dataService.fileInit(this);


        roomHandler.goToDirectRoom(roomHandler.LAZER_ROOM);
    }

    private void roomsInit(){
        roomHandler.setFragmentManager(getFragmentManager());
        roomHandler.setMainFrameId(R.id.main_frame);

        LazerInitializationRoom lazerInitializationRoom = new LazerInitializationRoom();
        lazerInitializationRoom.setLayoutId(R.layout.laser_room);
        lazerInitializationRoom.setDataService(dataService);
        roomHandler.addRoom(lazerInitializationRoom);

        FormAdjustingRoom formAdjustingRoom = new FormAdjustingRoom();
        formAdjustingRoom.setLayoutId(R.layout.adjusting_room);
        formAdjustingRoom.setDataService(dataService);
        roomHandler.addRoom(formAdjustingRoom);

        LazerFormEditRoom lazerFormEditRoom = new LazerFormEditRoom();
        lazerFormEditRoom.setLayoutId(R.layout.creating_new_form_room);
        lazerFormEditRoom.setDataService(dataService);
        roomHandler.addRoom(lazerFormEditRoom);

        lazerInitializationRoom.setRoomHandler(roomHandler);

    }

    @Override
    protected void onStop() {
        super.onStop();

        dataService.saveFormsInFile();

    }

}
