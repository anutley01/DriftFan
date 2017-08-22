package com.example.aids.a09application;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

public class HotelsGenerator extends Activity {}/*
SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_accommodation_eateries);
        sqlHelper = new SQLHelper(this);
        sqlHelper.getAllHotels();

    }


    public void DisplayAll(){
    Cursor res = sqlHelper.getAllHotels();
                    if (res.getCount() == 0){
        //show message
        return;
    }

    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()){
        buffer.append("Hotel ID: " +res.getString(0) + "\n");
        buffer.append("Hotel Name: " +res.getString(1) + "\n");
        buffer.append("Hotel Phone: " +res.getString(2) + "\n");
        buffer.append("Latitude: " +res.getString(3) + "\n");
        buffer.append("Longitude: " +res.getString(4) + "\n");
        buffer.append("Price " +res.getString(5) + "\n");
        buffer.append("Near to: " +res.getString(6) + "\n");
    }
}




            }
   /* SQLHelper sqlHelper;
    private CommentsDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlHelper = new SQLHelper(this);
        //create new class CommentsDataSource and cast it to datasource
        datasource = new CommentsDataSource(this);
        //open the database
        datasource.open();

        //use method getAllComments() of datasource and pass the comments to values
        List<Comment> values = datasource.getAllComments();

        // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")

        //use method getListAdapter() of ArrayAdapter<Comment> class
                // to get the ListAdaptor associated with the ListView
                // ListAdaptor: Build a bridge between a ListView and the data for the list
                ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        Comment comment = null;
        switch (view.getId()) {
            case R.id.add:
                String[] comments = new String[] { "UK", "NI", "Belfast" };

                //randomly allocate a number 1-3
                //nextInt (int n): Returns a pseudo-random uniformly distributed int in the half-open range [0, n).
                int nextInt = new Random().nextInt(3);

                //Save/create the new comment to the database
                datasource.createComment(comments[nextInt]);

                //add new comment into the list
                comment=new Comment();
                comment.setComment(comments[nextInt]);
                adapter.add(comment);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    //why getItem(0) refers to 0?
                    comment = (Comment) getListAdapter().getItem(0);
                    datasource.deleteComment(comment);
                    adapter.remove(comment);
                }
                break;
        }
        //why use the following line of code - related to the list...
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
*/
