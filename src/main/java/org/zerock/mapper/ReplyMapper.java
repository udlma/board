package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Critaria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	public int delete(Integer rno);
	public int update(ReplyVO vo);
	public ReplyVO read(Integer rno);
	public List<ReplyVO> list(@Param("cri") Critaria cri, @Param("bno") Integer bno);
	public int total(Integer bno);

}
