package it.docSys.services;


import it.docSys.model.Document;
import it.docSys.model.GroupEntity;
import it.docSys.DTO.GroupGetDTO;
import it.docSys.DTO.GroupPutDTO;
import it.docSys.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GroupService {

    @Autowired
    private GroupRepo groupRepo;

    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }


    @Transactional
    public List<GroupGetDTO> getAllGroups() {
        return groupRepo.findAll().stream().map(groupEntity ->
                new GroupGetDTO(groupEntity.getTitle())).collect(Collectors.toList()); //cannot resolve constructor????????
    }


    @Transactional
    public void saveGroup (GroupPutDTO putDTO) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setTitle(putDTO.getTitle());
        groupRepo.save(groupEntity);
    }


    @Transactional
    public void deleteGroup(String title) { //kai istrini grupa, neturi dingti juseriai is DB.
        groupRepo.deleteByTitle(title);
    }


    @Transactional
    public void updateGroup(String title, GroupPutDTO putDTO) {
        GroupEntity groupEntity = groupRepo.findByTitle(title);
        if (groupEntity != null) {
            groupEntity.setTitle(putDTO.getTitle());
        }
    } //TODO padaryti, kad mestu exception jei null ivestas ir pan!!!!!!!!!!!!!!!!!!!!!!!!

}
