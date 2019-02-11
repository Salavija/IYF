package it.docSys.services;


import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.model.GroupEntity;
import it.docSys.DTO.GroupGetDTO;
import it.docSys.DTO.GroupPutDTO;
import it.docSys.repository.DocTypeRepo;
import it.docSys.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GroupService { //TODO pasitikrinti susiejima su sarysiais ir per Autowired, pagal pavyzdi.

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private DocTypeRepo docTypeRepo;

    public GroupService(GroupRepo groupRepo, DocTypeRepo docTypeRepo) {
        this.groupRepo = groupRepo;
        this.docTypeRepo = docTypeRepo;
    }

    @Transactional
    public List<GroupGetDTO> getAllGroups() {
        return groupRepo.findAll().stream().map(groupEntity ->
                new GroupGetDTO(groupEntity.getTitle())).collect(Collectors.toList()); //cannot resolve constructor????????
    }


    @Transactional
    public GroupGetDTO getGroupById (Long id) { //TODO kada Long, o kada long?????
        GroupEntity group = groupRepo.findById(id).orElse(null);
        if (group != null) {
            return new GroupGetDTO(group.getTitle());
        }
        return null;
    }


    @Transactional
    public GroupGetDTO getGroupByTitle (String title) {
        GroupEntity group = groupRepo.findByTitle(title);
        if (group != null) {
            return new GroupGetDTO(group.getTitle());
        }
        return null;
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


    /*Visu dokumentu tipu priklausanciu grupei suradimas*/ /*String title yra grupes title, ateina is controlerio*/

    @Transactional
    public List<DocTypeGetDTO> getGroupDocTypes (String title) { //TODO ar tikrai su title???
        GroupEntity group = groupRepo.findByTitle(title);
        if (group != null) {
            return group.getDocTypes().stream().map(docType ->
                    new DocTypeGetDTO(docType.getTitle())).collect(Collectors.toList());
        }
        return  null;
    }

    //TODO?? AR REIKIA PRISKYRIMO doko tipo grupei???

}
