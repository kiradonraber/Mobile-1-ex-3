package il.ac.shenkar.list_view_demo;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by raberkira on 11/13/13.
 */
public class note_Singleton {
    private static note_Singleton instance = null;
    private List<ItemDetails> NoteList;
    private Context context;

    private note_Singleton(Context context) {
        this.context = context;
        NoteList = new ArrayList<ItemDetails> ();
    }

    public static note_Singleton getInstance(Context context) {
        if(instance == null) {
            instance = new note_Singleton(context.getApplicationContext());
        }
        return instance;
    }

    public void add_note (ItemDetails NewNote){
        NoteList.add(NewNote);
    }

    public void Delete_Note (ItemDetails NoteToDelete){
        NoteList.remove(NoteToDelete);
    }

    public ArrayList<ItemDetails> getItems() {
        return (ArrayList<ItemDetails>) NoteList;
    }

    public ItemDetails findTaskByPosition(int position){
        return NoteList.get(position);
    }
}