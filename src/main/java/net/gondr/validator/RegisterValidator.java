package net.gondr.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import net.gondr.domain.RegisterDTO;
import net.gondr.util.MediaUtil;

public class RegisterValidator implements Validator{
	//비밀번호가 영문과 숫자로만 이루어지게 (영어로도 되고 숫자로도 되고 섞어도)
	
	private static final String passRegExp = "^[a-zA-Z0-9]+$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "userid", "required", "유저 아이디의 값은 필수입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "username", "required", "유저 이름은 필수입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "password", "required", "비밀번호 값은 필수입니다.");
		
		RegisterDTO dto = (RegisterDTO)target;
		if(!dto.getPassword().equals(dto.getPasswordConfirm())) {
			errors.rejectValue(
					"password", "bad", "비밀번호와 확인이 일치하지 않습니다.");
		}
		
		MultipartFile img = dto.getProfileImg();
		if(!img.getOriginalFilename().equals("")) {
			String filename = img.getOriginalFilename();
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			if(MediaUtil.getMediaType(ext) == null) {
				errors.rejectValue(
					"profileImg", "bad", 
					"프로필 이미지는 이미지 파일만 업로드 가능합니다");
			}
		}
		
	}
	
}
