package restaurant.sa.com.twowaydatabinding.database.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import restaurant.sa.com.twowaydatabinding.database.dao.DataDao
import restaurant.sa.com.twowaydatabinding.model.Data

@Database(entities = [(Data::class)], version = 1)
abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDao(): DataDao

}