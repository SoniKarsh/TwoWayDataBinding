package restaurant.sa.com.twowaydatabinding.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "Data", indices = arrayOf(Index(value = arrayOf("firstName", "lastName"), unique = true)))
class Data: Observable() {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "firstName")
    var firstName: String = ""
        set(value) {
            field = value
            setChangedAndNotify("firstName")
        }

    @ColumnInfo(name = "lastName")
    var lastName: String = ""
        set(value) {
            field = value
            setChangedAndNotify("lastName")
        }
    private fun setChangedAndNotify(field: Any)
    {
        setChanged()
        notifyObservers(field)
    }
}

