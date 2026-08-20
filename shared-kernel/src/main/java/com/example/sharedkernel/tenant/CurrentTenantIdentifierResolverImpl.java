package com.example.sharedkernel.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver<String> {

    @Override
    public String resolveCurrentTenantIdentifier() {
        return TenantContext.requireTenantId();
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
