package com.kmm.common.database

import br.com.progdeelite.kmmprogdeelite.database.CommonDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual fun createSqlDriver(): SqlDriver{
    return NativeSqliteDriver(CommonDatabase.Schema, "common.db")
}