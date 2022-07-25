package com.blog.blogweb.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blog.blogweb.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>
{
  List<Comment> findByIdIn(List<Long> commentIdList);

  void deleteByIdIn(List<Long> commentIdList);
}
