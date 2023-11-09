package com.example.chatbot.sec.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.chatbot.sec.dao.UtilisateurRepositoriy;
import com.example.chatbot.sec.entities.AppRole;
import com.example.chatbot.sec.entities.Utilisateur;

import jakarta.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private UtilisateurRepositoriy utilisateurRepositoriy;
    //private AppRoleRepositoriy appRoleRepositoriy;


    // @Override
    // public Utilisateur saveNewUser(String usernam, String password, String repassword) {
    //     Utilisateur savedAppUser= utilisateurRepositoriy.save(saveNewUser(usernam, password, repassword));
    //     return savedAppUser;
    // }

    // @Override
    // public AppRole saveNewRole(String roleName, String description) {
    //     AppRole appRole=appRoleRepositoriy.findByRoleName(roleName);
    //     return appRoleRepositoriy.save(appRole);
    // }

    // @Override
    // public Utilisateur loadUserByUsername(String username) {
    //     return utilisateurRepositoriy.findByUsername(username);
    // }

    // @Override
    // public void addRoleToUser(String username, String roleName) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addRoleToUser'");
    // }

    // @Override
    // public void removeRoleFromUser(String username, String roleName) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'removeRoleFromUser'");
    // }

    // @Override
    // public AppRole saveNewRole(String roleName, String description) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'saveNewRole'");
    // }
}
