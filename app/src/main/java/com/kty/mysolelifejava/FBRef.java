package com.kty.mysolelifejava;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBRef {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference member = database.getReference("member");


}
