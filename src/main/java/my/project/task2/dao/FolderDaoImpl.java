package my.project.task2.dao;



import my.project.task2.model.Folder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class FolderDaoImpl implements FolderDao {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Folder folder) {
        Session session = sessionFactory.getCurrentSession();
        long save = (Long) session.save(folder);
        System.out.println(save);
    }


    public  List<Folder> getParent() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Folder where parent_id=: parent");
        query.setParameter("parent",0L);
        List list = query.getResultList();

        return list;}




    public void update(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("update Folder set name = :name where id = :id");
//
//        query.setParameter("name", "Nick");
//        query.setParameter("id", id);
//
//        int result = query.executeUpdate();
//        System.out.println(result);
    }

    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("delete Folder where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println(result);

    }

    public List<Folder> getChild(Long parent_id) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Folder where parent_id=: id");
        query.setParameter("id",parent_id);
        List childList = query.getResultList();
        return childList;}


    public List<Folder> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Folder");
        List list = query.getResultList();
        return list;}


    public void move(long id,long parent_id) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Folder set parent_id = :parent_id where id = :id");
        query.setParameter("parent_id", parent_id);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println(result);
    }

}
