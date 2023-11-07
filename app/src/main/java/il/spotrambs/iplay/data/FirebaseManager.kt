package il.spotrambs.iplay.data

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import il.spotrambs.iplay.data.model.FirebaseData

class FirebaseManager {
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseReference: DatabaseReference = firebaseDatabase.reference

    fun fetchDataFromFirebase(callback: (FirebaseData) -> Unit) {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val result = parseDataSnapshot(dataSnapshot)
                callback(result)
                Log.d("TAGGG", "fetchDataFromFirebase result 1")

            }

            override fun onCancelled(databaseError: DatabaseError) {
                callback(FirebaseData(true, ""))
                Log.d("TAGGG", "fetchDataFromFirebase result 2")

            }
        })
        Log.d("TAGGG", "fetchDataFromFirebase")
    }

    private fun parseDataSnapshot(dataSnapshot: DataSnapshot): FirebaseData {
        val workStatus = dataSnapshot.child("workStatus").getValue(Boolean::class.java) ?: false
        val organics = dataSnapshot.child("organics").getValue(String::class.java) ?: ""

        Log.d("TAGGG", "parseDataSnapshot")

        return FirebaseData(workStatus, organics)
    }
}