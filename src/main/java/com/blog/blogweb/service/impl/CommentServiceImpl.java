package com.blog.blogweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.blog.blogweb.data.CommentRepository;
import com.blog.blogweb.model.Comment;
import com.blog.blogweb.model.Post;
import com.blog.blogweb.service.api.CommentService;

public class CommentServiceImpl implements CommentService
{

  @Resource
  CommentRepository commentRepository;

  @Override
  public List<Comment> getCommentsByPost(Post post)
  {
    return commentRepository.findByIdIn(
        post.getComments().stream().map(Comment::getId).collect(Collectors.toList()));
  }

  @Override
  public void deleteComments(Post post)
  {
    commentRepository.deleteByIdIn(
        post.getComments().stream().map(Comment::getId).collect(Collectors.toList()));
  }
}
