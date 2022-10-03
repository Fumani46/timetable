package com.example.demo.api.service;

import com.example.demo.api.model.LoginUser;
import com.example.demo.api.model.RegisterUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LoginService {

    private Firestore db = FirestoreClient.getFirestore();

    public RegisterUser getRegisteredUsers(LoginUser loginUser) throws ExecutionException, InterruptedException {

        String email = loginUser.getEmail();
        String password = loginUser.getPassword();

        RegisterUser registerUser = new RegisterUser();

        Query student = db.collection("users").whereEqualTo("Email", email);
        ApiFuture<QuerySnapshot> querySnapshot = student.get();

        int record = querySnapshot.get().getDocuments().size();

        if (record == 1) {
            List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                if (email.equalsIgnoreCase(document.toObject(RegisterUser.class).getEmail())) {
                    registerUser = document.toObject(RegisterUser.class);
                }
            }
        } else {
            registerUser = null;
        }
        return registerUser;
    }
}
