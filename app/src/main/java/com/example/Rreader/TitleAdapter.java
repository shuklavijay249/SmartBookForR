package com.example.Rreader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Rreader.R;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {
    private Context mcontext;
    private ArrayList<String>titlelist;
    private ArrayList<String>sbtitlelist;
    private ArrayList<Integer>imgTitleList;
    private com.example.Rreader.CustomItemClickListner clickListner;
    //constructor


    public TitleAdapter(Context mcontext, ArrayList<String> titlelist, ArrayList<String> sbtitlelist, ArrayList<Integer> imgTitleList, CustomItemClickListner clickListner) {
        this.mcontext = mcontext;
        this.titlelist = titlelist;
        this.sbtitlelist = sbtitlelist;
        this.imgTitleList = imgTitleList;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {




        final View view= LayoutInflater.from(mcontext).inflate(R.layout.title_layout,parent,false);

            final MyViewHolder viewHolder=new MyViewHolder(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListner.onItemClick(view,viewHolder.getPosition());
                }
            });
            return viewHolder;



    }





    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


          holder.titletext.setText(titlelist.get(position).replace("_"," "));
           holder.sbtitletext.setText(sbtitlelist.get(position));
           holder.title_img.setImageResource(imgTitleList.get( position ));


         // holder.sbtitletext.setText(titlelist.get(position));
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }



    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titletext,sbtitletext;
        ImageView title_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //add title
            titletext=itemView.findViewById(R.id.title_txt);
          sbtitletext=itemView.findViewById(R.id.sbtitle_txt);
            title_img=itemView.findViewById(R.id.title_img);

        }
    }

}
