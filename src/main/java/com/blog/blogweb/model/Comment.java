package com.blog.blogweb.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * "postId": number
 * "id": number
 * “name": String
 * "email": String,
 * “body": String,
 * “createdOn” : TimeStamp,
 * “modifiedOn” : TimeStamp
 * }
 */
@Entity
public class Comment
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String email;

  private String body;

  private Date createdOn;

  private Date modifiedOn;

  @ManyToOne(fetch = FetchType.EAGER)
  private Post post;

  protected Comment(){}

  public Comment(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return String.format("Comment: %s", name);
  }
}
