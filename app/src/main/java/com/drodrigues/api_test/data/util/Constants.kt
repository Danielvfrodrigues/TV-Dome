package com.drodrigues.tvdome.data.util

internal const val API_BASE_URL: String = "https://api.tvmaze.com/"
internal const val API_ENDPOINT_SEARCH_SHOW: String = "search/shows?q=:query"
internal const val API_ENDPOINT_GET_SHOW_COMPLETE_LIST: String = "shows"
internal const val API_ENDPOINT_GET_SHOW_BY_ID: String = "shows/{id}"
internal const val API_ENDPOINT_GET_SEASONS_BY_SHOW_ID: String = "shows/{showId}/seasons"
internal const val API_ENDPOINT_GET_EPISODE_LIST_BY_SEASON_ID: String = "seasons/{seasonId}/episodes"
internal const val API_ENDPOINT_GET_EPISODE_BY_ID: String = "episodes/{episodeId}"