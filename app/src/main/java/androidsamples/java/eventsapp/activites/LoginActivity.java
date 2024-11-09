package androidsamples.java.eventsapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import androidsamples.java.eventsapp.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        etUsername = findViewById(R.id.editTextUsername);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(v -> {
            String email = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            loginUser(email, password);
        });
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            determineUserType(user.getUid());
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void determineUserType(String userId) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(userId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                String userType = task.getResult().getString("userType");
                if (userType != null) {
                    switch (userType) {
                        case "student":
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            break;
                        case "societySecretary":
                            startActivity(new Intent(LoginActivity.this, SocietySecretaryActivity.class));
                            break;
                        case "admin":
                            startActivity(new Intent(LoginActivity.this, AdminDashboardActivity.class));
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