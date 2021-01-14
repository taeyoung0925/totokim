package com.lec.supermarket;

public class SupermarketDto {

	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelname;
	private int forlevelup;

	// INSERT
	public SupermarketDto(String ctel, String cname) {
		this.ctel = ctel;
		this.cname = cname;
	}

	// SELECT
	public SupermarketDto(int cid, String ctel, String cname, int cpoint,int camount, String levelname, int forlevelup) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelname = levelname;
		this.forlevelup = forlevelup;
	}

	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "´Ô\t" + cpoint + "p\t" +camount +"¿ø\t"+ levelname + "\t" + forlevelup +"¿ø";
	}

	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public int getForlevelup() {
		return forlevelup;
	}

	public void setForlevelup(int forlevelup) {
		this.forlevelup = forlevelup;
	}

	public int getCmount() {
		return camount;
	}

	public void setCmount(int cmount) {
		this.camount = cmount;
	}

}
