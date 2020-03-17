package net.gondr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.gondr.domain.BoardVO;
import net.gondr.domain.CommentVO;
import net.gondr.domain.UserVO;
import net.gondr.service.CommentService;

@Controller
@RequestMapping(value="/comment/")
public class CommentController {
	
	@Autowired
	CommentService cService;
	
	@RequestMapping(value="write",method = RequestMethod.POST)
	public String write(CommentVO comment,BoardVO board,HttpSession session,RedirectAttributes rttr) {
		UserVO user = (UserVO)session.getAttribute("user");
		if(user == null) {
			rttr.addFlashAttribute("msg","댓글을 작성하기위해서는 로그인이 필요합니다");
			return "redirect:/board/view/"+board.getId();
		}
		System.out.println(comment.getContent());
		comment.setName(user.getUserid());
		comment.setProfile(user.getImg());
		comment.setBoardId((Integer)board.getId());
		cService.write(comment);
		
		return "redirect:/board/view/"+board.getId();
	}
	
}
