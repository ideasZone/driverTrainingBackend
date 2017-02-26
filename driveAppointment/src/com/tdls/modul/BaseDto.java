package com.tdls.modul;
import java.io.Serializable;
import java.util.Date;

/**
 * 所有实体类的父类
 */
public class BaseDto implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2287750644444311736L;

	//id
	private Integer id;

	//创建时间
    private Date createDate;
    
    //创建人
    private Integer createUserId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
}