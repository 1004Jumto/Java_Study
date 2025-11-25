package ch20.oracle.sec12;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	public int bno;
	public String btitle;
	public String bcontent;
	public String bwriter;
	public Date bdate;
}
