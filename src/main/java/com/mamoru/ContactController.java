package com.mamoru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 6/26/2017.
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactRepository repository;

    @Autowired
    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Contact getContacts(@RequestBody Contact contact) {
            return convertDtoToContact(repository.findAllByName(contact.getName()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Contact update(@RequestBody Contact contact) {

        List<ContactDTO> contactDTOList = convertContactToDto(contact);
        repository.save(contactDTOList);
        return contact;
    }

    public Contact convertDtoToContact(List<ContactDTO> list) {
        Contact contact = new Contact();
        contact.setName(list.get(0).getName());
        contact.setPhones(list.stream().map(c -> c.getPhone()).collect(Collectors.joining(",")));
        return contact;
    }

    public List<ContactDTO> convertContactToDto(Contact contact) {
        List<String> phones = Arrays.asList(contact.getPhones().split(","));
        List<ContactDTO> contactDTOList = new ArrayList<>();
        phones.forEach(p -> {
            contactDTOList.add(new ContactDTO(contact.getName(), p));
        });
        return contactDTOList;
    }

}
