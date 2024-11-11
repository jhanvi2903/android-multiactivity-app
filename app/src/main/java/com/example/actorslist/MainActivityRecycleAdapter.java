package com.example.actorslist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityRecycleAdapter extends RecyclerView.Adapter<MainActivityRecycleAdapter.ViewHolder>{
    Context context;
    int layout;
    String [] sections;
    int [] imageIds;
    String[] totalCompanies;
    RecyclerViewInterface recyclerViewInterface;

    public MainActivityRecycleAdapter(Context context, int layout, String [] sections, int [] imageIds, String[] totalCompanies,
                                      RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.layout = layout;
        this.sections = sections;
        this.imageIds = imageIds;
        this.totalCompanies = totalCompanies;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.actorCategoryLabel.setText(this.sections[position]);
        holder.actorCategoryicon.setImageResource(this.imageIds[position]);
        holder.totalActorsLabel.setText(this.totalCompanies[position]);
    }

    @Override
    public int getItemCount() {
        return this.sections.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and return a viewholder

        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        return new ViewHolder(view, recyclerViewInterface);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView actorCategoryLabel, totalActorsLabel;
        ImageView actorCategoryicon;
        public ViewHolder(View item, RecyclerViewInterface recyclerViewInterface){
            super(item);
            this.actorCategoryLabel = item.findViewById(R.id.ActorCategoryTextView);
            this.actorCategoryicon = item.findViewById(R.id.ActorCategoryImage);
            this.totalActorsLabel = item.findViewById(R.id.TotalActors);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    recyclerViewInterface.onItemClick(position);
                }
            });
        }
    }
}
