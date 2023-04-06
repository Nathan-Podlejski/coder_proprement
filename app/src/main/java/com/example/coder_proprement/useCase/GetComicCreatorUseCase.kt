package fr.iem.useCase

import com.example.coder_proprement.BuildConfig.MARVEL_PRIVATE_API_KEY
import com.example.coder_proprement.BuildConfig.MARVEL_PUBLIC_API_KEY
import com.example.coder_proprement.api.MarvelRepository
import fr.iem.api.ApiClient
import fr.iem.extension.md5
import fr.iem.model.ComicCreators
import fr.iem.model.Creators
import fr.iem.model.MarvelCharacter
import fr.iem.model.MarvelResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

class GetComicCreatorUseCase {
    suspend fun invoke(id: Int): MarvelResponse<ComicCreators>? {
        return withContext(Dispatchers.IO) {
            val scope = CoroutineScope(SupervisorJob())
            val publicKey = MARVEL_PUBLIC_API_KEY
            val privateKey = MARVEL_PRIVATE_API_KEY

            val ts = System.currentTimeMillis().toString()

            val hash = (ts + privateKey + publicKey).md5()

            MarvelRepository.newInstance().getComicCreator(id.toString() ,ts, publicKey, hash).execute().body()
        }
    }
}