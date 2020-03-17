package net.gondr.service;

import java.util.List;

import net.gondr.domain.BoardVO;
import net.gondr.domain.CommentVO;
import net.gondr.domain.Criteria;

public interface CommentService {
	// 글을 쓰는 메서드
		public void write(CommentVO vo);

		// 글보기 메서드
		public BoardVO view(Integer id);

		// 글 리스트 보기(몇번부터 몇개를 볼 것인지)
		public 	List<CommentVO> list(Criteria cri);
		// 글 삭제
		public void delete(Integer id);

		// 글 수정
		public void update(CommentVO vo);
		
		//현재 글의 갯수
		public Integer getCnt(Criteria cri);
}
