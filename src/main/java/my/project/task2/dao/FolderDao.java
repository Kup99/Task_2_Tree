package my.project.task2.dao;



import my.project.task2.model.Folder;

import java.util.List;


public interface FolderDao {

    List<Folder> getAll();

    List<Folder> getParent();

    List<Folder> getChild(Long parent_id);

    void add(Folder folder);

    void update(String name);

    void delete(long id);

    void move(long id,long parent_id);


}
