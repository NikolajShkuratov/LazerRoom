package escape_room.escaperoom.services;

import android.content.Context;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import escape_room.escaperoom.rooms.lazer_rooms.lazer_form.LazerForm;

/**
 * Created by Dell on 21.12.2014.
 */
public class DataService {

    private List<LazerForm> formSet = new ArrayList<LazerForm>();

    public List<LazerForm> getFormSet() {
        return formSet;
    }

    public DataService(){
        formSet.add(new LazerForm());
        formSet.add(new LazerForm());
        formSet.add(new LazerForm());
    }

    FormModification formModification;

    public FormModification startModification(){
        formModification = new FormModification();
        return formModification;
    }

    public void stopModification(){
        formModification=null;
    }

    public FormModification getModification (){
        return formModification;
    }

    Context context;
    public static final String FILE_NAME = "formDataFile";

    public void fileInit(Context context){
        this.context=context;
        getFormsFromFile();
    }

    public void getFormsFromFile() {
        try {
            FileInputStream reader = context.openFileInput(FILE_NAME);
            byte input[] = new byte[9];
            reader.read(input);
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    formSet.get(i).getLazerBitSet().setByte(j, input[i*3+j]);
                }
            }
            reader.close();
        }
        catch (IOException e){

        }
    }

    public void saveFormsInFile(){
        try{
            FileOutputStream writer = context.openFileOutput(FILE_NAME,context.MODE_PRIVATE);
            byte output[] = new byte[9];
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    output[i*3+j] = formSet.get(i).getLazerBitSet().getByte(j);
                }
            }
            writer.write(output);
            writer.close();
        }
        catch (IOException e){

        }
    }

    /*public void fileInit(File externalCacheDir){

        this.externalCacheDir = externalCacheDir;
        formDataFile = new File(externalCacheDir, "formDataFile.txt");
        getFormsFromFile();
    }

    public void getFormsFromFile() {
        try {
            FileInputStream reader = new FileInputStream(formDataFile);
            byte input[] = new byte[]{0,0,0};
            reader.read(input);
            for (int i=0;i<3;i++) {
                formSet.get(i).getLazerBitSet().setByte(i,input[i]);
            }
            reader.close();
        }
        catch (IOException e){

        }
    }

    public void saveFormsInFile(){
        try{
            FileOutputStream writer = new FileOutputStream(formDataFile);
            byte output[] = new byte[]{0,0,0};
            for (int i=0;i<3;i++){
                output[i] = formSet.get(i).getLazerBitSet().getByte(i);
            }
            writer.write(output);
            writer.close();
        }
        catch (IOException e){

        }
    }*/


}
