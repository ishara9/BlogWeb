package com.blog.blogweb.data;

import org.springframework.data.repository.CrudRepository;

import com.blog.blogweb.model.Post;

public interface PostRepository extends CrudRepository<Post, Long>
{

}
