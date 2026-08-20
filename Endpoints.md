# API Endpoints

Base path: `/api/v1`

Tenant-aware endpoints require:

```http
Authorization: Bearer <access-token>
X-Tenant-Id: tenant-a
Content-Type: application/json
```

## Authentication

### `POST /api/v1/auth/register`

Request body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "username": "john.doe",
  "password": "StrongPassword123!",
  "email": "john.doe@example.com",
  "mobileNumber": "+15550000001"
}
```

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "User registered successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "CREATED"
}
```

### `POST /api/v1/auth/login`

Request body:

```json
{
  "identifier": "john.doe",
  "password": "StrongPassword123!"
}
```

The `identifier` field accepts any one of the following:

```json
{
  "identifier": "john.doe",
  "password": "StrongPassword123!"
}
```

```json
{
  "identifier": "john.doe@example.com",
  "password": "StrongPassword123!"
}
```

```json
{
  "identifier": "+15550000001",
  "password": "StrongPassword123!"
}
```

Response body:

```json
{
  "data": {
    "accessToken": "<access-token>",
    "refreshToken": "<refresh-token>",
    "tokenType": "Bearer",
    "expiresIn": 3600,
    "user": {
      "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "firstName": "John",
      "lastName": "Doe",
      "username": "john.doe",
      "email": "john.doe@example.com",
      "mobileNumber": "+15550000001",
      "roles": []
    }
  },
  "message": "Login successful",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/auth/refresh-token`

Request body:

```json
{
  "refreshToken": "<refresh-token>"
}
```

Response body:

```json
{
  "data": {
    "accessToken": "<new-access-token>",
    "refreshToken": "<new-refresh-token>",
    "tokenType": "Bearer",
    "expiresIn": 3600
  },
  "message": "Token refreshed successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/auth/logout`

Request body:

```json
{
  "refreshToken": "<refresh-token>"
}
```

Response body:

```json
{
  "data": null,
  "message": "Logout successful",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `GET /api/v1/auth/me`

Request body: None

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "Authenticated user retrieved successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/auth/change-password`

Request body:

```json
{
  "currentPassword": "OldPassword123!",
  "newPassword": "NewStrongPassword123!"
}
```

Response body:

```json
{
  "data": null,
  "message": "Password changed successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/auth/forgot-password`

Request body:

```json
{
  "email": "john.doe@example.com"
}
```

Response body:

```json
{
  "data": null,
  "message": "If the account exists, password reset instructions have been sent",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "ACCEPTED"
}
```

### `POST /api/v1/auth/reset-password`

Request body:

```json
{
  "resetToken": "<reset-token>",
  "newPassword": "NewStrongPassword123!"
}
```

Response body:

```json
{
  "data": null,
  "message": "Password reset successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

## Users

### `POST /api/v1/users`

Request body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "username": "john.doe",
  "password": "StrongPassword123!",
  "email": "john.doe@example.com",
  "mobileNumber": "+15550000001",
  "roleIds": [
    "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7"
  ]
}
```

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "User created successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "CREATED"
}
```

### `GET /api/v1/users`

Query parameters:

```text
page=0&size=20&search=john&active=true
```

Request body: None

Response body:

```json
{
  "data": [
    {
      "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "firstName": "John",
      "lastName": "Doe",
      "username": "john.doe",
      "email": "john.doe@example.com",
      "mobileNumber": "+15550000001",
      "roles": []
    }
  ],
  "totalPages": 1,
  "totalRecords": 1,
  "currentPage": 0,
  "pageSize": 20
}
```

### `GET /api/v1/users/{userId}`

Request body: None

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "User retrieved successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `PUT /api/v1/users/{userId}`

Request body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "mobileNumber": "+15550000001"
}
```

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "User updated successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `DELETE /api/v1/users/{userId}`

Request body: None

Response body:

```json
{
  "data": null,
  "message": "User deleted successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/users/{userId}/restore`

