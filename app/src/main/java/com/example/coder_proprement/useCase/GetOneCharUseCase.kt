package fr.iem.useCase

import com.example.coder_proprement.BuildConfig.MARVEL_PRIVATE_API_KEY
import com.example.coder_proprement.BuildConfig.MARVEL_PUBLIC_API_KEY
import fr.iem.api.ApiClient
import fr.iem.extension.md5
import fr.iem.model.MarvelCharacter
import fr.iem.model.MarvelResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

//
class GetOneCharUseCase {
    suspend fun invoke(): MarvelResponse<MarvelCharacter>? {
        return withContext(Dispatchers.IO) {
            val scope = CoroutineScope(SupervisorJob())
            val publicKey = MARVEL_PUBLIC_API_KEY
            val privateKey = MARVEL_PRIVATE_API_KEY

            val ts = System.currentTimeMillis().toString()

            val hash = (ts + privateKey + publicKey).md5()

            ApiClient.apiService.getChar(ts, publicKey, hash).execute().body()
        }
    }
}