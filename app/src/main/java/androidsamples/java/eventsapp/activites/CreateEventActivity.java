package androidsamples.java.eventsapp.activites;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidsamples.java.eventsapp.R;

public class CreateEventActivity extends AppCompatActivity {

    private EditText etEventName;
    private EditText etEventDescription;
    private Button btnCreateEvent;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        etEventName = findViewById(R.id.et_event_name);
        etEventDescription = findViewById(R.id.et_event_description);
        btnCreateEvent = findViewById(R.id.btn_create_event);
        db = FirebaseFirestore.getInstance();

        btnCreateEvent.setOnClickListener(v -> {
            String eventName = etEventName.getText().toString();
            String eventDescription = etEventDescription.getText().toString();
            createEvent(eventName, eventDescription);
        });
    }

    private void createEvent(String name, String description) {
        Map<String, Object> event = new HashMap<>();
        event.put("name", name);
        event.put("description", description);

        db.collection("events")
                .add(event)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(CreateEventActivity.this, "Event created successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(CreateEventActivity.this, "Error creating event", Toast.LENGTH_SHORT).show());
    }
}