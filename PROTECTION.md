# Branch Protection Rules

### 1. Require Pull Request Reviews (at least 1 approval)

No code can be merged directly into `main` - it must go through a Pull Request and receive at least one approving review before it is eligible to merge.
 Code review is the single most effective way to catch bugs, logic errors, and design problems before they reach production. Even on a solo project, writing a PR description forces you to think critically about what you changed and why.

### 2. Require Status Checks to Pass (CI workflow must be green)

The `Build & Test` job from the CI/CD pipeline must complete successfully before a PR can be merged. GitHub blocks the merge button until the check passes.
This guarantees that broken code never lands on `main`. The test suite acts as an automated gatekeeper that enforces correctness 24/7, without relying on anyone remembering to run tests manually.


### 3. Disable Direct Pushes to `main`

No one — including repository owners — can push commits directly to `main`. All
changes must come through a reviewed and tested Pull Request.
Direct pushes bypass both code review and CI, making them the fastest way to introduce
regressions. Disabling them ensures the protection rules above can never be accidentally
(or intentionally) circumvented. It enforces a clean, auditable history where every
change to `main` is traceable to a reviewed PR.
