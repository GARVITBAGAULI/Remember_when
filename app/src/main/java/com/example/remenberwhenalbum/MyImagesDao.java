package com.example.remenberwhenalbum;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyImagesDao {
    @Insert
    void insert(MyImages myImages );
    @Delete
    void Delete(MyImages myImages);
    @Update
    Void update(MyImages myImages);

    @SuppressWarnings("AndroidUnresolvedRoomSqlReference")
    @Query(" SELECT * FROM my_images ORDER BY image_id ASC")
    LiveData<List<MyImages>>getAllImages();

}
