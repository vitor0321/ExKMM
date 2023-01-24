package com.kmm.common.databse

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.kmm.common.database.Database
import com.kmm.common.database.createSqlDriver
import com.kmm.common.models.Story
import com.kmm.common.models.StoryMedia
import com.kmm.common.utils.AndroidApp
import kotlin.test.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var database: Database

    @Before
    fun prepareTest() {
        AndroidApp.apllicationContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Database(createSqlDriver())
        database.clearDatabase()
    }

    @After
    fun cleanupTest() {
        database.clearDatabase()
    }

    @Test
    fun clearDatabase() {
        assertEquals(0, database.getAllStories().size)
    }

    @Test
    fun getAllStories() {
        val stories = listOf(
            Story("1", "Story1", StoryMedia("", "", ""), listOf()),
            Story("2", "Story2", StoryMedia("", "", ""), listOf())
        )
        database.insertStories(stories)
        val source = database.getAllStories()
        assertEquals(2, source.size)
    }

    @Test
    fun insertStories() {
        val stories = listOf(
            Story("1", "Story1", StoryMedia("", "", ""), listOf()),
            Story("2", "Story2", StoryMedia("", "", ""), listOf()),
            Story("3", "Story3", StoryMedia("", "", ""), listOf()),
            Story("4", "Story4", StoryMedia("", "", ""), listOf())
        )
        database.insertStories(stories)
        val source = database.getAllStories()
        assertEquals(4, source.size)
    }
}