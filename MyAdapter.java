package com.example.personal.diary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItem> listItems;
    private Context context;


    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.for_list , viewGroup , false);
       return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final ListItem listItem = listItems.get(i);

        viewHolder.textViwHead.setText(listItem.getHead());
        viewHolder.textViewDesc.setText(listItem.getDesc());

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  ListOpenActivity.header_data.setText(listItem.getHead());
              //  ListOpenActivity.description_data.setText(listItem.getDesc());
                Intent intent = new Intent(context , ListOpenActivity.class);
                intent.putExtra("heading" , listItem.getHead());
                intent.putExtra("description" , listItem.getDesc());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViwHead , textViewDesc;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDesc = (TextView)itemView.findViewById(R.id.Description);
            textViwHead = (TextView)itemView.findViewById(R.id.heading);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.Linear);

        }
    }

}
