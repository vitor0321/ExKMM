package com.kmm.common.viewmodels

import com.kmm.common.BaseSharesViewModel
import com.kmm.common.models.Story
import com.kmm.common.models.StoryMedia
import com.kmm.common.providers.DataSourceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SampleViewModel : BaseSharesViewModel() {

    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>> = _stories

    private val _error = MutableStateFlow<Boolean>(false)
    val error: StateFlow<Boolean> = _error

    private val dataSourceProvider = DataSourceProvider()

    fun loadStories(){
        scope.launch {
            kotlin.runCatching {
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.insertStories(mockStories())
                db.getAllStories()
            }.onSuccess {
                _stories.emit(it)
            }.onFailure {
                _error.emit(true)
            }
        }
    }
    fun clearStories(){
        scope.launch {
            kotlin.runCatching {
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.getAllStories()
            }.onSuccess {
                _stories.emit(it)
            }.onFailure {
                _error.emit(true)
            }
        }
    }

    private fun mockStories(): List<Story>{
        return listOf(
            createStory("1","Story1"),
            createStory("2","Story2"),
            createStory("3","Story3"),
            createStory("4","Story4"),
            createStory("5","Story5"),
        )
    }

    private fun createStory(id: String, name: String): Story{
        return Story(
            id = id,
            name = name,
            StoryMedia(
                name = "Name",
                imgUrl = "URI",
                mimeType = "image/png"
            ),
            slides = emptyList()
        )
    }
}