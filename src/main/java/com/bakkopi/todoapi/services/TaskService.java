package com.bakkopi.todoapi.services;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.Task.TaskStatus;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.repositories.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@Validated
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TagService tagService;

    public Task createNewTask(@Valid Task task) {
        // Fetch User with the given User ID
        task.setUser(userService.getUserById(task.getUser().getId()));
        return taskRepository.save(task);
    }

    public Task addTagToTask(Long taskId, @Valid Tag tag) {
        Tag existingTag = tagService.getTagById(tag.getId());
        Task task = getTaskById(taskId);
        task.getTags().add(existingTag);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getCurrentUserTasks() {
        return taskRepository.findByUser(userService.getCurrentUser());
    }

    public List<Task> getTasksByCondition(
            Set<Tag> tags,
            LocalDate dueDate,
            TaskStatus status,
            String sortBy,
            boolean sortAscend
    ) {
        // Collection for search results
        List<Task> searchTasks;

        if (sortBy != null) {
            searchTasks = getSortedTasks(sortBy, sortAscend);
        } else {
            searchTasks = taskRepository.findAll();
        }

        if (tags != null && !tags.isEmpty()) {
            searchTasks.retainAll(taskRepository.findByTagsIn(tags));
        }

        if (dueDate != null) {
            searchTasks.retainAll(taskRepository.findByDueDateEquals(dueDate));
        }

        if (status != null) {
            searchTasks.retainAll(taskRepository.findByStatusEquals(status));
        }

        return searchTasks;
    }

    private List<Task> getSortedTasks(String sortBy, boolean sortAscend) {
        switch (sortBy.toLowerCase()) {
            case "duedate":
                return sortAscend ?
                        taskRepository.findAllByOrderByDueDateAsc() :
                        taskRepository.findAllByOrderByDueDateDesc();

            case "status":
                return sortAscend ?
                        taskRepository.findAllByOrderByStatusAsc() :
                        taskRepository.findAllByOrderByStatusDesc();

            case "taskname":
                return sortAscend ?
                        taskRepository.findAllByOrderByTaskNameAsc() :
                        taskRepository.findAllByOrderByTaskNameDesc();

            default:
                throw new IllegalArgumentException("Invalid sortBy parameter: " + sortBy);
        }
    }

    public List<Task> getTasksByUsername(String username) {
        return taskRepository.findByUserUsername(username);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
