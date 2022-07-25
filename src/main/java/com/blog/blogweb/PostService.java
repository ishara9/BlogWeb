package com.blog.blogweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.blog.blogweb.data.AuthorRepository;
import com.blog.blogweb.data.PostRepository;
import com.blog.blogweb.model.Author;
import com.blog.blogweb.model.Post;

public class PostService
{

  @Resource
  PostRepository postRepository;

  @Resource
  AuthorRepository authorRepository;

  public String postMessage()
  {
    return "Post message as a bean";
  }

  public void createPost(String title, String body, Long authorId)
  {
    Optional<Author> authorOptional = authorRepository.findById(authorId);
    Author author = authorOptional.orElseThrow(() -> new IllegalArgumentException("No such AuthorId exist!"));
    postRepository.save(new Post(title, body, author));
  }

  public List<Post> getAllPosts()
  {
    Iterable<Post> iterable = postRepository.findAll();
    List<Post> posts = new ArrayList<>();
    iterable.forEach(posts::add);
    return posts;
  }
}
