package net.gondr.dao;

import java.util.List;

import net.gondr.domain.CommentVO;
import net.gondr.domain.Criteria;

public interface CommentDAO {
	

	public void write(CommentVO comment);
	
	
	public List<CommentVO> list(Criteria cr);

	public void delete(Integer id);
	
	public void update(CommentVO comment);
	
	public Integer getCnt(Criteria cri);
	
	
}
