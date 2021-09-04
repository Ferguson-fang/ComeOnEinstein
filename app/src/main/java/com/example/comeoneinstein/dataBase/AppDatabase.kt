

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.comeoneinstein.dao.CountDao
import com.example.comeoneinstein.model.DataModel

@Database(version = 1,entities = [DataModel.Count::class])
abstract class AppDatabase : RoomDatabase(){
    /**
     * 只需声明方法，具体逻辑Room在底层自动完成
     * */
    abstract fun countDao() : CountDao

    companion object{

        private  var instance : AppDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                //如果instance不为空直接返回
                return it
            }
            //如果instance为空就调用Room.databaseBuilder构建一个AppDatabase实例
            return Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java,"app_database")
                .build().apply {
                instance = this
            }
            /**
             * Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java,"app_database")
            .allowMainThreadQueries()   为了方便测试，Room提供了一个简单的方法允许在主线程中进行数据库操作，只能在测试环境使用
            .build()
             * */
        }
    }
}