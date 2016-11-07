package com.browntape.productcategorizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("Users");
//    //String userId = "";

    private RecyclerView recyclerview;
    private FirebaseDatabase mDatabase;
    private static final String TAG = "Mains";
    private Map<String, Object> mCategoryMap;
    private List<ExpandableListAdapter.Item> mCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //FirebaseApp.getDefaultConfig().setPersistenceEnabled(true);
        mCategoryList = new ArrayList<>();

        mDatabase = Utils.getDatabase();

        Intent intent = getIntent();
        final String userid = intent.getStringExtra("userid"); //if it's a string you stored.
        final String username = intent.getStringExtra("username");
        final String email = intent.getStringExtra("email");
        //final String photourl = intent.getStringExtra("photourl");

        writeNewUser(userid, username, email);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, username, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //dummy_data();
        populateCategoryTree();
    }

    private void dummy_data()
    {
        List<ExpandableListAdapter.Item> data = new ArrayList<>();

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Fruits"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Apple"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Orange"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Banana"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Cars"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "BMW"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac"));

        ExpandableListAdapter.Item places = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Places");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra"));

        data.add(places);

        recyclerview.setAdapter(new ExpandableListAdapter(data));
    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User(userId, name, email);

        //myRef.child(userId).setValue(user);

        mDatabase.getReference().child("users").child(userId).setValue(user);
    }

    private void populateCategoryTree()
    {
        Query mProductCatTree = mDatabase.getReference().child("product_categories").orderByKey();

        mProductCatTree.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get product categories object and use the values to update the UI
                //ProductCategory pc = dataSnapshot.getValue(ProductCategory.class);
                mCategoryMap = (HashMap<String, Object>) dataSnapshot.getValue();
                // ...
                //Log.w(TAG, mCategoryMap.toString());
                Iterator it = mCategoryMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    //Log.w(TAG, pair.getKey() + " = " + pair.getValue());
                    //System.out.println(pair.getKey() + " = " + pair.getValue());
                    HashMap obj = (HashMap)pair.getValue();
                    String title = (String)obj.get("title");
                    HashMap subcats = (HashMap)obj.get("sub_cats");
                    Iterator sc = subcats.entrySet().iterator();

                    Log.w(TAG+"-c-", title);

                    ExpandableListAdapter.Item rootCat = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, title);
                    rootCat.invisibleChildren = new ArrayList<>();
                    //loop through the sub categories
                    while (sc.hasNext()) {
                        Map.Entry spair = (Map.Entry)sc.next();
                        HashMap sobj = (HashMap)spair.getValue();
                        String stitle = (String)sobj.get("title");
                        Log.w(TAG + "---sc-", stitle);

                        rootCat.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, stitle));
                        sc.remove();
                    }

                    mCategoryList.add(rootCat);
                    it.remove(); // avoids a ConcurrentModificationException
                }
                recyclerview.setAdapter(new ExpandableListAdapter(mCategoryList));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });



    }
}
