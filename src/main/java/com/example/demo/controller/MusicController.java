package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Music;
import com.example.demo.form.MusicForm;
import com.example.demo.service.MusicService;

@Controller
public class MusicController {
    @Autowired
    MusicService service;
    
    @GetMapping("index")
    public String indexView(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
        return "index";
    }
    @PostMapping(value="music", params="insert")
    public String MusicInput(Model model){
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return"Music-input";
    }
    @PostMapping(value="music", params="update")
    public String Musicupdate(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return "Music-update";
    }
    @PostMapping(value="music", params="delete")
    public String Musicdelete(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return "Music-delete";
    }
    
    @PostMapping(value="insert", params="check")
    public String confirm(@ModelAttribute MusicForm m, Model model) {
        model.addAttribute("musicForm", m);
        return "confirm";
    }
    @PostMapping(value="insert", params="return")
    public String insertreturn(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return "index";
    }
    
    @PostMapping(value="check", params="insert")
    public String musicInsert(@ModelAttribute MusicForm m) {
        Music music = new Music(m.getSong_id(), m.getSong_name(), m.getSinger());
        service.insertMusic(music);
        return "Music-complete";
    }
    @PostMapping(value="check", params="return")
    public String checkreturn(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return "index";
    }
    
    @PostMapping(value="updateform", params="update")
    public String Update(@RequestParam("song_id")Long song_id, Model model) {
    	Optional<Music> musicOpt = service.findById(song_id);
        if (musicOpt.isPresent()) {
            model.addAttribute("music", musicOpt.get());
            return "Update";
        } else {
            model.addAttribute("error", "IDが見つかりませんでした");
            return "Music-update";
        }
    }
    @PostMapping(value="updateform", params="return")
    public String updatereturn(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return "index";
    }
    
    @PostMapping(value="update", params="update")
    public String updateMusic(@ModelAttribute MusicForm m) {
        Music music = new Music(m.getSong_id(), m.getSong_name(), m.getSinger());
        service.updateMusic(music);
        return "Music-complete";
    }
    @PostMapping(value="update", params="return")
    public String updatereturnn(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return "index";
    }
    
    @PostMapping(value="deleteform", params="delete")
    public String findMusicForDelete(@RequestParam("song_id") Long song_id, Model model) {
        Optional<Music> musicOpt = service.findById(song_id);
        if (musicOpt.isPresent()) {
            model.addAttribute("music", musicOpt.get());
            return "Delete";
        } else {
            model.addAttribute("error", "IDが見つかりませんでした");
            return "Music-delete";
        }
    }
    
    @PostMapping(value="delete", params="delete")
    public String deleteMusic(@RequestParam("song_id") Long song_id) {
        service.deleteMusic(song_id);
        return "Music-complete";
    }
    @PostMapping(value="delete", params="return")
    public String returndelete(Model model) {
    	Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
    	return "index";
    }
}