package br.com.ste.app.topico;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

@Entity
public class Topico implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	Integer version;
	
	private String title;
	
	private Topico(String title) {
		this.title = title;
	}
	
	public static Topico newInstance(String title){
		checkArgument(!Strings.isNullOrEmpty(title));
		return new Topico(title);
	}
	
	public Topico() {
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("title", title).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Topico){
			Topico other = (Topico)obj;
			return Objects.equal(this.title, other.title);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.id, this.title);
	}
}
