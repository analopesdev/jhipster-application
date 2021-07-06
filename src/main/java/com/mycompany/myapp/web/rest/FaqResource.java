package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Faq;
import com.mycompany.myapp.repository.FaqRepository;
import com.mycompany.myapp.security.AuthoritiesConstants;
import io.micrometer.core.annotation.Timed;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Transactional
@PreAuthorize(AuthoritiesConstants.ADMIN)
public class FaqResource {

    private final FaqRepository faqRepository;

    private FaqResource(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @PostMapping("/faqs")
    @ResponseStatus(HttpStatus.CREATED)
    @Timed
    public ResponseEntity<?> create(@Valid @RequestBody final Faq faq) {
        return faqRepository.save(faq);
    }
}
