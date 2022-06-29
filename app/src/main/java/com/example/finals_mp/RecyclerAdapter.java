package com.example.finals_mp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

List<Person> list;

public RecyclerAdapter(List<Person>list){
    this.list=list;
}

  @NonNull
  @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
      MyViewHolder myViewHolder=new MyViewHolder(view);

      return myViewHolder;
  }
  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder,int position){
       holder.tvID.setText(String.valueOf(list.get(position).getId()));
       holder.tvName.setText(list.get(position).getName());
       holder.tvAmount.setText(list.get(position).getAmount());
       holder.tvAddress.setText(list.get(position).getAddress());
       holder.tvEmail.setText(list.get(position).getEmail());

  }
   @Override
    public int getItemCount (){ return list.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvID,tvName,tvAmount,tvAddress,tvEmail;
    Button btnDelete;


    public MyViewHolder (@NonNull View itemView){

        super(itemView);
        tvID=itemView.findViewById(R.id.id);
        tvName=itemView.findViewById(R.id.name);
        tvAmount=itemView.findViewById(R.id.amount);
        tvAddress=itemView.findViewById(R.id.address);
        tvEmail=itemView.findViewById(R.id.email);
        btnDelete=itemView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
    }


        @Override
        public void onClick(View view) {
            Person person=new Person();
            int ID=list.get(getAdapterPosition()).getId();

            person.setId(ID);
            MainActivity.roomDatabaseClass.personDao().deletePerson(person);

        }

    }

}
