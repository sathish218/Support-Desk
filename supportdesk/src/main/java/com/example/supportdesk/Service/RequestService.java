package com.example.supportdesk.Service;

import com.example.supportdesk.Model.Request;
import com.example.supportdesk.Repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
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
