package com.spotigram.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spotigram.models.PostsModel;
import com.spotigram.models.UserModel;
import com.spotigram.services.PostService;
import com.spotigram.services.UserServices;

@RestController
@RequestMapping("posts")
public class PostController {
	
	private PostService postService;
	
	public PostController() {
		super();
	}
	
	@Autowired
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping
	public List<PostsModel> findAll(){
		List<PostsModel> results = postService.findAll();
		System.out.println(results);
		return results;
	}
	
	@GetMapping("/author/{userName}")
	@ResponseBody
	public Object findByUser(@PathVariable String userName){
		List<PostsModel> results = postService.findByAuthor(userName);
		return results;
	}
	
	@GetMapping("/song/{songTitle}")
	@ResponseBody
	public List<PostsModel> findByTopicSong(@PathVariable String songTitle){
		List<PostsModel> results = postService.findByTopicSong(songTitle);
		System.out.println(results);
		return results;
	}
	
	@GetMapping("/album/{album}")
	@ResponseBody
	public List<PostsModel> findByTopicAlbum(@PathVariable String album){
		List<PostsModel> results = postService.findByTopicAlbum(album);
		System.out.println(results);
		return results;
	}
	
	@GetMapping("/artist/{artist}")
	@ResponseBody
	public List<PostsModel> findByTopicArtist(@PathVariable String artist){
		List<PostsModel> results = postService.findByTopicArtist(artist);
		System.out.println(results);
		return results;
	}
}
