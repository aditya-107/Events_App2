package androidsamples.java.eventsapp.activites;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // User is not logged in, redirect to LoginActivity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            // User is logged in, determine user type and redirect accordingly
            determineUserType(currentUser.getUid());
        }
    }

    private void determineUserType(String userId) {
        // Fetch user type from Firestore or your database
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(userId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                String userType = task.getResult().getString("userType");
                if (userType != null) {
                    switch (userType) {
                        case "student":
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            break;
                        case "societySecretary":
                            startActivity(new Intent(MainActivity.this, SocietySecretaryActivity.class));
                            break;
                        case "admin":
                            startActivity(new Intent(MainActivity.this, AdminDashboardActivity.class));
                            break;
                        default:
                            // Handle unknown user type
                            break;
                    }
                    finish();
                }
            } else {
                // Handle error
            }
        });
    }
}