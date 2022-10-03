package com.example.demo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableSlot {
    String uniqueId;
    String Friday;
    String Monday;
    String Thursday;
    String Tuesday;
    String Wednesday;
}