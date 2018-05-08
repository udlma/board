package org.zerock.service;

import java.util.List;

import org.zerock.domain.Critaria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	public int create(ReplyVO vo);
	public int remove(Integer rno);
	public int modify(ReplyVO vo);
	public ReplyVO getView(Integer rno);
	public List<ReplyVO> getList(Critaria cri, Integer bno);
	public int getTotal(Integer bno);

}
