package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Music;

public interface MusicCrudRepository extends CrudRepository<Music, Long> {
	Optional<Music> findById(Long id);
}