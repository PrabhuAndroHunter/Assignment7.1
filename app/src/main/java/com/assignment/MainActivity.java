package com.assignment;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private Button mSearchBtn;
    private EditText mSearchTextEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        mSearchBtn = (Button) findViewById(R.id.button_activitymain_searchBtn);
        mSearchTextEt = (EditText) findViewById(R.id.editText_activitymain_url);

        // adding onclick listener to search button
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mSearchTextEt.getText().toString();
                if (url.isEmpty()) {  // check the search text is empty or not
                    // if text is empty do nothing
                } else {
                    // search search text in google search engine
                    Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                    searchIntent.putExtra(SearchManager.QUERY, url);
                    startActivity(searchIntent);
                }
            }
        });
    }
}
