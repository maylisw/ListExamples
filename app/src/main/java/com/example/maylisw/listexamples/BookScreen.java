package com.example.maylisw.listexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookScreen extends AppCompatActivity {
    private String book, author;
    private int resource;
    private TextView title, description;
    private ImageView cover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_screen);
        Intent i = getIntent();
        book = i.getStringExtra("Book");
        author = i.getStringExtra("Author");
        resource = i.getIntExtra("ResourceID", 0);
        wireWidgets();
        title.setText(book);
        description.setText(author);
        cover.setImageResource(resource);
    }

    private void wireWidgets() {
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        cover = (ImageView) findViewById(R.id.book_image);
    }

}
