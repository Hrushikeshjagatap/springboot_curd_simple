package com.example.demo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public class BookRespo {

	@Autowired
	JdbcTemplate jtemp;
	
	public boolean insertBook(Book b)
	{
		int x=jtemp.update("insert into Book values(?,?,?,?,?)",b.getBid(),b.getBname(),
				b.getBauthor(),b.getBcategory(),b.getBprice());
		if(x>0)
			return true;
		else
			return false;
	}
	public boolean updateBook(Book b) {
		int x=jtemp.update("update Book set BName=?,BAuthor=?,BCategory=?,BPrice=? where BID=? "
				,b.getBname(),
				b.getBauthor(),b.getBcategory(),b.getBprice(),b.getBid());
		if(x>0)
			return true;
		else
			return false;
	}
	public Book selectBook(Book b) {
	Book b1=jtemp.queryForObject("select * from Book where BID=?", 
				new Object[] {b.getBid()},new BeanPropertyRowMapper<>(Book.class));
		return b1;  
	}
	public List<Book>showall(){
		List<Book>l=new ArrayList<>();
		jtemp.query("select * from Book", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book b=new Book();
				b.setBid(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setBauthor(rs.getString(3));
				b.setBcategory(rs.getString(4));
				b.setBprice(rs.getFloat(5));
				l.add(b);
				return b;
			}
		});
		return l;
	}
	public boolean deletebook(Book b) {
		int x=jtemp.update("delete from Book where BID=?",b.getBid());
		if(x>0)
			return true;
		else
			return false;
		
		}
}