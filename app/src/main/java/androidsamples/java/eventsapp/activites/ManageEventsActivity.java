package androidsamples.java.eventsapp.activites;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import androidsamples.java.eventsapp.R;

public class ManageEventsActivity extends AppCompatActivity {

    private ListView listViewEvents;
    private FirebaseFirestore db;
    private List<String> eventList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_events);

        listViewEvents = findViewById(R.id.list_view_events);
        db = FirebaseFirestore.getInstance();
        eventList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eventList);
        listViewEvents.setAdapter(adapter);

        loadEvents();
    }

    private void loadEvents() {
        db.collection("events")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String eventName = document.getString("name");
                            eventList.add(eventName);
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ManageEventsActivity.this, "Error getting events.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}