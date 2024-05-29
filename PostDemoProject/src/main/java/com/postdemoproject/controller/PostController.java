package com.postdemoproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.postdemoproject.pojo.Post;

@RestController
public class PostController {

	@GetMapping("/mypost/{id}")
	public Post getMyPost(@PathVariable("id") String id)
	{
		String url = "https://jsonplaceholder.typicode.com/posts/"+id;
		
		RestClient client = 
				RestClient.create();
		
		Post mypost = client.get()
		.uri(url)
		.retrieve()
		.body(Post.class);
		
		return mypost;
	}
}
