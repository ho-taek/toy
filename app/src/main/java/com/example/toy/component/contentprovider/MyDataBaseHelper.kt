import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(
    context: Context,
    name: String = DATABASE_NAME,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = DATABASE_VERSION
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        // 데이터베이스 최초 생성 시 호출
        db.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 데이터 베이스 호출
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "mydatabase.db" // 데이터베이스 파일 이름
        private const val DATABASE_VERSION = 1 // 데이터베이스 버전

        //테이블 및 컬럼 정리
        const val TABLE_NAME = "my_table"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"

        // 테이블 생성 쿼리
        private const val CREATE_TABLE_QUERY =
            " CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME TEXT NOT NULL)"
    }
}