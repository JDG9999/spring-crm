package com.jdgamboa.customermanager.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdgamboa.customermanager.entity.Customer;

@Repository
public class CustomerDAOHibernate implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	public Customer getCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	public void deleteCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("DELETE FROM Customer WHERE id = :cID");
		query.setParameter("cID", id);
		query.executeUpdate();
	}

}
