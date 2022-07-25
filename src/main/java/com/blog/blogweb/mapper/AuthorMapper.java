package com.blog.blogweb.mapper;

import com.blog.blogweb.dto.AuthorDTO;
import com.blog.blogweb.model.Author;

public class AuthorMapper implements DTOMapper<Author, AuthorDTO>
{
  @Override
  public Author map(AuthorDTO from)
  {
    Author author = new Author(from.getName());
    author.username(from.getUsername()).email(from.getEmail()).address(from.getAddress());
    return author;
  }
}
