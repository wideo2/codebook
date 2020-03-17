package net.gondr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gondr.dao.UserDAO;
import net.gondr.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public UserVO login(String userid, String password) {
		return dao.loginUser(userid, password);
	}

	@Override
	public void register(UserVO user) {
		dao.insertUser(user);
	}

	@Override
	public UserVO getUserInfo(String userid) {
		return dao.getUser(userid);
	}

	@Override
	public void fillLevelTable(Integer max) {
		dao.deleteLevelTable();
		
		for(int i = 1; i <= max; i++) {
			Integer exp = (int)Math.floor(Math.pow(((double)i-1) * 50 / 49, 2.5)*10);
			dao.insertLevelData(i, exp);
		}
	}

	@Override
	public UserVO addExp(String userid, Integer exp) {
		UserVO user = dao.getUser(userid);
		user.setExp(user.getExp() + exp);
		System.out.println(user.getLevel());
		Integer requireExp = dao.getRequireExp(user.getLevel() + 1);
		System.out.println(requireExp);
		if(user.getExp() >= requireExp) {
			user.setExp(user.getExp() - requireExp);
			user.setLevel(user.getLevel() + 1);
			
		}
		
		// 경험치 증가 처리후 db 저장
		dao.setLevelAndExp(user);
		return null;
	}

}
