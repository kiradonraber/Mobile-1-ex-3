package il.ac.shenkar.list_view_demo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;

public class ListViewImagesActivity extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

       Button addBtn = (Button)findViewById(R.id.add);
       addBtn.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
              Intent intent = new Intent(getBaseContext(), AddNewTask.class);
              startActivity(intent);
          }
        });

        note_Singleton Notes = note_Singleton.getInstance(this);
        final ListView listView = (ListView) findViewById(R.id.listV_main);

        listView.setAdapter(new ItemListBaseAdapter(this, Notes.getItems()));
        ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
    }
}