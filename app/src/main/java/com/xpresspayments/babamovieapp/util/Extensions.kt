package com.xpresspayments.babamovieapp.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.xpresspayments.babamovieapp.util.Constants.PREFERENCES_NAME

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)