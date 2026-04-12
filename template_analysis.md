# GitHub Project Template Analysis

## Template Comparison Table

| Feature | Team Planning | Kanban | Iterative Development |
|---|---|---|---|
| **Default Columns** | Title, Assignee, Status (To Do, In Progress, Done) | Backlog, Ready, In Progress, In Review, Done | Backlog, Current Iteration, In Progress, Done |
| **Layout** | Table (top to bottom only) | Board (left to right + top to bottom) | Board with iteration-based grouping |
| **WIP Limits** | Not built-in | Supported per column | Supported per iteration |
| **Automation** | Status updates via field changes | Status auto-updates via issue/PR events | Iteration tracking with auto-assignment |
| **Agile Suitability** | Moderate — better for resource planning | High — maps directly to Agile workflow stages | Very High — built for sprint-based development |
| **Best For** | Large teams with multiple sub-teams | Small to medium teams tracking task progress | Teams running formal sprints with complex features |

---

## Template Descriptions
![Templates](./Images/Screenshot%202026-04-11%20114819.png)
### Team Planning
This one is essentially a big table. You have your task title, who it is assigned to, and the status. It is clean and organized, but the issue is that everything lives in a single flat view. Once the task list gets long, it becomes hectic to track what is actually moving and what is stuck. It is better suited for situations where you have multiple sub-teams working in parallel — for example, a large software company where Team A handles authentication while Team B handles reporting. In that context, the table view gives management a clear overview. But for a focused development workflow, it is not the most practical choice.

### Kanban
This is where things get interesting. Unlike Team Planning, Kanban gives you both vertical and horizontal layout — tasks flow left to right across columns as they progress through the workflow. Each column represents a stage: Backlog, Ready, In Progress, In Review, Done. The focus here is on the *status* of the task, not just who owns it. You can see at a glance where things are moving and where they are getting stuck. It also supports WIP limits, which is important for keeping the team focused. For a project like this Library Management System, where we have a clear set of user stories to move through defined stages, Kanban fits naturally.

### Iterative Development
Honestly, this one is arguably the most aligned with how real-world software development works today. Every major software company operates iteratively — you cannot plan everything upfront for a complex system, so you break it down and build incrementally. The Iterative Development template supports this by grouping tasks into sprints or iterations. For example, if you are building a login feature, you need to think about account creation, credential storage, database retrieval, and authentication logic — all as sub-tasks within a single iteration. The template handles that layered structure well. The trade-off is that it requires a lot of upfront organization. If you are not disciplined about what goes into each iteration, it gets messy fast.

---

## Chosen Template: Kanban

**Kanban** was selected for this project for a few practical reasons.

First, this is a student project with one developer. The tasks of managing formal sprints in Iterative Development is not necessary it at this scale — it requires a level of planning discipline that makes more sense in a team environment with a dedicated Scrum Master or Product Owner.

Second, the Library Management System was already broken down into user stories in Assignment 6, and those stories map cleanly onto Kanban columns. Each story can move from Backlog → Ready → In Progress → In Review → Testing → Done without needing to be grouped into iterations.

Third, Kanban's visual layout makes it easy to spot bottlenecks. If five tasks are sitting in "In Progress" with nothing moving to "In Review," that is immediately visible on a Kanban board. That kind of transparency is one of the core principles of Agile — and Kanban delivers it simply and effectively.

Finally, two custom columns were added to the default template: **Testing** and **Blocked**. Testing was added to reflect the QA phase before tasks are marked complete, since the system has 19 functional test cases defined in prior assignments. Blocked was added to flag tasks that cannot move forward due to a dependency or unresolved issue — a common reality in any development workflow.

## Kanban Board Customization

The project board was built using GitHub's Kanban template and customized to better reflect the actual development workflow of the Library Management System.

### Custom Columns Added

**Testing**
Added to represent the QA phase before a task is marked complete. The system has 19 functional test cases defined in prior assignments, so tasks need a dedicated stage for validation before moving to Done.

**Blocked**
Added to surface tasks that cannot progress due to an unresolved dependency or technical issue. Rather than leaving blockers buried inside task descriptions, this column makes them immediately visible on the board.

### Other Customizations
- All issues are assigned to me as the only team memeber to reflect ownership of each task
- All issues are labelled **enhancement** since every user story represents a new system feature
- Labels are enabled as a visible field on the board so they appear directly on each card
