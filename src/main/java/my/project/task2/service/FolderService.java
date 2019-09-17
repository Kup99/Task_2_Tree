package my.project.task2.service;

import my.project.task2.model.Folder;

import java.util.List;

/**
 * Created by 813632 on 05.09.2019.
 */
public interface FolderService {

    List<Folder> getAll();

    List<Folder> getParent();

    List<Folder> getChild(Long parent_id);

    void add(Folder folder);

    void update(long id);

    void delete(long id);

    void move(long id,long parent_id);

}

