package com.project.questaqq.entities.concrete;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Long id;
	
	@Column(name = "text", columnDefinition = "text") //db de text olarak olması için yoksa varchar255 olur.
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE) // ilgili user silindiğinde onun postlarını sil
	@JsonIgnore //serialize yaparken hhata olmaması için
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	@OnDelete(action = OnDeleteAction.CASCADE) // ilgili user silindiğinde onun postlarını sil
	@JsonIgnore //serialize yaparken hhata olmaması için
	private Post post;

}
