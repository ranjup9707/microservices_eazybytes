package com.eazybytes.loans.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("LOANS_MS");
    }
}
