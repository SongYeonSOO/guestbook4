package com.estsoft.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;
import com.estsoft.guestbook.repository.GuestBookRepository;

@Service
@Transactional
public class GuestBookService {

	@Autowired
	private GuestBookRepository guestbookRepository;

	public void insert(Guestbook guestbook) {
		guestbookRepository.save(guestbook);
	}

	public Boolean delete(Guestbook guestbook) {
		return guestbookRepository.remove(guestbook);
	}

	public List<Guestbook> getList() {
		return guestbookRepository.findAll();
	}

}
