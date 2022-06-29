package com.example.finals_mp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void addPerson(Person person);

    @Query("select * from person")
    public List<Person>getPerson();

    @Delete
    public void deletePerson(Person person);

    @Update
    public void updatePerson(Person person);

}
