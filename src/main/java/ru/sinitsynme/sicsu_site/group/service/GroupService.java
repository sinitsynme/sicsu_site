package ru.sinitsynme.sicsu_site.group.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.group.entity.Group;
import ru.sinitsynme.sicsu_site.group.repository.GroupRepository;

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

  public Optional<Group> getGroupById(Long id){
    return groupRepository.findById(id);
  }


}
