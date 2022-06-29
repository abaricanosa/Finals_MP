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
import androidx.lifecycle.ViewModel;

public class AddDataFragment extends Fragment{

    private EditText inputID,inputName,inputAmount,inputAddress,inputEmail;
    private Button btnAdd;

    public AddDataFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.add_data_fragment, container, false);
        inputID=view.findViewById(R.id.inputID);
        inputName=view.findViewById(R.id.inputName);
        inputAmount=view.findViewById(R.id.inputAmount);
        inputAddress=view.findViewById(R.id.inputAddress);
        inputEmail=view.findViewById(R.id.inputEmail);
        btnAdd=view.findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(inputID.getText().toString());
                String name=inputName.getText().toString();
                String amount=inputAmount.getText().toString();
                String address=inputAddress.getText().toString();
                String email =inputEmail.getText().toString();

                Person person=new Person();
                person.setId(id);
                person.setName(name);
                person.setAmount(amount);
                person.setAddress(address);
                person.setEmail(email);

                MainActivity.roomDatabaseClass.personDao().addPerson(person);
                Toast.makeText(getActivity(), "Added Successfully", Toast.LENGTH_SHORT).show();
                inputID.setText("");
                inputName.setText("");
                inputAmount.setText("");
                inputAddress.setText("");
                inputEmail.setText("");
            }

        });

        return view;


    }
}