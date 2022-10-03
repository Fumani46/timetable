package com.example.demo.api.model;

import lombok.*;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseModule {
    private String course_id;
    private String lect_id;
    private String location;
    private String module_id;
    private String module_name;
    private String stream_link;
    private String uniqueID;

}