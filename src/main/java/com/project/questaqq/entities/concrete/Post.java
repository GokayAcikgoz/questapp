package com.project.questaqq.entities.concrete;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "text", columnDefinition = "text") //db de text olarak olması için yoksa varchar255 olur.
	private String text;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE) // ilgili user silindiğinde onun postlarını sil
	//@JsonIgnore //serialize yaparken hhata olmaması için
	private User user;
	
	@OneToMany(mappedBy = "post")
	private List<Like> likes;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

}
