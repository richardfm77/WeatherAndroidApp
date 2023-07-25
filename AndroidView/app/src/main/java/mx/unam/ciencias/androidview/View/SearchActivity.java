package mx.unam.ciencias.androidview.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import mx.unam.ciencias.androidview.R;

public class SearchActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private ArrayAdapter<Adapter> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView textView = findViewById(R.id.textView2);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);

        listView.setVisibility(View.GONE);


        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.countries_array));
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                textView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                // extraer datos api y mostrarlos



                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.INVISIBLE);
                adapter.getFilter().filter(newText);

                return false;
            }
        });
    }

}