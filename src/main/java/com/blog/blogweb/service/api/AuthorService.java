package com.blog.blogweb.service.api;

import com.blog.blogweb.model.Author;

public interface AuthorService
{
  boolean createAuthor(Author author);

  Author login(String username, String password);

}
