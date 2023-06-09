package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
@Transactional    //class becomes proxy coz of Transactional annotation
public class EmpDaoHibImpl implements EmpDao {

	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public String save(Emp e) {
		ht.persist(e);
		return "saved";
	}

	@Override
	public List<Emp> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		Emp e = ht.get(Emp.class, id);
		return e;
	}

}
