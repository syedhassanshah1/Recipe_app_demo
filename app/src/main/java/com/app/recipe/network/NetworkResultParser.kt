package com.app.recipe.network

import com.app.recipe.network.baseModel.ErrorResponseModel
import com.app.recipe.utils.fromJson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * A repository which provides resource from local database as well as remote end point.
 *
 * [RESULT] represents the type for database.
 * [REQUEST] represents the type for network.
 */

@ExperimentalCoroutinesApi
abstract class NetworkResultParser<RESULT> {

    fun asFlow() = flow<State<RESULT>> {

        // Emit Loading State
        emit(State.loading(true))

        // Fetch latest data from remote
        delay(200)
        val apiResponse = fetchFromRemote()

        // Parse body
        val remoteData = apiResponse.body()

        // Check for response validation
        if (remoteData != null && apiResponse.isSuccessful) {
            emit(State.success(remoteData))
        } else {
            // Something went wrong! Emit Error state.
            val errorBody = apiResponse.errorBody()?.string()?.fromJson<ErrorResponseModel>()
            emit(State.error(errorBody?.getMessageError() ?: "Error parsing response", errorBody))
        }
        emit(State.loading(false))
    }.catch { e ->
        // Exception occurred! Emit error
        emit(State.exception(e as Exception))
        e.printStackTrace()
        emit(State.loading(false))
    }

    /**
     * Fetches [Response] from the remote end point.
     */
    protected abstract suspend fun fetchFromRemote(): Response<RESULT>
}
