package net.gondr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gondr.dao.CommentDAO;
import net.gondr.domain.BoardVO;
import net.gondr.domain.CommentVO;
import net.gondr.domain.Criteria;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentDAO dao;

	@Override
	public void write(CommentVO vo) {
		dao.write(vo);
	}

	@Override
	public BoardVO view(Integer id) {
		return null;
	}

	@Override
	public List<CommentVO> list(Criteria cri) {
		return dao.list(cri);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public void update(CommentVO vo) {
		dao.update(vo);
	}

	@Override
	public Integer getCnt(Criteria cri) {
		return dao.getCnt(cri);
	}
	
	
	

}
