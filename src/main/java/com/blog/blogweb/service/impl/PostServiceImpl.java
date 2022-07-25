package com.blog.blogweb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.blog.blogweb.data.AuthorRepository;
import com.blog.blogweb.data.PostRepository;
import com.blog.blogweb.model.Author;
import com.blog.blogweb.model.Post;
import com.blog.blogweb.service.api.CommentService;
import com.blog.blogweb.service.api.PostService;

public class PostServiceImpl implements PostService
{

  @Resource
  PostRepository postRepository;

  @Resource
  AuthorRepository authorRepository;

  @Resource
  CommentService commentService;

  @Override
  public void createPost(String title, String body, Long authorId)
  {
    Optional<Author> authorOptional = authorRepository.findById(authorId);
    Author author = authorOptional.orElseThrow(() -> new IllegalArgumentException("No such AuthorId exist!"));
    postRepository.save(new Post(title, body, author));
  }

  @Override
  public List<Post> getAllPosts()
  {
    Iterable<Post> iterable = postRepository.findAll();
    List<Post> posts = new ArrayList<>();
    iterable.forEach(posts::add);
    return posts;
  }

  @Override
  public Post findPostById(Long id)
  {
    Optional<Post> postOptional = postRepository.findById(id);
    return postOptional.orElseThrow(() -> new IllegalArgumentException("No such id exists"));
  }

  @Override
  public Post updatePost(Post newPost, Long id)
  {
    return postRepository.findById(id).map(mutablePost -> {
      mutablePost.setTitle(mutablePost.getTitle());
      mutablePost.setBody(mutablePost.getTitle());
      mutablePost.setModifiedOn(new Date());
      mutablePost.setAuthor(mutablePost.getAuthor());
      return postRepository.save(mutablePost);
    }).orElseGet(() -> {
      newPost.setId(id);
      Date newDate = new Date();
      newPost.setCreatedOn(newDate);
      newPost.setModifiedOn(newDate);
      return postRepository.save(newPost);
    });
  }

  @Override
  public void deleteById(Long id)
  {
    Optional<Post> post = postRepository.findById(id);
    post.ifPresent(value -> postRepository.deleteById(value.getId()));
  }

}
