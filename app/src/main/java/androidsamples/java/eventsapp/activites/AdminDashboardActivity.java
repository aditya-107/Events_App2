package androidsamples.java.eventsapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import androidsamples.java.eventsapp.R;

public class AdminDashboardActivity extends AppCompatActivity {

    private Button btnCreateEvent;
    private Button btnManageEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        btnCreateEvent = findViewById(R.id.btn_create_event);
        btnManageEvents = findViewById(R.id.btn_manage_events);

        btnCreateEvent.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, CreateEventActivity.class);
            startActivity(intent);
        });

        btnManageEvents.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, ManageEventsActivity.class);
            startActivity(intent);
        });
    }
}