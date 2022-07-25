package com.blog.blogweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration
{
  @Bean
  public PostService getPostService()
  {
    return new PostService();
  }
}
