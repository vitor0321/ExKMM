package com.kmm.common.providers

import com.kmm.common.database.Database
import com.kmm.common.database.createSqlDriver

class DataSourceProvider {
    private val database = Database(createSqlDriver())

    fun getLocalCommonDatabase() = database

//    Outros provedores de dados que voce poderia ter aqui mais pra frente
//    fun getXyzRepository()
//    fun getXyzUseCase()
}