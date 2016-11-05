package com.javamakeuse.datafilter;

public class Movie {

	private long id;

	private String name;

	private String year;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + "]";
	}

}
