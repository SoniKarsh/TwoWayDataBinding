package restaurant.sa.com.twowaydatabinding

import android.app.Application
import android.arch.persistence.room.Room
import restaurant.sa.com.twowaydatabinding.database.db.DataDatabase

class DataApp: Application() {

    companion object {
        var instance: DataApp? = null
        var database: DataDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()

        // Single Instance
        instance = this

        // Single Database instance
        database = Room.databaseBuilder(this, DataDatabase::class.java, "binding-db").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build()

    }

}