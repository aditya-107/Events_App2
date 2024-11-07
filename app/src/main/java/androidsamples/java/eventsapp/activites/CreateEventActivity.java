package androidsamples.java.eventsapp.activites;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import androidsamples.java.eventapp.R;
import androidsamples.java.eventapp.models.Event;

public class CreateEventActivity extends AppCompatActivity {

    private static final String TAG = "CreateEventActivity";
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        db = FirebaseFirestore.getInstance();

        EditText etEventName = findViewById(R.id.et_event_name);
        EditText etEventDescription = findViewById(R.id.et_event_description);
        Button btnSaveEvent = findViewById(R.id.btn_save_event);

        btnSaveEvent.setOnClickListener(v -> {
            String eventName = etEventName.getText().toString();
            String eventDescription = etEventDescription.getText().toString();
            saveEvent(eventName, eventDescription);
        });
    }

    private void saveEvent(String eventName, String eventDescription) {
        Event event = new Event(eventName, eventDescription, "2023-10-10");
        db.collection("events").add(event)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
    }
}