package il.ac.shenkar.list_view_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by raberkira on 11/12/13.
 */
public class AddNewTask extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_task);

        Button AddNote = (Button)findViewById(R.id.add_note);
        AddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Name = (EditText) findViewById(R.id.title);
                String Note_name = Name.getText().toString();
                EditText Description = (EditText) findViewById(R.id.description);
                String Note_Description = Description.getText().toString();
                ItemDetails New_Note = new ItemDetails();
                New_Note.setName(Note_name);
                New_Note.setItemDescription(Note_Description);
                note_Singleton Note = note_Singleton.getInstance(v.getContext());
                Note.add_note(New_Note);
                setContentView(R.layout.main);
            }
        });
    }
}