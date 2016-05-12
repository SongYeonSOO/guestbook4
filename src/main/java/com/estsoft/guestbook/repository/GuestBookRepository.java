package com.estsoft.guestbook.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;

@Repository
public class GuestBookRepository {

	// bean 설정에 manager를 만든 적은 없었다! -> autowired 불가능
	@PersistenceContext // entityManager를 주입하자!
	private EntityManager em;
	
	public void save(Guestbook guestbook) {
		guestbook.setRegDate(new Date());
		em.persist(guestbook); // guestbook은 controller에서 왔음 --> guestbook은 영속화
								// 되어있음 ; 다시 빼서 줄 필요가 없음
	}

	public List<Guestbook> findAll() {
		TypedQuery<Guestbook> query= em.createQuery("select gb from Guestbook gb", Guestbook.class);
		List<Guestbook> list = query.getResultList();
		return list;
	}

	public Boolean remove(Guestbook guestbook) {
		
		TypedQuery<Guestbook> query= em.createQuery("select gb from Guestbook gb where gb.no=:no and gb.password =:password", Guestbook.class);
		query.setParameter("no", guestbook.getNo());
		
		query.setParameter("password", guestbook.getPassword());
		
		for(Guestbook guestbook2: query.getResultList()){
			System.out.println(guestbook2);
			if(guestbook2.getNo() == guestbook.getNo()){
				em.remove(guestbook2);
				return true;
			}
		}
	
		return false;
	}

}
