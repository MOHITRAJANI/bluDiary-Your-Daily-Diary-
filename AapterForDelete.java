package com.example.personal.diary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AapterForDelete extends RecyclerView.Adapter<AapterForDelete.ViewHolder> {


    List<ListItem> listItems;
    private Context context;
    public AapterForDelete(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.for_delete_list , viewGroup , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AapterForDelete.ViewHolder viewHolder, int i) {
        final ListItem listItem = listItems.get(i);

        viewHolder.textViwHead.setText(listItem.getHead());
        viewHolder.textViewDesc.setText(listItem.getDesc());

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  ListOpenActivity.header_data.setText(listItem.getHead());
                //  ListOpenActivity.description_data.setText(listItem.getDesc());

                DeleteActivity.deletebutton.setVisibility(View.VISIBLE);
                DeleteActivity.deletebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // boolean res = FunctionActivity.myDb.deleteEntry(listItem.getHead());
                      //  if (res ==true){
                            Intent intent = new Intent(context ,DeleteActivity.class);
                            context.startActivity(intent);
                    //    }
                     //   else
                     //       Log.d("INSIDE" , "ERROR IN AAPter for delete");
                    }
                });

                    //Toast.makeText(AapterForDelete.this , "Deleted Successfully" , Toast.LENGTH_SHORT).show();
              //  Intent intent = new Intent(context ,DeleteActivity.class);
              //  intent.putExtra("heading" , listItem.getHead());
              //  intent.putExtra("description" , listItem.getDesc());
                //context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
       return listItems.size();
    }

    public void whenClicked(View view) {
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViwHead , textViewDesc;
        RadioButton r1;
        public RelativeLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            r1 = (RadioButton)itemView.findViewById(R.id.rad1);
            textViewDesc = (TextView)itemView.findViewById(R.id.Description);
            textViwHead = (TextView)itemView.findViewById(R.id.heading);
            linearLayout = (RelativeLayout)itemView.findViewById(R.id.Linear);
            r1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DeleteActivity.deletebutton.setVisibility(View.VISIBLE);

                }
            });

        }
    }

}
