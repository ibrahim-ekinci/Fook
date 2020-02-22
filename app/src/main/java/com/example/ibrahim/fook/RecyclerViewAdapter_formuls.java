package com.example.ibrahim.fook;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter_formuls extends RecyclerView.Adapter<RecyclerViewAdapter_formuls.MyViewHolder> {

    Context mContext;
    List<user_formul> mData;
    Dialog myDialog;

    public RecyclerViewAdapter_formuls(Context mContext, List<user_formul> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v ;
        v=LayoutInflater.from(mContext).inflate(R.layout.item_user_formuls,viewGroup,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        // Dialog ini

        myDialog=new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_formul);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        vHolder.item_formul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_name_tv=myDialog.findViewById(R.id.dialog_fName_id);
                TextView dialog_formul_tv=myDialog.findViewById(R.id.dialog_formul_id);
                ImageView dialog_formul_img=myDialog.findViewById(R.id.dialog_img_id);
                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_formul_tv.setText(mData.get(vHolder.getAdapterPosition()).getFormul());
                dialog_formul_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
                myDialog.show();


                Toast.makeText(mContext,"Test click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {



        myViewHolder.tv_name.setText(mData.get(i).getName());
        myViewHolder.tv_formul.setText(mData.get(i).getFormul());
        myViewHolder.img.setImageResource(mData.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        private LinearLayout item_formul;
        private TextView tv_name;
        private TextView tv_formul;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_formul =itemView.findViewById(R.id.formnul_item_id);
            tv_name=itemView.findViewById(R.id.formul_name_id);
            tv_formul=itemView.findViewById(R.id.formul_id);
            img=itemView.findViewById(R.id.img_formul_id);


        }
    }
}
