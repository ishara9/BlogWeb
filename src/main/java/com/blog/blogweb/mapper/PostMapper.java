package com.blog.blogweb.mapper;

import javax.annotation.Resource;

import com.blog.blogweb.dto.PostDTO;
import com.blog.blogweb.model.Post;

public class PostMapper implements DTOMapper<Post, PostDTO>
{

  @Resource
  AuthorMapper authorMapper;

  @Override
  public Post map(PostDTO from)
  {
    return new Post(from.getTitle(), from.getBody(), authorMapper.map(from.getAuthor()));
  }
}
