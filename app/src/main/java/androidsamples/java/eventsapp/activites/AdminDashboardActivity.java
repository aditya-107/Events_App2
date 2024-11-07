package androidsamples.java.eventsapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidsamples.java.eventsapp.R;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Button btnCreateEvent = findViewById(R.id.btn_create_event);
        Button btnManageEvents = findViewById(R.id.btn_manage_events);

        btnCreateEvent.setOnClickListener(v -> {
            Toast.makeText(AdminDashboardActivity.this, "Create Event", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AdminDashboardActivity.this, CreateEventActivity.class);
            startActivity(intent);
        });

        btnManageEvents.setOnClickListener(v -> {
            Toast.makeText(AdminDashboardActivity.this, "Manage Events", Toast.LENGTH_SHORT).show();
            // Implement navigation to manage events screen if needed
        });
    }
}