package com.blog.blogweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * “id” : number
 * “title” : String
 * “body” : String
 * “authorId” : number
 * “createdOn” : TimeStamp,
 * “modifiedOn” : TimeStamp
 */
@Entity
public class Post implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Long id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("body")
  private String body;

  @JsonProperty("createdOn")
  private Date createdOn;

  @JsonProperty("modifiedOn")
  private Date modifiedOn;

  @ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
  private Author author;

  @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
      CascadeType.PERSIST }, fetch = FetchType.EAGER)
  private final List<Comment> comments = new ArrayList<>();

  protected Post(){}

  public Post(String title, String body, Author author)
  {
    this.title = title;
    this.body = body;
    this.author = author;
  }

  @Override
  public String toString()
  {
    return String.format("Post [id=%d, title='%s', author='%s']", id,title,author.toString());
  }

  public List<Comment> getComments()
  {
    return comments;
  }

  public Author getAuthor()
  {
    return author;
  }

  public Post addComment(Comment comment)
  {
    comments.add(comment);
    return this;
  }

  public Long getId()
  {
    return id;
  }

  public String getTitle()
  {
    return title;
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

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setBody(String body)
  {
    this.body = body;
  }

  public void setCreatedOn(Date createdOn)
  {
    this.createdOn = createdOn;
  }

  public void setModifiedOn(Date modifiedOn)
  {
    this.modifiedOn = modifiedOn;
  }

  public void setAuthor(Author author)
  {
    this.author = author;
  }
}
