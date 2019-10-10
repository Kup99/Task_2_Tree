package my.project.task2.service;

import my.project.task2.dao.FolderDao;
import my.project.task2.model.Folder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FolderServiceImpl implements FolderService {

    @Autowired
    public FolderDao folderDao;

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    public List<Folder> getParent() {
        return folderDao.getParent();
    }

    public void add(Folder folder) {
        folderDao.add(folder);

    }

    public void update(long id) {

    }

    public void delete(long id) {
        folderDao.delete(id);

    }

    public List<Folder> getChild(Long parent_id) {
        return folderDao.getChild(parent_id);
    }


    public List<Folder> getAll() {
     return folderDao.getAll();

}

    public void move(long id,long parent_id) {
        folderDao.move(id,parent_id);
    }

}
