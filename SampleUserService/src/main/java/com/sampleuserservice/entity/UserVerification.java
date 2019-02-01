package com.sampleuserservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_verification")
public class UserVerification {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_verification_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="code")
	private long code;
		
	@Column(name="is_valid")	
	private boolean isValid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sent_time")
	private Date sentTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="verified_time")
	private Date verifiedTime;
	
	@Column(name="expiry_duration")
	private int expiryDuration;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	public Date getVerifiedTime() {
		return verifiedTime;
	}

	public void setVerifiedTime(Date verifiedTime) {
		this.verifiedTime = verifiedTime;
	}

	public int getExpiryDuration() {
		return expiryDuration;
	}

	public void setExpiryDuration(int expiryDuration) {
		this.expiryDuration = expiryDuration;
	}
}
