package com.example.supportdesk.Controller;

import com.example.supportdesk.Model.Request;
import com.example.supportdesk.Model.User;
import com.example.supportdesk.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.supportdesk.Service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "*")  // Allow all origins for testing purposes, configure for production
public class RequestController {

    @Autowired
    private final UserService userService;

    private final RequestService requestService;


    public RequestController(UserService userService, RequestService requestService) {
        this.userService = userService;
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        // Get the currently authenticated user
        User currentUser = userService.getCurrentUser();

        // Associate the user with the request
        request.setUser(currentUser);

        // Optionally override email and employeeName if you want:
        request.setEmail(currentUser.getEmail());
        request.setEmployeeName(currentUser.getName());

        Request savedRequest = requestService.saveRequest(request);
        return ResponseEntity.ok(savedRequest);
    }

    @GetMapping("/status-counts")
    public ResponseEntity<Map<String, Long>> getStatusCounts() {
        return ResponseEntity.ok(requestService.getStatusCounts());
    }

    @GetMapping("/user-count")
    public ResponseEntity<Map<String, Long>> getUniqueUserCount() {
        long count = requestService.getUniqueUserCount();
        return ResponseEntity.ok(Map.of("uniqueUsers", count));
    }

    // Get all requests
    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    // Update status of request
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateRequestStatus(@PathVariable Long id, @RequestBody StatusUpdate statusUpdate) {
        try {
            Request updatedRequest = requestService.updateStatus(id, statusUpdate.getStatus());
            return ResponseEntity.ok(updatedRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // DTO for status update
    public static class StatusUpdate {
        private String status;

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
