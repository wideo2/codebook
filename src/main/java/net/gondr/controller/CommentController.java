package net.gondr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.gondr.domain.BoardVO;
import net.gondr.domain.CommentVO;
import net.gondr.domain.ExpData;
import net.gondr.domain.UserVO;
import net.gondr.service.CommentService;
import net.gondr.service.UserService;

@Controller
@RequestMapping(value = "/comment/")
public class CommentController {

	@Autowired
	CommentService cService;

	@Autowired
	UserService uService;

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(CommentVO comment, BoardVO board, HttpSession session, RedirectAttributes rttr,@RequestParam String type) {
		
		UserVO user = (UserVO) session.getAttribute("user");
		if (user == null) {
			rttr.addFlashAttribute("msg", "댓글을 작성하기위해서는 로그인이 필요합니다.");
			return "redirect:/"+type+"/view/" + board.getId();
		}
		
		if (board.getContent().equals("")) {
			rttr.addFlashAttribute("msg", "글을 작성해야합니다.");
			return "redirect:/"+type+"/view/" + board.getId();
		}

		System.out.println(comment.getContent());
		comment.setName(user.getUserid());
		comment.setProfile(user.getImg());
		comment.setLevel(user.getLevel());
		comment.setBoardId((Integer) board.getId());
		comment.setType(type);
		cService.write(comment);
		uService.addExp(user.getUserid(), ExpData.SMALL);
		return "redirect:/"+type+"/view/" + board.getId();
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id) {

		String value[] = id.split("_");
		Integer commentId = Integer.parseInt(value[0]);
		int boardId = Integer.parseInt(value[1]);
		String type = value[2];
		cService.delete(commentId);
		return "redirect:/"+type+"/view/" + boardId;
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable String id,CommentVO comment) {
		String value[] = id.split("_");
		Integer commentId = Integer.parseInt(value[0]);
		int boardId = Integer.parseInt(value[1]);
		comment.setValue(commentId);
		
		String type = value[2];
		cService.update(comment);
		return "redirect:/"+type+"/view/" + boardId;
	}
}