Request body: None

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "User restored successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `PUT /api/v1/users/{userId}/roles`

Request body:

```json
{
  "roleIds": [
    "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7"
  ]
}
```

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "User roles replaced successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/users/{userId}/roles/{roleId}`

Request body: None

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "Role assigned successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `DELETE /api/v1/users/{userId}/roles/{roleId}`

Request body: None

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "Role removed successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

## Roles

### `POST /api/v1/roles`

Request body:

```json
{
  "name": "ADMIN",
  "roleLevel": 100,
  "description": "System administrator",
  "canDelete": true,
  "canUpdate": true
}
```

Response body:

```json
{
  "data": {
    "id": "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "name": "ADMIN",
    "roleLevel": 100,
    "description": "System administrator",
    "canDelete": true,
    "canUpdate": true
  },
  "message": "Role created successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "CREATED"
}
```

### `GET /api/v1/roles`

Query parameters:

```text
page=0&size=20&search=ADMIN&active=true
```

Request body: None

Response body:

```json
{
  "data": [
    {
      "id": "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "name": "ADMIN",
      "roleLevel": 100,
      "description": "System administrator",
      "canDelete": true,
      "canUpdate": true
    }
  ],
  "totalPages": 1,
  "totalRecords": 1,
  "currentPage": 0,
  "pageSize": 20
}
```

### `GET /api/v1/roles/{roleId}`

Request body: None

Response body:

