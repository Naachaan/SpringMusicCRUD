package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Music;

public interface MusicService {
	Iterable<Music> findAll();
	Optional<Music> findById(Long id);
	void insertMusic(Music music);
	void updateMusic(Music musicupdate);
	void deleteMusic(Long song_id);
}
