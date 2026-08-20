---
name: angular-enterprise-architect
description: Design, review, and scaffold scalable Angular applications using standalone components, signals, lazy-loaded feature slices, typed environments, functional interceptors and guards, and OnPush change detection.
---

# Angular Enterprise Architect

Use this skill for Angular frontend architecture, feature scaffolding, component design, routing, API integration, authentication UI, feature flags, and frontend code review.

## Application structure

Prefer a standalone, domain-oriented structure:

```text
src/
├── environments/
│   ├── environment.ts
│   ├── environment.development.ts
│   └── environment.prod.ts
└── app/
    ├── core/
    │   ├── guards/
    │   ├── interceptors/
    │   ├── services/
    │   └── constants/
    ├── shared/
    │   ├── components/
    │   ├── directives/
    │   ├── pipes/
    │   └── models/
    ├── layout/
    │   ├── header/
    │   ├── footer/
    │   ├── sidebar/
    │   └── main-layout/
    └── features/
        └── <feature-name>/
            ├── components/
            ├── pages/
            ├── services/
            ├── models/
            └── <feature>.routes.ts
```

- `core` contains singleton application infrastructure only.
- `shared` contains reusable, domain-neutral UI and utilities.
- `layout` contains the application shell.
- `features` contain lazy-loaded domain slices and their feature-specific data access.
- Keep smart/container route pages separate from reusable presentational components.
- Do not create a global shared module that becomes a dumping ground for feature logic.

## Standalone and modern Angular defaults

- Use standalone components, directives, and pipes for new code.
- Use `ChangeDetectionStrategy.OnPush` on every component unless there is a documented reason not to.
- Prefer `inject()` over constructor injection in new services, guards, interceptors, and components.
- Prefer signal inputs and outputs (`input()`, `input.required()`, `output()`, and `model()`) over decorator-based inputs and outputs in new components.
- Use built-in control flow (`@if`, `@for`, and `@defer`) instead of legacy structural directives in new templates.
- Track repeated items by stable identity: `@for (item of items; track item.id)`.
- Keep templates declarative. Move expensive or derived logic into computed signals or pipes.
- Avoid direct subscriptions in components. Prefer the `async` pipe, `take(1)`, or `takeUntilDestroyed()`.

## Environment and API configuration

Keep API base URLs, third-party public identifiers, feature flags, and environment-specific toggles in environment files. Do not hardcode URLs inside components or services.

Example:

```typescript
export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:8080/api/v1',
  authUrl: 'http://localhost:8080/api/v1/auth',
  features: {
    enableAnalytics: false,
    enableBetaDashboard: true,
    enableExportPdf: true,
    mockData: true
  }
} as const;
```

Centralize endpoint construction in a typed constant:

```typescript
import { environment } from '../../../environments/environment';

export const API_ENDPOINTS = {
  auth: {
    login: `${environment.authUrl}/login`,
    register: `${environment.authUrl}/register`,
    refresh: `${environment.authUrl}/refresh-token`,
    logout: `${environment.authUrl}/logout`
  },
  users: {
    base: `${environment.apiBaseUrl}/users`,
    byId: (id: string) => `${environment.apiBaseUrl}/users/${id}`
  }
} as const;
```

Never commit private secrets to environment files. Public browser configuration is not a secret; server credentials must not be placed in the frontend bundle.

## Angular CLI scaffolding

Use precise CLI commands and place generated files in the intended domain directory:

```bash
ng g c features/<feature-name>/pages/<page-name> --standalone --change-detection=OnPush
ng g c features/<feature-name>/components/<component-name> --standalone --change-detection=OnPush
ng g c shared/components/<component-name> --standalone --change-detection=OnPush
ng g c layout/<component-name> --standalone --change-detection=OnPush
ng g s core/services/<service-name>/<service-name>
ng g s features/<feature-name>/services/<service-name>
ng g interceptor core/interceptors/auth --functional
ng g interceptor core/interceptors/error-handler --functional
ng g guard core/guards/auth --functional
ng g guard core/guards/role --functional
ng g guard core/guards/feature-toggle --functional
ng g directive shared/directives/feature-toggle --standalone
ng g pipe shared/pipes/<pipe-name> --standalone
ng g interface features/<feature-name>/models/<model-name>.model
```

