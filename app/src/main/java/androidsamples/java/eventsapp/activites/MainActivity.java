package androidsamples.java.eventsapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidsamples.java.eventsapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example buttons for navigation
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnAdminDashboard = findViewById(R.id.btn_admin_dashboard);

        btnLogin.setOnClickListener(v -> {
            // Implement login logic here
            // For now, navigate to a placeholder activity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btnAdminDashboard.setOnClickListener(v -> {
            // Navigate to Admin Dashboard
            Intent intent = new Intent(MainActivity.this, AdminDashboardActivity.class);
            startActivity(intent);
        });
    }
}