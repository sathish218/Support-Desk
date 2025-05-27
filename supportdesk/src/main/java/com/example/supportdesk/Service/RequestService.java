package com.example.supportdesk.Service;

import com.example.supportdesk.Model.Request;
import com.example.supportdesk.Repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    // Get counts of requests grouped by status
    public Map<String, Long> getStatusCounts() {
        List<Request> allRequests = requestRepository.findAll();

        return allRequests.stream()
                .collect(Collectors.groupingBy(
                        req -> req.getStatus().toLowerCase(),
                        Collectors.counting()
                ));
    }
    // Get count of unique users who submitted requests
    public long getUniqueUserCount() {
        List<Request> allRequests = requestRepository.findAll();

        return allRequests.stream()
                .map(Request::getEmail)
                .distinct()
                .count();
    }

    // Save or create a new request
    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    // Get all requests
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    // Get request by ID
    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    // Update the status of a request by its ID
    public Request updateStatus(Long id, String status) {
        return requestRepository.findById(id)
                .map(request -> {
                    request.setStatus(status);
                    return requestRepository.save(request);
                })
                .orElseThrow(() -> new RuntimeException("Request with id " + id + " not found."));
    }
}
