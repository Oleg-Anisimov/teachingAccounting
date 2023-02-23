package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Group;
import me.anisimov.teachingAccounting.dto.GroupDto;
import me.anisimov.teachingAccounting.repository.GroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ModelMapper mapper;

    public GroupDto createGroup(GroupDto groupDto){
        Group group = new Group();
        group.setGroupName(groupDto.getGroupName());
        group = groupRepository.save(group);
        return mapper.map(group, GroupDto.class);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }

    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    public Group getById(Long id) {
        return groupRepository.getReferenceById(id);
    }

    public List<Group> getAll() {
        return groupRepository.findAll();
    }
}
