import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.istock.DataBase.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}