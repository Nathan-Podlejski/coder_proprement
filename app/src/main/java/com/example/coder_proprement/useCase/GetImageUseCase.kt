package android2.kotlin.fr.iem.useCase

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import fr.iem.model.Comic
import fr.iem.useCase.GetComicByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class GetImageUseCase {

    private val getComicsByIdUseCase: GetComicByIdUseCase
        get() = GetComicByIdUseCase()

    suspend operator fun invoke(idComic: Int): Bitmap {
        return withContext(Dispatchers.IO) {
            val comics = getComicsByIdUseCase.invoke(idComic)

            val url = makesUrl(
                comics?.data!!.results[0].thumbnail!!.path!!,
                comics?.data!!.results[0].thumbnail!!.extension!!
            )
            val connection: HttpURLConnection?

            connection = url.openConnection() as HttpURLConnection
            connection.connect()
            val inputStream: InputStream = connection.inputStream
            return@withContext BitmapFactory.decodeStream(BufferedInputStream(inputStream))

        }
    }

    private fun makesUrl(path: String, extension: String): URL {
        return URL("$path.$extension")
    }

}