package com.example.mapper;

import java.util.List;

import javax.swing.border.Border;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.example.config.RootConfig.class })
//@ContextConfiguration("file:src/main/webapp/WEB-INF/root-context.xml")
@Log4j
@WebAppConfiguration
public class BoardMapperTest {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testPaging() {
		Criteria criteria = new Criteria();
		criteria.setPageNum(1);
		criteria.setAmount(5);

		List<BoardVO> list = mapper.getListWithPaging(criteria);
		list.forEach(board -> log.info(board));
	}

//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("���� �ۼ��ϴ� ��");
//		board.setContent("���� �ۼ��ϴ� ����");
//		board.setWriter("�� �ۼ���");
//
//		mapper.insert(board);
//
//		log.info(board);
//	}

//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("���� �ۼ��ϴ� �� select key");
//		board.setContent("���� �ۼ��ϴ� ���� select key");
//		board.setWriter("�� �ۼ��� select key");
//
//		mapper.insertSelectKey(board);
//
//		log.info(board);
//	}

//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(5L);
//		log.info(board);
//	}

//	@Test
//	public void testDelete() {
//		log.info("DELETE COUNT: " + mapper.delete(3L));
//	}

//	@Test
//	public void testUpdate() {
//		BoardVO board = new BoardVO();
//		board.setBno(5L);
//		board.setTitle("������ ����1");
//		board.setContent("������ ����1");
//		board.setWriter("������ �ۼ���1");
//
//		int count = mapper.update(board);
//		log.info("UPDATE COUNT: " + count);
//	}
}
