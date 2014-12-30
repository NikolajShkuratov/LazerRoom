package escape_room.escaperoom.rooms.adjusting_room;

import android.view.View;

import escape_room.escaperoom.R;
import escape_room.escaperoom.rooms.parent_room.Room;
import escape_room.escaperoom.services.MyBitSet;

/**
 * Created by Dell on 20.12.2014.
 */
public class FormAdjustingRoom extends Room {

    public static final int FORM1_MODIFICATION = 0;
    public static final int FORM2_MODIFICATION = 1;
    public static final int FORM3_MODIFICATION = 2;


    protected boolean isReturned = false;

    @Override
    protected void roomInit() {

        thisRoom.findViewById(R.id.adjustingBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomHandler.goToPreviousRoom();
            }
        });

        thisRoom.findViewById(R.id.editForm1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.startModification().setRoomNumber(FORM1_MODIFICATION);
                roomHandler.goToDirectRoom(roomHandler.FORM_MODIFICATION_ROOM);
            }
        });

        thisRoom.findViewById(R.id.editForm2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.startModification().setRoomNumber(FORM2_MODIFICATION);
                roomHandler.goToDirectRoom(roomHandler.FORM_MODIFICATION_ROOM);            }
        });

        thisRoom.findViewById(R.id.editForm3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.startModification().setRoomNumber(FORM3_MODIFICATION);
                roomHandler.goToDirectRoom(roomHandler.FORM_MODIFICATION_ROOM);
            }
        });
    }

    /*@Override
    protected void onReturn() {

        if (isReturned){

            MyBitSet formEdition = (MyBitSet)roomHandler.getMessagingService().getMessage(
                    roomHandler.getMessagingService().LAZER_BITSET_UPDATE);

            if (formEdition!=null){

                roomHandler.getMessagingService().sendMessage(roomNumberIsEdited,formEdition);
                roomHandler.getMessagingService().removeMessage(formEdition);

            }

        }

    }*/

    @Override
    public void onResume() {
        super.onResume();

        dataService.stopModification();

    }
}
