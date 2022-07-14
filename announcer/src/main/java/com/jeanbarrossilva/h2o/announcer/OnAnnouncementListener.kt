package com.jeanbarrossilva.h2o.announcer

fun interface OnAnnouncementListener {
    suspend fun onAnnouncement()
}