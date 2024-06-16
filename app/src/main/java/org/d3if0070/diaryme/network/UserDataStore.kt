package org.d3if0070.diaryme.network

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.d3if0070.diaryme.model.User

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "user_preference"
)

class UserDataStore(private val context: Context) {

    companion object {
        private val IS_LIST = booleanPreferencesKey("islist")
        private val USER_NAME = stringPreferencesKey("name")
        private val USER_EMAIL = stringPreferencesKey("email")
        private val USER_PHOTO = stringPreferencesKey("photoUrl")
    }

    val userFlow: Flow<User> = context.dataStore.data.map { preferences ->
        User(
            name = preferences[USER_NAME] ?: "",
            email = preferences[USER_EMAIL] ?: "",
            photoUrl = preferences[USER_PHOTO] ?: ""
        )
    }

    val layoutFlow: Flow<Boolean> = context.dataStore.data.map {
        it[IS_LIST] ?: true
    }

    suspend fun saveLayout(isList: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LIST] = isList
        }
    }
    suspend fun saveData(user: User) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = user.name
            preferences[USER_EMAIL] = user.email
            preferences[USER_PHOTO] = user.photoUrl
        }
    }
}