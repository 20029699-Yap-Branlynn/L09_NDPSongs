package sg.edu.rp.c346.id20029699.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    Button showstarBtn;
    ListView lv;
    ArrayAdapter<Song> aa;
    ArrayList<Song> al;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        showstarBtn = findViewById(R.id.starbutton);
        lv = findViewById(R.id.list);
        spinner = findViewById(R.id.spinner);

        DBHelper db = new DBHelper(ShowActivity.this);
        al = db.getAllSongs();
        aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);


        showstarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.clear();
                DBHelper db = new DBHelper(ShowActivity.this);
                al.addAll(db.get5stars(5));
                aa.notifyDataSetChanged();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                DBHelper db = new DBHelper(ShowActivity.this);
                switch (i){
                    case 0:
                        al.clear();
                        al.addAll(db.getYears(1998));
                        aa.notifyDataSetChanged();
                        break;
                    case 1:
                        al.clear();
                        al.addAll(db.getYears(2002));
                        aa.notifyDataSetChanged();
                        break;
                    case 2:
                        al.clear();
                        al.addAll(db.getYears(2015));
                        aa.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    };

}