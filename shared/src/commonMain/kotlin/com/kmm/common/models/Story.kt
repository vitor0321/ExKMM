package com.kmm.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Story(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("storyMedia")
    val storyMedia: StoryMedia,
    @SerialName("slides")
    val slides: List<Slide>
)

@Serializable
data class StoryMedia(
    @SerialName("name")
    val name: String,
    @SerialName("imgUrl")
    val imgUrl: String,
    @SerialName("mimeType")
    val mimeType: String
)

@Serializable
data class Slide(
    @SerialName("id")
    val id: String
)