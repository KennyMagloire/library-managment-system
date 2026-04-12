# Kanban Board Explanation

## What is a Kanban Board?

A Kanban board is a visual software project management tool that tracks tasks as they move through different stages of a workflow in a software development lifecycle. The concept is straightforward: tasks are represented as cards on a board, and each column represents a stage — at minimum, To Do, In Progress, and Done. As work progresses, cards move from left to right until they reach completion.

What makes Kanban stand out is its simplicity. Unlike Scrum, which organizes work into formal sprints with planning sessions, reviews, and multiple delivery increments, Kanban does not enforce that structure. There are no fixed cycles and no rigid ceremonies. The focus is on continuous flow — you complete one task before picking up the next. This keeps the workload manageable and the board an accurate reflection of what is actually happening at any point in time.

---

## Board explanation

![Kanban Board](./Images/Screenshot%202026-04-11%20114819.pngimages)
Our board for the Library Management System uses the following columns:

**Backlog → In Progress → Testing → Done**

With **Blocked** as a flag that can apply at any stage.

- **Backlog** is where all defined user stories live before work begins. Every task enters the board here.
- **In Progress** is where active development happens. A task moves here once a developer picks it up.
- **Testing** is where a completed task is validated against the system's defined test cases before being marked as done. This column was added specifically because the Library Management System has 19 functional test cases that need to be verified.
- **Done** marks tasks that have been implemented and tested successfully.
- **Blocked** is not a stage in the flow — it is a flag. Any task that cannot move forward due to an unresolved dependency or technical issue is moved here so it is visible and can be addressed. This prevents blockers from going unnoticed and stalling the workflow silently.



---

##  Limits Work-In-Progress (WIP)

WIP limits define the maximum number of tasks allowed in a column at one time. The purpose is simple: if you are working on too many things simultaneously, nothing gets finished quickly. 

On our board, the **In Progress** column is limited to 3 tasks at a time. If a new task needs to start, something already in progress must be completed and moved to Testing or Done first. This keeps focus on delivery rather than accumulation.

The **Blocked** column also plays a role here. Rather than leaving a stuck task sitting in In Progress and artificially inflating the count, it gets flagged and moved — keeping the WIP count honest and the workflow moving.

---

## How Our Board Supports Agile Principles

**Continuous delivery** — tasks flow through the board one at a time and are delivered incrementally rather than in one large release at the end. Each user story that reaches Done represents a working piece of the system.

**Adaptability** — because Kanban does not lock work into fixed sprints, priorities can shift without disrupting an entire iteration. If a new requirement comes in or a task gets blocked, the board adjusts in real time.

**Transparency** — every team member can see the state of the project at a glance. There is no ambiguity about what is being worked on, what is waiting, and what is stuck.
