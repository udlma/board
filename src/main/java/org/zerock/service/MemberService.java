package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {
	
	public MemberVO getLogin(String uid, String upw);

}
