package com.example.maylisw.listexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {
    private ArrayList<Books> booksToRead;
    private ListView listOfBooks;
    private MenuItem deleteMe;
    private ArrayAdapter<Books> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booksToRead = new ArrayList<>();
        wireWidgets();
        createBooks();
        adapter = new ArrayAdapter<Books>(this, android.R.layout.simple_list_item_1, booksToRead);
        listOfBooks.setAdapter(adapter);
        listOfBooks.setOnItemClickListener(this);
        registerForContextMenu(listOfBooks);
    }

    private void createBooks() {
        booksToRead.add(new Books("Les Miserables", "Victor Hugo", R.drawable.lesmise));
        booksToRead.add(new Books("The Count of Monte Cristo", "Alexander Dumas", R.drawable.countofmontecristo));
        booksToRead.add(new Books("The Three Musketeers", "Alexander Dumas", R.drawable.threemusketeers));
        booksToRead.add(new Books("Anna Karenina", "Leo Tolstoy", R.drawable.annakarenia));
        booksToRead.add(new Books("War and Peace", "Leo Tolstoy", R.drawable.warandpeace));
    }

    private void wireWidgets() {
        listOfBooks = (ListView) findViewById(R.id.list_of_books);
        deleteMe = (MenuItem) findViewById(R.id.delete_item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, booksToRead.get(i).getName(), Toast.LENGTH_SHORT);
        Intent s = new Intent(this, BookScreen.class);
        s.putExtra("Book", booksToRead.get(i).getName());
        s.putExtra("Author", booksToRead.get(i).getAuthor());
        s.putExtra("ResourceID", booksToRead.get(i).getResourceID());
        startActivity(s);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete_item:
                booksToRead.remove((int) info.id);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
