package com.lecturempo3pro.domain.usecase

import com.lecturempo3pro.domain.model.Song
import com.lecturempo3pro.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSongsUseCase @Inject constructor(
    private val songRepository: SongRepository
) {
    operator fun invoke(): Flow<List<Song>> = songRepository.getAllSongs()
}

class GetFavoriteSongsUseCase @Inject constructor(
    private val songRepository: SongRepository
) {
    operator fun invoke(): Flow<List<Song>> = songRepository.getFavoriteSongs()
}

class GetSongsByArtistUseCase @Inject constructor(
    private val songRepository: SongRepository
) {
    operator fun invoke(artist: String): Flow<List<Song>> = songRepository.getSongsByArtist(artist)
}

class GetSongsByAlbumUseCase @Inject constructor(
    private val songRepository: SongRepository
) {
    operator fun invoke(album: String): Flow<List<Song>> = songRepository.getSongsByAlbum(album)
}

class ToggleFavoriteSongUseCase @Inject constructor(
    private val songRepository: SongRepository
) {
    suspend operator fun invoke(songId: String, isFavorite: Boolean) =
        songRepository.toggleFavorite(songId, isFavorite)
}
