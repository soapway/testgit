package com.example.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.example.config.RootConfig.class })
public class BoardServiceTest {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;

//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}

//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("���� ���� �ۼ��ϴ� ��");
//		board.setContent("���� ���� �ۼ��ϴ� ����");
//		board.setWriter("���� �� �ۼ���");
//
//		service.register(board);
//
//		log.info("������ �Խù��� ��ȣ(bno) : " + board.getBno());
//	}

	@Test
	public void testGetList() {
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
//
//	@Test
//	public void testGet() {
//		log.info(service.get(1L));
//	}
//
//	@Test
//	public void testDelete() {
//		log.info("REMOVE RESULT : " + service.remove(22L));
//	}
//
//	@Test
//	public void testUpdate() {
//		BoardVO board = service.get(1L);
//		if (board == null) {
//			return;
//		}
//
//		board.setTitle("새로 고치는 제목");
//		log.info("MODIFY RESULT : " + service.modify(board));
//	}
}
