package androidsamples.java.eventsapp.activites;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidsamples.java.eventsapp.R;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // User is not logged in, redirect to RegisterActivity
            Intent intent = new Intent(HomeActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        } else {
            // User is logged in, proceed with HomeActivity
            // Your existing code for HomeActivity
        }
    }
}