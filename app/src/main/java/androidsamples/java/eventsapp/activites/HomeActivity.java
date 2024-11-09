package androidsamples.java.eventsapp.activites;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;
import androidsamples.java.eventsapp.R;

public class HomeActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        // Add fragments to the adapter
        adapter.addFragment(new FirstFragment());
        adapter.addFragment(new SecondFragment());

        viewPager.setAdapter(adapter);
    }
}