package il.ac.shenkar.list_view_demo;


import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by tomerweller on 10/21/13.
 */
public class ItemListBaseAdapter extends BaseAdapter {
    private static ArrayList<ItemDetails> itemDetailsrrayList;

    private Integer[] imgid = {
            R.drawable.p1,
            R.drawable.bb2,
            R.drawable.p2,
            R.drawable.bb5,
            R.drawable.bb6,
            R.drawable.d1
    };

    private LayoutInflater l_Inflater;

    public ItemListBaseAdapter(Context context, ArrayList<ItemDetails> results) {
        itemDetailsrrayList = results;
        l_Inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return itemDetailsrrayList.size();
    }

    public Object getItem(int position) {
        return itemDetailsrrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    private final View.OnClickListener doneButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            ItemDetails NoteDetails = new ItemDetails();
            NoteDetails = note_Singleton.getInstance(v.getContext()).findTaskByPosition(position);
            note_Singleton.getInstance(v.getContext()).Delete_Note(NoteDetails);
            notifyDataSetChanged();
        }
    };

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.item_details_view, null);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.name);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.itemDescription);
            holder.dButton = (Button) convertView.findViewById(R.id.doneButton);
            holder.dButton.setOnClickListener(doneButtonOnClickListener);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(itemDetailsrrayList.get(position).getName());
        holder.tvDescription.setText(itemDetailsrrayList.get(position).getItemDescription());

        Button doneBtn = (Button)convertView.findViewById(R.id.doneButton);
        doneBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
        return convertView;
    }

    private static class ViewHolder {
        TextView tvName;
        TextView tvDescription;
        Button dButton;
    }
}