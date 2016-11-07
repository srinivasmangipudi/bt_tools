package com.browntape.productcategorizer;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Srini on 11/5/16.
 */

public class Utils {
    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }

}
