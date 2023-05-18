package com.javarush.jira.bugtracking;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = TaskTagRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskTagRestController {

    public static final String REST_URL = "/api/tasks";

    private final TaskService taskService;

    @PutMapping(value = "/{id}/tags", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Set<String> tags) {
        taskService.addTag(id, tags);
    }
}
