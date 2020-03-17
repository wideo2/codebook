package net.gondr.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gondr.domain.CommentVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class CommentDAOTest {
	
	@Autowired
	private CommentDAO dao;
	
//	@Test
//	public void write() {
//		CommentVO vo = new CommentVO();
//		vo.setContent("123");
//		vo.setBoardId(111);
//		vo.setName("wideo2");
//		vo.setProfile("asg");
//		
//		dao.write(vo);
//	}
	
//	@Test
//	public void delete() {
//		dao.delete(2);
//	}
	
//	
//	@Test
//	public void update() {
//		CommentVO vo = new CommentVO();
//		vo.setContent("111");
//		
//		dao.update(vo);
//	}
 	
}
