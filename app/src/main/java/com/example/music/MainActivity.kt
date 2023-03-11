package com.example.music

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = Retrofit.Builder()
            .baseUrl("http://ws.audioscrobbler.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LastFmApi::class.java)
        val response = api.getTopTags("658cdbe8fc5f99a4685170c3656fd268").execute()
        if (response.isSuccessful) {
            val topTags = response.body()?.toptags?.tag?.take(10)
            // Update the UI with the top tags
        } else {
            // Handle the error
        }

//        val api = Retrofit.Builder()
//            .baseUrl("http://ws.audioscrobbler.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(LastFmApi::class.java)
//        val albumResponse = api.getTopAlbums("YOUR_API_KEY", genre).execute()
//        val trackResponse = api.getTopTracks("YOUR_API_KEY", genre).execute()
//        val artistResponse = api.getTopArtists("YOUR_API_KEY", genre).execute()
//        if (albumResponse.isSuccessful && trackResponse.isSuccessful && artistResponse.isSuccessful) {
//            val topAlbums = albumResponse.body()?.topalbums?.album
//            val topTracks = trackResponse.body()?.tracks?.track
//            val topArtists = artistResponse.body()?.topartists?.artist
//            // Update the UI with the top albums, tracks, and artists
//        } else {
//            // Handle the error
//        }
//
//        val api = Retrofit.Builder()
//            .baseUrl("http://ws.audioscrobbler.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(LastFmApi::class.java)
//        val response = api.getAlbumInfo("YOUR_API_KEY", artist, album).execute()
//        if (response.isSuccessful) {
//            val albumInfo = response.body()?.album
//            // Update the UI with the album info
//        } else {
//            // Handle the error
//        }
//
//        val api = Retrofit.Builder()
//            .baseUrl("http://ws.audioscrobbler.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(LastFmApi::class.java)
//        val artistResponse = api.getArtistInfo("YOUR_API_KEY", artist).execute()
//        val trackResponse = api.getTopTracksByArtist("YOUR_API_KEY", artist).execute()
//        val album

    }
}

class LastFmApi {
    fun getTopTags(s: String): Any {

    }

}
