package net.gondr.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gondr.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class BoardDAOTest {
	  @Autowired
	  private BoardDAO dao;
	  
//	  @Test
//	  public void createBoard() {
//		  BoardVO vo = new BoardVO();
//		  vo.setContent("글내용");
//		  vo.setTitle("글제목");
//		  vo.setWriter("해ㅜㅇ");
//		  
//		  dao.write(vo);
//	  }
//	  
//	  @Test
//	  public void readBoard() {
//		  BoardVO data = dao.view(25);
//		  
//		  System.out.println(data.getTitle());
//		  System.out.println(data.getContent());
//	  }
//	  
//	  @Test
//	  public void getListBoard() {
//		  List<BoardVO> list = dao.list();
//		  
//		  for(BoardVO board : list) {
//			  System.out.println(board.getTitle());
//		  }
//	  }
//	  
//	  @Test
//	  public void getCnt() {
//		  Integer cnt = dao.getCnt();
//		  System.out.println(cnt);
//	  }
//	  
//	  @Test
//	  public void update() {
//		  BoardVO data = dao.view(25);
//		  data.setTitle("수정된 제목입니다.");
//		  data.setContent("수정된 내용입니다.");
//		  dao.update(data);
//	  }
//	  
//	  @Test
	  public void delete() {
		  dao.delete(24);
	  }
}
