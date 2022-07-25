package com.blog.blogweb.service.api;

import java.util.List;

import com.blog.blogweb.model.Comment;
import com.blog.blogweb.model.Post;

public interface CommentService
{
  List<Comment> getCommentsByPost(Post post);

  void deleteComments(Post post);
}
