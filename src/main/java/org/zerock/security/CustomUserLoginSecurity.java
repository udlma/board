package org.zerock.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Setter;

public class CustomUserLoginSecurity implements UserDetailsService {
	
	
	@Setter(onMethod_= {@Autowired})
	private MemberMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO vo = mapper.read(username);
		
		User user = new User(vo.getUid(), vo.getUpw(), vo.getAuthList().stream().
				map(authVO -> new SimpleGrantedAuthority(authVO.getAuth())).collect(Collectors.toList()));
		
		return user;
	}

}
