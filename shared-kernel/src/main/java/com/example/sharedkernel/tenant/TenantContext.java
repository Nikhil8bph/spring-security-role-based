package com.example.sharedkernel.tenant;

public final class TenantContext {

    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();

    private TenantContext() {
    }

    public static void setTenantId(String tenantId) {
        if (tenantId == null || tenantId.isBlank()) {
            throw new IllegalArgumentException("Tenant ID must not be blank");
        }

        String normalizedTenantId = tenantId.trim();
        if (!normalizedTenantId.matches("[A-Za-z0-9_-]{1,64}")) {
            throw new IllegalArgumentException("Tenant ID contains invalid characters");
        }

        CURRENT_TENANT.set(normalizedTenantId);
    }

    public static String getTenantId() {
        return CURRENT_TENANT.get();
    }

    public static String requireTenantId() {
        String tenantId = getTenantId();
        if (tenantId == null) {
            throw new IllegalStateException("No tenant is associated with the current request");
        }
        return tenantId;
    }

    public static void clear() {
        CURRENT_TENANT.remove();
    }
}
