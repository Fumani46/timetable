package com.example.demo.api.service;

import com.example.demo.api.model.RegisterUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class RegisterService {

    private Firestore db = FirestoreClient.getFirestore();

    public String WriteUser(RegisterUser registerUser) throws ExecutionException, InterruptedException, FirebaseAuthException {
//        ApiFuture<WriteResult> future = db.collection("users").document(registerUser.getUniqueId()).set(registerUser);
//
//        return future.get().getUpdateTime().toString();

        Query student = db.collection("users").whereEqualTo("Email", registerUser.getEmail());
        ApiFuture<QuerySnapshot> querySnapshot = student.get();

        int record = querySnapshot.get().getDocuments().size();

        if (record == 0) {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(registerUser.getEmail())
                    .setPassword(registerUser.getPassword());

            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            registerUser.setStudentID(userRecord.getUid());

            ApiFuture<WriteResult> future = db.collection("users").document(registerUser.getStudNo()).set(registerUser);
        } else {
            return "User Already Created";
        }
        return "User Created";
    }
}
