package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.UserProfile;
import com.mycompany.myapp.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {
    private UserProfileRepository repository;

    @Autowired
    public UserProfileService (UserProfileRepository repository) {
        this.repository = repository;
    }

    public UserProfile create(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    public UserProfile readById(Long id) {
        return repository.findById(id).get();
    }

    public List<UserProfile> readAll() {
        Iterable<UserProfile> allUserProfile = repository.findAll();
        List<UserProfile> userProfileList = new ArrayList<>();
        allUserProfile.forEach(userProfileList::add);
        return userProfileList;
    }

    public UserProfile update(Long id, UserProfile newUserProfileData) {
        UserProfile userProfileInDatabase = this.readById(id);
        userProfileInDatabase.setFirstName(newUserProfileData.getFirstName());
        userProfileInDatabase.setLastName(newUserProfileData.getLastName());
        userProfileInDatabase.setUserName(newUserProfileData.getUserName());
        userProfileInDatabase = repository.save(userProfileInDatabase);
        return userProfileInDatabase;
    }

    public UserProfile deleteById(Long id) {
        UserProfile userProfileToBeDeleted = this.readById(id);
        repository.delete(userProfileToBeDeleted);
        return userProfileToBeDeleted;
    }
}
