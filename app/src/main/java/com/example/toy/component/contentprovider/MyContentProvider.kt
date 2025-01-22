import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class MyContentProvider : ContentProvider() {

    private lateinit var databaseHelper: MyDatabaseHelper

    companion object {
        const val AUTHORITY = "com.example.app.toy.provider"
        const val TABLE_NAME = "my_table"
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$TABLE_NAME")

        private const val TABLE_CODE = 1
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, TABLE_NAME, TABLE_CODE)
        }
    }

    override fun onCreate(): Boolean {
        databaseHelper = MyDatabaseHelper(context!!)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val db = databaseHelper.readableDatabase
        return when (uriMatcher.match(uri)) {
            TABLE_CODE -> db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder)
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db = databaseHelper.writableDatabase
        return when (uriMatcher.match(uri)) {
            TABLE_CODE -> {
                val id = db.insert(TABLE_NAME, null, values)
                context?.contentResolver?.notifyChange(uri, null)
                Uri.withAppendedPath(CONTENT_URI, id.toString())
            }
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        val db = databaseHelper.writableDatabase
        return when (uriMatcher.match(uri)) {
            TABLE_CODE -> db.update(TABLE_NAME, values, selection, selectionArgs)
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val db = databaseHelper.writableDatabase
        return when (uriMatcher.match(uri)) {
            TABLE_CODE -> db.delete(TABLE_NAME, selection, selectionArgs)
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            TABLE_CODE -> "vnd.android.cursor.dir/$AUTHORITY.$TABLE_NAME"
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }
}