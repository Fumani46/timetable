package com.example.demo.api.service;

import com.example.demo.api.model.Course;
import com.example.demo.api.model.CourseModule;
import com.example.demo.api.model.TimetableSlot;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
@Service
public class TimetableService {

    private Firestore db = FirestoreClient.getFirestore();

//    public CourseModule getCourseModule(String uniqueID) throws ExecutionException, InterruptedException {
//        CourseModule courseModule = new CourseModule();
//        DocumentReference docRef = db.collection("modules").document(uniqueID);
//
//        ApiFuture<DocumentSnapshot> future = docRef.get();
//
//        DocumentSnapshot document = future.get();
//         courseModule = null;
//        if (document.exists()) {
//
//            courseModule = document.toObject(CourseModule.class);
//            System.out.println(courseModule);
//        } else {
//            System.out.println("No such document!");
//        }
//        return courseModule;
//    }

    public Course getCourseData(String uniqueID) throws ExecutionException, InterruptedException {
        Course course = new Course();
        DocumentReference docRef = db.collection("course").document(uniqueID);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();
        course= null;
        if (document.exists()) {

            course = document.toObject(Course.class);
            System.out.println(course);
        } else {
            System.out.println("No such document!");
        }

        return course;
    }

    public ArrayList<CourseModule> getCourseModules(String course_id) throws ExecutionException, InterruptedException {
        ArrayList<CourseModule> courseModules = new ArrayList<>();
        CourseModule courseModule = new CourseModule();

        //Query user = db.collection("modules").whereEqualTo("course_id", course_id);
        //ApiFuture<QuerySnapshot> querySnapshotApiFuture = user.get();
        //List<QueryDocumentSnapshot> documents = querySnapshotApiFuture.get().getDocuments();
        //for (DocumentSnapshot document : documents) {
          //  courseModule = document.toObject(CourseModule.class);
            //System.out.println(courseModule);
            //courseModules.add(courseModule);
        //}



        ApiFuture<QuerySnapshot> future = db.collection("modules").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            courseModule = document.toObject(CourseModule.class);
           if(courseModule.getCourse_id().equals(course_id)) {
               courseModules.add(courseModule);
           }
        }
        System.out.println(courseModules);

       return courseModules;

    }

    public TimetableSlot getTimetableSlot(String uniqueID) throws ExecutionException, InterruptedException {
        TimetableSlot timetableSlot = new TimetableSlot();
        DocumentReference docRef = db.collection("TimetableSlots").document(uniqueID);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        if (document.exists()) {
            timetableSlot = document.toObject(TimetableSlot.class);
        }
        return timetableSlot;
    }
}
