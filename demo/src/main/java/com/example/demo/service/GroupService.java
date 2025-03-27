package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    // Create or Update a Group
    public Group saveOrUpdateGroup(Group group) {
        return groupRepository.save(group);
    }

    // Get all Groups
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    // Get a Group by its ID
    public Optional<Group> getGroupById(Long groupId) {
        return groupRepository.findById(groupId);
    }

    // Delete a Group by its ID
    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
