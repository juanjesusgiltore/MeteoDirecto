package com.tfg.meteodirecto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.database.entities.Localidades
import com.tfg.meteodirecto.database.interfaces.InterfazDaoFavoritos
import com.tfg.meteodirecto.database.interfaces.InterfazDaoLocalidades
import java.io.FileOutputStream
import java.io.IOException


@Database(entities = [Localidades::class, Favoritos::class], version = 1, exportSchema = false)
abstract class BaseDeDatos: RoomDatabase() {
        abstract fun localidadesDao(): InterfazDaoLocalidades
        abstract fun favoritosDao(): InterfazDaoFavoritos

        companion object {
            @Volatile
            private var INSTANCE: BaseDeDatos? = null

            fun getDatabase(context: Context): BaseDeDatos {
                val dbPath = context.getDatabasePath("localidades.db")

                if (!dbPath.parentFile.exists()) {
                    dbPath.parentFile.mkdirs()
                }

                if (!dbPath.exists()) {
                    try {
                        context.assets.open("localidades.db").use { inputStream ->
                            FileOutputStream(dbPath).use { outputStream ->
                                val buffer = ByteArray(1024)
                                var length: Int
                                while (inputStream.read(buffer).also { length = it } > 0) {
                                    outputStream.write(buffer, 0, length)
                                }
                            }
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }

                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        BaseDeDatos::class.java,
                        "localidades.db"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }
}