Do not generate modules or NgModule-based components for a standalone application unless the existing codebase requires them.

## Routing and lazy loading

Keep feature routes close to their feature and lazy-load them from the application route configuration. Protect routes with functional guards and keep authorization decisions in a dedicated policy/service rather than scattering role checks through templates.

Use route-level providers for feature-specific dependencies when they do not need application-wide lifetime. Use resolvers sparingly; prefer loading state in the feature page when it makes the flow easier to retry and test.

## Signals and feature toggles

Use signals for local UI state and derived state. Keep server state in the chosen data-access/cache layer and avoid duplicating the same state in unrelated services.

Feature keys should be typed from the environment configuration:

```typescript
export type FeatureKey = keyof typeof environment.features;
```

A feature-toggle service can expose both synchronous checks and computed signals:

```typescript
@Injectable({ providedIn: 'root' })
export class FeatureToggleService {
  private readonly flags = signal({ ...environment.features });

  isEnabled(feature: FeatureKey | string): boolean {
    return !!this.flags()[feature];
  }

  isEnabledSignal(feature: FeatureKey | string) {
    return computed(() => !!this.flags()[feature]);
  }

  setFeature(feature: string, enabled: boolean): void {
    this.flags.update(current => ({ ...current, [feature]: enabled }));
  }
}
```

Use feature toggles consistently in route guards, component rendering, and service behavior. Treat client-side feature flags as presentation controls, not security authorization.

## Functional HTTP interceptors

Register interceptors with `provideHttpClient(withInterceptors([...]))`.

Authentication interceptor:

```typescript
export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const auth = inject(AuthService);
  const token = auth.getToken();

  if (!token || req.headers.has('Authorization')) {
    return next(req);
  }

  return next(req.clone({
    headers: req.headers.set('Authorization', `Bearer ${token}`)
  }));
};
```

An error interceptor should preserve the original error for callers while translating the API error envelope into a user-facing notification. Avoid showing sensitive server details directly to users.

For refresh-token handling, prevent concurrent refresh requests from creating multiple token rotations. Queue or share the refresh request and retry the original requests only after a successful refresh. On refresh failure, clear credentials and navigate to login.

## Functional guards

Use functional guards for authentication, role access, feature availability, and unsaved changes. A guard should return a boolean, `UrlTree`, or observable/promise of those values; it should not perform unrelated data mutation.

Example feature guard shape:

```typescript
export const featureToggleGuard = (
  feature: FeatureKey | string,
  redirectTo = '/'
): CanActivateFn => {
  return () => {
    const featureService = inject(FeatureToggleService);
    const router = inject(Router);

    return featureService.isEnabled(feature)
      ? true
      : router.parseUrl(redirectTo);
  };
};
```

Route guards improve navigation behavior but are not a security boundary. The backend must enforce authorization independently.

## Component design

- Page components coordinate route state, loading, errors, and feature services.
- Presentational components receive data and emit user intent; they should not know API URLs or authentication storage details.
- Prefer typed models and discriminated unions for complex UI states.
- Expose loading, empty, error, and retry states explicitly.
- Use accessible semantic HTML, labels, keyboard interactions, and focus management for dialogs and navigation.
- Avoid putting business workflows into templates or shared UI components.

## API models and response handling

Define reusable interfaces for the backend response envelope and pagination metadata. Keep API DTOs separate from view models when the UI needs a different shape.

Normalize API errors in one place so feature services do not each parse status codes and message formats independently. Preserve correlation/request IDs when the backend provides them.

## Review checklist

- Feature routes are lazy-loaded and feature code is not placed in `core`.
- New components are standalone and use `OnPush`.
- Templates use modern control flow and stable tracking.
- API URLs are sourced from environment configuration and endpoint constants.
- Authentication, error, and loading behavior is handled through functional interceptors.
- Guards are functional and do not replace backend authorization.
- Signals are used for local/derived UI state without creating duplicate server state.
- Subscriptions are managed with `async`, `take(1)`, or `takeUntilDestroyed()`.
- Feature flags are typed and are not treated as security controls.
- Passwords, private keys, and server credentials are absent from the client bundle.
- Components are accessible and expose loading, empty, error, and retry states.
