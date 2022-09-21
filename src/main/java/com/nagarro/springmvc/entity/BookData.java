/**
 * 
 */
package com.nagarro.springmvc.entity;




/**
 * This class is use for model the book data which coming from external api.
 * @author ravikumar05
 *
 */

public class BookData {
	
	private int bookcode;
	private String bookname;
	private String author;
	private String date;
	
	/**
	 * @return the bookcode
	 */
	public int getBookcode() {
		return bookcode;
	}
	/**
	 * @param bookcode the bookcode to set
	 */
	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}
	/**
	 * @return the bookname
	 */
	public String getBookname() {
		return bookname;
	}
	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	

}
