package co.grandcircus.FinalProject.SQL;

import javax.persistence.*;

@Entity
@Table(name="cheapsharkstore")
public class CheapSharkStoreName {
	
	@Id
	private Long storeid;
	private String storename;
	public Long getStoreid() {
		return storeid;
	}
	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	
	public CheapSharkStoreName() {}

}
