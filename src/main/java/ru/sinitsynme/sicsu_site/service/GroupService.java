package ru.sinitsynme.sicsu_site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.Group;
import ru.sinitsynme.sicsu_site.repository.GroupRepository;
import ru.sinitsynme.sicsu_site.entity.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups() { //add pagination
        return groupRepository.findAll(Sort.by(Direction.ASC, "groupFullId"));
    }

    public Group getByGroupFullId(String groupFullId) {
        return groupRepository.findByGroupFullId(groupFullId);
    }

    public void saveGroup(Group group) {
        groupRepository.save(group);
    }

    public void deleteByGroupId(Long id) {
        groupRepository.deleteById(id);
    }

    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }
//
//    public void addStudentToGroup(Group group, Student student) {
//        if (group.getStudents() == null) {
//            group.setStudents(new HashSet<>());
//        }
//        group.getStudents().add(student);
//    }


}
