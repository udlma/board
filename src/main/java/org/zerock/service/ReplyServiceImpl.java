package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Critaria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_={@Autowired})
	ReplyMapper mapper;

	@Override
	public int create(ReplyVO vo) {
	
		return mapper.insert(vo);
	}

	@Override
	public int remove(Integer rno) {
		
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		return mapper.update(vo);
	}

	@Override
	public ReplyVO getView(Integer rno) {
		
		return mapper.read(rno);
	}

	@Override
	public List<ReplyVO> getList(Critaria cri, Integer bno) {
		
		return mapper.list(cri, bno);
	}

	@Override
	public int getTotal(Integer bno) {
		
		return mapper.total(bno);
	}
	

}
