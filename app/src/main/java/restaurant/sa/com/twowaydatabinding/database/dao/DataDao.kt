package restaurant.sa.com.twowaydatabinding.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import restaurant.sa.com.twowaydatabinding.model.Data

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: Data)

    @Query("SELECT * FROM Data")
    fun getAll(): List<Data>

    @Query("DELETE from Data")
    fun deleteAll()

}