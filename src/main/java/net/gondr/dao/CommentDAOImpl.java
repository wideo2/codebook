package net.gondr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.gondr.domain.CommentVO;
import net.gondr.domain.Criteria;

@Repository
public class CommentDAOImpl implements CommentDAO{

	@Autowired
	private SqlSession session;
	
	
	private final String namespace = "net.gondr.mappers.CommentMapper";
	
	@Override
	public void write(CommentVO comment) {
		session.insert(namespace+".write",comment);
	}

	@Override
	public List<CommentVO> list(Criteria cr) {
		return session.selectList(namespace+".list",cr);
	}

	@Override
	public void delete(Integer id) {
		session.delete(namespace+".delete",id);
	}

	@Override
	public void update(CommentVO comment) {
		session.update(namespace+".update",comment);
	}

	@Override
	public Integer getCnt(Criteria cri) {
		
		return session.selectOne(namespace+".cnt",cri);
		
	}

}
