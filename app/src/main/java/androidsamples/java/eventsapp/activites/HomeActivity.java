// HomeActivity.java
package androidsamples.java.eventsapp.activites;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;
import androidsamples.java.eventsapp.R;
import androidsamples.java.eventsapp.adapters.EventAdapter;
import androidsamples.java.eventsapp.models.Event;

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

        // Initialize eventList with data
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);
    }
}