```json
{
  "data": {
    "id": "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "name": "ADMIN",
    "roleLevel": 100,
    "description": "System administrator",
    "canDelete": true,
    "canUpdate": true
  },
  "message": "Role retrieved successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `PUT /api/v1/roles/{roleId}`

Request body:

```json
{
  "name": "ADMIN",
  "roleLevel": 100,
  "description": "Updated system administrator",
  "canDelete": true,
  "canUpdate": true
}
```

Response body:

```json
{
  "data": {
    "id": "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "name": "ADMIN",
    "roleLevel": 100,
    "description": "Updated system administrator",
    "canDelete": true,
    "canUpdate": true
  },
  "message": "Role updated successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `DELETE /api/v1/roles/{roleId}`

Request body: None

Response body:

```json
{
  "data": null,
  "message": "Role deleted successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/roles/{roleId}/restore`

Request body: None

Response body:

```json
{
  "data": {
    "id": "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "name": "ADMIN",
    "roleLevel": 100,
    "description": "System administrator",
    "canDelete": true,
    "canUpdate": true
  },
  "message": "Role restored successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `GET /api/v1/roles/{roleId}/users`

Query parameters:

```text
page=0&size=20
```

Request body: None

Response body:

```json
{
  "data": [
    {
      "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "firstName": "John",
      "lastName": "Doe",
      "username": "john.doe",
      "email": "john.doe@example.com",
      "mobileNumber": "+15550000001",
      "roles": []
    }
  ],
  "totalPages": 1,
  "totalRecords": 1,
  "currentPage": 0,
  "pageSize": 20
}
```

## Profile

### `GET /api/v1/profile`

Request body: None

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "Profile retrieved successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `PATCH /api/v1/profile`

Request body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "mobileNumber": "+15550000001"
}
```

Response body:

```json
{
  "data": {
    "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe",
    "email": "john.doe@example.com",
    "mobileNumber": "+15550000001",
    "roles": []
  },
  "message": "Profile updated successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

## Notifications

### `GET /api/v1/notifications`

Query parameters:

```text
page=0&size=20&unreadOnly=false
```

Request body: None

Response body:

```json
{
  "data": [
    {
      "id": "7c7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "title": "Welcome",
      "message": "Welcome to the platform",
      "type": "SYSTEM",
      "read": false,
      "createdDate": "2026-08-08T12:00:00Z"
    }
  ],
  "totalPages": 1,
  "totalRecords": 1,
  "currentPage": 0,
  "pageSize": 20
}
```

### `GET /api/v1/notifications/{notificationId}`

Request body: None

Response body:

```json
{
  "data": {
    "id": "7c7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "title": "Welcome",
    "message": "Welcome to the platform",
    "type": "SYSTEM",
    "read": false,
    "createdDate": "2026-08-08T12:00:00Z"
  },
  "message": "Notification retrieved successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `PATCH /api/v1/notifications/{notificationId}/read`

Request body: None

Response body:

```json
{
  "data": {
    "id": "7c7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "title": "Welcome",
    "message": "Welcome to the platform",
    "type": "SYSTEM",
    "read": true,
    "createdDate": "2026-08-08T12:00:00Z"
  },
  "message": "Notification marked as read",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `PATCH /api/v1/notifications/read-all`

Request body: None

Response body:

```json
{
  "data": {
    "updatedCount": 5
  },
  "message": "Notifications marked as read",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `DELETE /api/v1/notifications/{notificationId}`

Request body: None

Response body:

```json
{
  "data": null,
  "message": "Notification deleted successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "OK"
}
```

### `POST /api/v1/notifications`

Request body:

```json
{
  "recipientUserId": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
  "title": "Welcome",
  "message": "Welcome to the platform",
  "type": "SYSTEM"
}
```

Response body:

```json
{
  "data": {
    "id": "7c7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
    "title": "Welcome",
    "message": "Welcome to the platform",
    "type": "SYSTEM",
    "read": false,
    "createdDate": "2026-08-08T12:00:00Z"
  },
  "message": "Notification created successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "CREATED"
}
```

### `POST /api/v1/notifications/broadcast`

Request body:

```json
{
  "recipientUserIds": [
    "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7"
  ],
  "recipientRoleId": null,
  "title": "Maintenance",
  "message": "Scheduled maintenance tonight",
  "type": "SYSTEM"
}
```

Response body:

```json
{
  "data": {
    "createdCount": 1
  },
  "message": "Notification broadcast successfully",
  "error": null,
  "timestamp": "2026-08-08T12:00:00Z",
  "httpStatus": "ACCEPTED"
}
```

## Administration

### `GET /api/v1/admin/users`

Query parameters:

```text
page=0&size=20&search=john&includeDeleted=true
```

Request body: None

Response body:

```json
{
  "data": [
    {
      "id": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "firstName": "John",
      "lastName": "Doe",
      "username": "john.doe",
      "email": "john.doe@example.com",
      "mobileNumber": "+15550000001",
      "roles": [],
      "isDeleted": false,
      "isActive": true
    }
  ],
  "totalPages": 1,
  "totalRecords": 1,
  "currentPage": 0,
  "pageSize": 20
}
```

### `GET /api/v1/admin/roles`

Query parameters:

```text
page=0&size=20&search=ADMIN&includeDeleted=true
```

Request body: None

Response body:

```json
{
  "data": [
    {
      "id": "1a7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "name": "ADMIN",
      "roleLevel": 100,
      "description": "System administrator",
      "canDelete": true,
      "canUpdate": true,
      "isDeleted": false,
      "isActive": true
    }
  ],
  "totalPages": 1,
  "totalRecords": 1,
  "currentPage": 0,
  "pageSize": 20
}
```

### `GET /api/v1/admin/audit-logs`

Query parameters:

```text
page=0&size=20&entityType=USER&action=UPDATE&from=2026-08-01&to=2026-08-08
```

Request body: None

Response body:

```json
{
  "data": [
    {
      "id": "8d7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "entityType": "USER",
      "entityId": "2b7f8f44-4d1b-4c7c-a6d7-5bf4e42e76c7",
      "action": "UPDATE",
      "performedBy": "john.doe",
      "performedAt": "2026-08-08T12:00:00Z"
    }
  ],
  "totalPages": 1,
  "totalRecords": 1,
  "currentPage": 0,
  "pageSize": 20
}
```
