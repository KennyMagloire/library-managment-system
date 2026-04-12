# Reflection

## Challenges in Selecting the Template

The first challenge was understanding what each template was actually designed for beyond its name. For instance, Kanban and Iterative Development looked similar in terms of how they were presented — both use a board layout and organize tasks by status. The difference only became clear after exploring them more carefully. Iterative Development groups work into sprints and sub-tasks, which means a single feature like user authentication gets broken down into multiple smaller deliverables across different iterations. Kanban, on the other hand, treats each task as a whole and moves it through the workflow from start to finish before the next one begins. Once that distinction was clear, the choice became straightforward — Kanban fits a project like this one where the user stories are already well-defined and do not need to be split into iterations.

Team Planning was easier to rule out. It is table-based and designed for managing capacity across multiple sub-teams, which is not relevant for a single-developer project. It is useful in large organizations where you need a high-level view of who is doing what across different groups, but for tracking individual development tasks it becomes difficult to navigate as the list grows.

## Challenges in Customizing the Board

The main challenge during customization was deciding which additional columns were genuinely relevant to the project rather than just following the assignment example. Testing and Blocked were suggested as examples in the brief, and while both made sense — Testing because the system has 19 defined functional test cases, and Blocked to surface tasks stuck on dependencies — it still required thought to confirm they were the right additions for this specific project rather than generic placeholders.

Managing the number of visible columns was also a challenge. The default template already comes with five columns, and adding two more made the board too wide to capture in a single screenshot. Columns that were not actively in use had to be hidden to keep the board clean and readable.

Getting labels to appear on the board cards required extra steps that were not immediately obvious. Labels are not displayed by default in the board view — they had to be enabled through the view settings, and then applied to all issues in bulk from the repository's issues page.
