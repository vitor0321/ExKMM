package com.kmm.common.database

import br.com.progdeelite.kmmprogdeelite.database.CommonDatabase
import com.kmm.common.utils.AndroidApplication
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema, AndroidApplication.context, "common.db")
}