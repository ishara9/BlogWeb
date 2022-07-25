package com.blog.blogweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blog.blogweb.mapper.AuthorMapper;
import com.blog.blogweb.mapper.CommentMapper;
import com.blog.blogweb.mapper.PostMapper;
import com.blog.blogweb.service.api.AuthorService;
import com.blog.blogweb.service.api.CommentService;
import com.blog.blogweb.service.api.PostService;
import com.blog.blogweb.service.impl.AuthorServiceImpl;
import com.blog.blogweb.service.impl.CommentServiceImpl;
import com.blog.blogweb.service.impl.PostServiceImpl;

@Configuration
public class BeanConfiguration
{
  @Bean
  public PostService getPostService()
  {
    return new PostServiceImpl();
  }

  @Bean
  public CommentService getCommentService()
  {
    return new CommentServiceImpl();
  }

  @Bean
  public AuthorMapper getAuthorMapper()
  {
    return new AuthorMapper();
  }

  @Bean
  public PostMapper getPostMapper()
  {
    return new PostMapper();
  }

  @Bean
  public CommentMapper getCommentMapper()
  {
    return new CommentMapper();
  }

  @Bean
  public AuthorService getAuthorService()
  {
    return new AuthorServiceImpl();
  }
}
