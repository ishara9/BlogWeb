package com.blog.blogweb.dto;

import java.io.Serializable;

public class PostDTO implements Serializable
{
  private String title;

  private String body;

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getBody()
  {
    return body;
  }

  public void setBody(String body)
  {
    this.body = body;
  }

  public AuthorDTO getAuthor()
  {
    return null;
  }
}
