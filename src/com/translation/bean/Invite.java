package com.translation.bean;

public class Invite {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column invite.inviteid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	private Integer inviteid;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column invite.docid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	private Integer docid;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column invite.guestid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	private Integer guestid;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column invite.isnew
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	private String isnew;




	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column invite.inviteid
	 * @return  the value of invite.inviteid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public Integer getInviteid() {
		return inviteid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column invite.inviteid
	 * @param inviteid  the value for invite.inviteid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public void setInviteid(Integer inviteid) {
		this.inviteid = inviteid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column invite.docid
	 * @return  the value of invite.docid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public Integer getDocid() {
		return docid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column invite.docid
	 * @param docid  the value for invite.docid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column invite.guestid
	 * @return  the value of invite.guestid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public Integer getGuestid() {
		return guestid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column invite.guestid
	 * @param guestid  the value for invite.guestid
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public void setGuestid(Integer guestid) {
		this.guestid = guestid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column invite.isnew
	 * @return  the value of invite.isnew
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public String getIsnew() {
		return isnew;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column invite.isnew
	 * @param isnew  the value for invite.isnew
	 * @ibatorgenerated  Mon Aug 24 18:07:53 CST 2015
	 */
	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}

	private Document document;
	
	private User user;
	
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}