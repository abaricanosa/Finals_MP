package com.example.finals_mp;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class},version=2, exportSchema = false)
public abstract class RoomDatabaseClass  extends RoomDatabase {

   public abstract PersonDao personDao();

}
