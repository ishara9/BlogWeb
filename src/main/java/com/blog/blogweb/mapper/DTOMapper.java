package com.blog.blogweb.mapper;

public interface DTOMapper<T,F>
{
  T map(F from);
}
