package com.kmm.common.database

import br.com.progdeelite.kmmprogdeelite.database.CommonDatabase
import com.kmm.common.utils.AndroidApp
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema, AndroidApp.apllicationContext, "common.db")
}