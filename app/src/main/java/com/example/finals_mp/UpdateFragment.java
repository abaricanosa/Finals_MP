package com.example.finals_mp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UpdateFragment extends Fragment {

    private EditText inputIDUpdate,inputNameUpdate,inputAmountUpdate,inputAddressUpdate,inputEmailUpdate;
    private Button btnUpdate;
    public UpdateFragment(){


    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.update_fragment, container, false);
        inputIDUpdate=view.findViewById(R.id.inputIDUpdate);
        inputNameUpdate=view.findViewById(R.id.inputNameUpdate);
        inputAmountUpdate=view.findViewById(R.id.inputAmountUpdate);
        inputAddressUpdate=view.findViewById(R.id.inputAddressUpdate);
        inputEmailUpdate=view.findViewById(R.id.inputEmailUpdate);
        btnUpdate=view.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(inputIDUpdate.getText().toString());
                String name =inputNameUpdate.getText().toString();
                String amount =inputAmountUpdate.getText().toString();
                String address =inputAddressUpdate.getText().toString();
                String email =inputEmailUpdate.getText().toString();

                Person person=new Person();
                person.setId(id);
                person.setName(name);
                person.setAmount(amount);
                person.setAddress(address);
                person.setEmail(email);

                MainActivity.roomDatabaseClass.personDao().updatePerson(person);
                Toast.makeText(getActivity(), "Update Successfully", Toast.LENGTH_SHORT).show();
            }

        });

    return view;
    }


}
