package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Group;
import me.anisimov.teachingAccounting.dto.GroupDto;
import me.anisimov.teachingAccounting.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@Api(value = "GroupController",tags = {"Методы для работы с группами"})
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public GroupDto create(@RequestBody GroupDto groupDto){
        return groupService.createGroup(groupDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        groupService.deleteGroup(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Group group){
        groupService.updateGroup(group);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Group getById(Long id){
        return groupService.getById(id);
    }

    @GetMapping("/all")
    public List<Group> getAll(){
        return groupService.getAll();
    }
}
