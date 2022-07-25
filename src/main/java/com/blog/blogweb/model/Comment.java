package com.blog.blogweb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Comment implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("body")
  private String body;

  @JsonProperty("createdOn")
  private Date createdOn;

  @JsonProperty("modifiedOn")
  private Date modifiedOn;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Post post;

  protected Comment(){}

  public Comment(String name, Post post)
  {
    this.name = name;
    this.post = post;
  }

  @Override
  public String toString()
  {
    return String.format("Comment: %s", name);
  }

  public Long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getEmail()
  {
    return email;
  }

  public String getBody()
  {
    return body;
  }

  public Date getCreatedOn()
  {
    return createdOn;
  }

  public Date getModifiedOn()
  {
    return modifiedOn;
  }
}
