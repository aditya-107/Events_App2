package androidsamples.java.eventsapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidsamples.java.eventsapp.R;
import androidsamples.java.eventsapp.adapters.EventAdapter;
import androidsamples.java.eventsapp.models.Event;

public class EventsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_events);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize an empty list of events
        List<Event> eventList = new ArrayList<>();
        recyclerView.setAdapter(new EventAdapter(eventList));

        return view;
    }
}