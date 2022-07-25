package com.blog.blogweb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogweb.dto.PostDTO;
import com.blog.blogweb.mapper.PostMapper;
import com.blog.blogweb.model.Comment;
import com.blog.blogweb.model.Post;
import com.blog.blogweb.service.api.CommentService;
import com.blog.blogweb.service.api.PostService;

@RestController
public class PostController
{
  @Resource
  PostService postService;

  @Resource
  CommentService commentService;

  @Resource
  PostMapper postMapper;

  @PostMapping("/post")
  public ResponseEntity<Boolean> createPost(@RequestBody String title, @RequestBody String body,
                                            @RequestBody Long authorId)
  {
    try
    {
      postService.createPost(title, body, authorId);
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    catch (Exception ex)
    {
      return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Post>> getAllPosts()
  {
    return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
  }

  @GetMapping("/post/{id}")
  public ResponseEntity<Post> getPostById(@PathVariable Long id)
  {
    try
    {
      Post post = postService.findPostById(id);
      return new ResponseEntity<>(post, HttpStatus.OK);

    }
    catch (IllegalArgumentException iEx)
    {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/post/{id}/comments")
  public ResponseEntity<List<Comment>> getPostComments(@PathVariable Long id)
  {
    try
    {
      Post post = postService.findPostById(id);
      List<Comment> comments = commentService.getCommentsByPost(post);
      return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    catch (IllegalArgumentException iEx)
    {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/post/update")
  public ResponseEntity<Boolean> updatePost(@RequestBody PostDTO postDTO, @PathVariable Long id)
  {
    try
    {
      postService.updatePost(postMapper.map(postDTO), id);
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    catch (Exception ex)
    {
      return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/post/{id}")
  public ResponseEntity<Boolean> deletePost(@PathVariable Long id)
  {
    try
    {
      postService.deleteById(id);
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    catch (Exception ex)
    {
      return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
  }
}
