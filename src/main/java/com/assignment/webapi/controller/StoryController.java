package com.assignment.webapi.controller;

import com.assignment.webapi.model.Story;
import com.assignment.webapi.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryController {
    @Autowired
    private StoryService storyService;

    @GetMapping("/getTimeStories")
    public ResponseEntity<?> getTimeStories(){
        List<Story> latestStories = storyService.getTimeStories();
        return ResponseEntity.ok(latestStories);
    }
}
