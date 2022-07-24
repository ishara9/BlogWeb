package com.blog.blogweb.controller;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogweb.data.PostRepository;
import com.blog.blogweb.model.Author;
import com.blog.blogweb.model.Post;

@RestController
public class BasicController
{

  @Resource
  PostRepository postRepository;

  @GetMapping("/")
  public String index()
  {
    return "Greetings!";
  }

  @GetMapping("/post")
  public ResponseEntity<String> postMessage()
  {
    postRepository.save(new Post("new message", "hello!", new Author("J.J. Rollin")));
    Optional<Post> postOptional = postRepository.findById(1L);
    Post post = postOptional.orElseThrow(() -> new IllegalArgumentException("No such id exists"));
    return new ResponseEntity<>(String.format("Post: %s", post.toString()), HttpStatus.OK);
  }

  @GetMapping("/posts")
  public ResponseEntity<String> getPostMessages()
  {

    Iterable<Post> posts = postRepository.findAll();
    String postString = Arrays.asList(posts).stream().map(Objects::toString).collect(Collectors.joining(", "));

    return new ResponseEntity<>(String.format("Post: %s", postString), HttpStatus.OK);
  }

  @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
  public ResponseEntity<Post> getPostById(@PathVariable Long id)
  {
    try
    {
      Optional<Post> postOptional = postRepository.findById(1L);
      Post post = postOptional.orElseThrow(() -> new IllegalArgumentException("No such id exists"));
      return new ResponseEntity<>(post, HttpStatus.OK);

    }
    catch (IllegalArgumentException iEx)
    {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value ="/post/{id}/comments", method = RequestMethod.GET)
  public ResponseEntity<String> getPostComments(@PathVariable Long id)
  {
    try
    {
      Optional<Post> postOptional = postRepository.findById(1L);
      Post post = postOptional.orElseThrow(() -> new IllegalArgumentException("No such id exists"));
      return new ResponseEntity<>(post.getComments().stream().map(Objects::toString).collect(Collectors.joining(","))
          , HttpStatus.OK);

    }
    catch (IllegalArgumentException iEx)
    {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
