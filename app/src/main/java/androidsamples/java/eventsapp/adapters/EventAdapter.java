package androidsamples.java.eventsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidsamples.java.eventsapp.R;
import androidsamples.java.eventsapp.activites.EventDetailActivity;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.btnViewDetails.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, EventDetailActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 10; // Sample data count
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        Button btnViewDetails;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);
            btnViewDetails = itemView.findViewById(R.id.btn_view_details);
        }
    }
}