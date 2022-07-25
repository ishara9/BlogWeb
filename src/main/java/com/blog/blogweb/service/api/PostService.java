package com.blog.blogweb.service.api;

import java.util.List;

import com.blog.blogweb.model.Post;

public interface PostService
{
  void createPost(String title, String body, Long authorId);

  List<Post> getAllPosts();

  Post findPostById(Long id);

  Post updatePost(Post post, Long id);

  void deleteById(Long id);
}
