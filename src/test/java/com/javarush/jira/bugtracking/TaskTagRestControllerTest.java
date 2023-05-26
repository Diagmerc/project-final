package com.javarush.jira.bugtracking;

import com.javarush.jira.AbstractControllerTest;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.javarush.jira.bugtracking.TaskTagRestController.REST_URL;
import static com.javarush.jira.common.util.JsonUtil.writeValue;
import static com.javarush.jira.login.internal.web.UserTestData.USER_MAIL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TaskTagRestControllerTest extends AbstractControllerTest {

    @Autowired
    TaskRepository taskRepository;

    private static final long TASK_ID = 2;

    @Test
    @WithUserDetails(value = USER_MAIL)
    void addTag() throws Exception {
        Set<String> tags = new HashSet<>(List.of("something"));

        perform(MockMvcRequestBuilders.put(REST_URL + "/{id}/tags", TASK_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(tags)))
                .andDo(print())
                .andExpect(status().isNoContent());

        Task task = taskRepository.getExisted(TASK_ID);
        assertThat(task.getTags()).usingRecursiveComparison().isEqualTo(tags);
    }
}