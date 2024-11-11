package com.example.actorslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TotalActorsActivityRecycleAdapter extends RecyclerView.Adapter<TotalActorsActivityRecycleAdapter.ViewHolder>{

    Context context;
    int layout;
    String [] actorsNames;
    int [] actorsImage;
    String[] age;
    String[] birthplace;
    RecyclerViewInterface recyclerViewInterface;

    public TotalActorsActivityRecycleAdapter(Context context, int layout, String[] actorsNames, int[] actorsImage, String[] age, String[] birthplace, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.layout = layout;
        this.actorsNames = actorsNames;
        this.actorsImage = actorsImage;
        this.age = age;
        this.birthplace = birthplace;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public TotalActorsActivityRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        return new TotalActorsActivityRecycleAdapter.ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.actorNameLabel.setText(this.actorsNames[position]);
        holder.actorImage.setImageResource(this.actorsImage[position]);
        holder.actorAge.setText(this.age[position]);
        holder.birthplace.setText(this.birthplace[position]);
    }

    @Override
    public int getItemCount() {
        return actorsNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView actorNameLabel, actorAge, birthplace,actorDetailLabel , actors ;
        ImageView actorImage;
        public ViewHolder(View item, RecyclerViewInterface recyclerViewInterface){
            super(item);
            this.actorNameLabel = item.findViewById(R.id.actorName);
            this.actorImage = item.findViewById(R.id.aImage);
            this.actorAge = item.findViewById(R.id.ageNo);
            this.birthplace = item.findViewById(R.id.place);
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
