package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Music;
import com.example.demo.repository.MusicCrudRepository;

@Service
public class MusicserviceImpl implements MusicService{
	@Autowired
	MusicCrudRepository repository;
	
	@Override
	public Iterable<Music> findAll(){
		return repository.findAll();
	}
	
	@Override
	public void insertMusic(Music music) {
		repository.save(music);
	}
	
	@Override
	public Optional<Music> findById(Long song_id){
		return repository.findById(song_id);
	}
	@Override
	public void updateMusic(Music musicupdate) {
		repository.save(musicupdate);
	}
	
	@Override
	public void deleteMusic(Long song_id) {
		repository.deleteById(song_id);
	}
}