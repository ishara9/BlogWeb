package com.blog.blogweb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogweb.PostService;
import com.blog.blogweb.model.Post;

@RestController
public class PostController
{
  @Resource
  PostService postService;

  @PostMapping("/post")
  public ResponseEntity<Boolean> createPost(String title, String body, Long authorId)
  {
    try
    {
      postService.createPost(title, body, authorId);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    catch (Exception ex)
    {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value ="/posts", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Post>> getAllPosts()
  {
    return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
  }
}
