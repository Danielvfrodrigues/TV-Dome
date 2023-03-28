package com.drodrigues.api_test.data.repository

import android.util.Log
import com.drodrigues.api_test.data.model.ShowModel
import com.drodrigues.api_test.data.model.toEntity
import com.drodrigues.api_test.data.model.toEntityList
import com.drodrigues.api_test.data.source.ShowDataSource
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.repository.ShowRepository
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class ShowRepositoryImpl(
    private val showDataSource: ShowDataSource,
) : ShowRepository {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    val deferred: CompletableDeferred<List<ShowEntity>> = CompletableDeferred()

    override suspend fun getShowCompleteList(): List<ShowEntity> {

            try {
               coroutineScope.launch {
                   showDataSource.getShowCompleteList().enqueue(object : Callback<List<ShowModel>> {
                       override fun onResponse(
                           call: Call<List<ShowModel>>,
                           response: Response<List<ShowModel>>
                       ) {
                           if (response.isSuccessful) {
                               deferred.complete(toEntityList(response.body()!!))
                               Log.i("Test", "onCreate: ${toEntityList(response.body()!!)}")
                           }
                       }

                       override fun onFailure(call: Call<List<ShowModel>>, t: Throwable) {
                           Log.i("Test", "onFailure: ================== FAILED ====================")
                       }

                   })
               }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        return deferred.await()
    }

    override suspend fun getShowById(id: String): ShowEntity {
        return toEntity(showDataSource.getShowById(id).body()!!)
    }
}