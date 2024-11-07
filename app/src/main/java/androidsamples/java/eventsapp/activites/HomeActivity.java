package androidsamples.java.eventsapp.activites;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import androidsamples.java.eventapp.R;
import androidsamples.java.eventapp.adapters.EventAdapter;
import androidsamples.java.eventapp.models.Event;

public class HomeActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<>();
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        fetchEvents();
    }

    private void fetchEvents() {
        db.collection("events").get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Event event = document.toObject(Event.class);
                            eventList.add(event);
                        }
                        eventAdapter.notifyDataSetChanged();
                    } else {
                        Log.w("HomeActivity", "Error getting documents.", task.getException());
                    }
                });
    }
}