package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entities.User;

@Repository
public class adminDAOimp implements adminDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertUser(User u) {
		Session currentSession = sessionFactory.getCurrentSession();
		List <User> Users=printUser();
		
		for(User tempUser : Users) {
        	if( tempUser.getUserName().equals(u.getUserName()) && tempUser.getPassword().equals(u.getPassword()) ) {

        		return;
        	}
        }
		currentSession.save(u);
		
		
	}

	@Override
	@Transactional
	public List<User> printUser() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User", User.class);
		List<User> users = query.getResultList();
        return users;
	}

	@Override
	@Transactional
	public int modifyUser(User u, String userName) {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        int result;
        List<User> users = printUser(); 
        //check if employee exists
        
        for(User tempUser : users) {
        	if( tempUser.getUserName() == userName) {

        		//create query
        		Query query = currentSession.createQuery("UPDATE Users set Email= :email, Password= :password, Role= :role where UserName= :username");
                query.setParameter("username", userName);
                query.setParameter("email", u.getEmail());
                query.setParameter("password", u.getPassword());
                query.setParameter("role", u.getRole());

                
                result = query.executeUpdate();
                System.out.println("Rows affected: " + result);
                return result;
        	}
        }
        return -1;//this means that there is not that employee had he existed or there was an error in the data given result would be 0
    }
	

	@Override
	@Transactional
	public int deleteUser(String userName) {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        List<User> users = printUser(); 
        //check if employee exists
        for(User tempUser : users) {
        	if( tempUser.getUserName() == userName ) {
        		System.out.println("Employee found!\n");
        		Query query = currentSession.createQuery("delete User where UserName = :username");
                query.setParameter("username", userName);
                int result = query.executeUpdate();
                return result;
        	}
        }
        return -1;
	}

	
	
	
}