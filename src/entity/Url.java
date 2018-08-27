package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Classe padrão Java Bean com mapeamento do Hibernate

@Entity
@Table(name="url")
public class Url implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=255)
	private String url_longa;
	@Column(length=255)
	private String url_curta;
	
	public Url() {
	
	}

	public Url(Integer id, String url_longa) {
		super();
		this.id = id;
		this.url_longa = url_longa;
	}
	
	public Url(Integer id, String url_longa, String url_curta) {
		super();
		this.id = id;
		this.url_longa = url_longa;
		this.url_curta = url_curta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl_longa() {
		return url_longa;
	}

	public void setUrl_longa(String url_longa) {
		this.url_longa = url_longa;
	}

	public String getUrl_curta() {
		return url_curta;
	}

	public void setUrl_curta(String url_curta) {
		this.url_curta = url_curta;
	}

	@Override
	public String toString() {
		return "Url : id=" + id + ", url_longa=" + url_longa + ", url_curta=" + url_curta;
	}


	
	
	
	
	
	
	

}
