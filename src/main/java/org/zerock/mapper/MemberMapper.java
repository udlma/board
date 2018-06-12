package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	

	public MemberVO read(String uid);
}
