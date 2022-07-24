package com.blog.blogweb.data;

import org.springframework.data.repository.CrudRepository;

import com.blog.blogweb.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
}
