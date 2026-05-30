# Reflection — Assignment 8: Object State Modeling and Activity Workflow Modeling
## Library Management System

---

### Granularity: Balancing Detail and Readability

One of the first things I had to think about when building the state diagrams was how much detail to include. Granularity basically means deciding what level of detail is appropriate — and getting that wrong in either direction causes problems. Too much detail and the diagram becomes hard to read; too little and it stops being useful.

A good example of this came up when I was working on the Book state diagram. FR3 mentions that the system should track the condition of a book — things like brand new, damaged, old, or worn. Technically, I could have created substates inside Available to reflect that, something like Available_New or Available_Worn. But I decided against it because it would have cluttered the diagram without adding any real value to understanding how the system behaves. The condition of a book does not change how the system processes a borrow or return — so it did not deserve its own state. The right question to ask is not "can I add this?" but "does the system behave differently because of this?" If the answer is no, it stays out.

The same logic applied to activity diagrams. For the Borrow Book workflow, I kept all five eligibility checks as separate decision nodes because each one produces a different error and a different system response. Collapsing them into one "check eligibility" box would have hidden logic that matters for implementation. So the rule I settled on was: if a developer would need to know this distinction to write correct code, it stays in. If it is just narration, it comes out.

---

### Aligning Diagrams with Agile User Stories

At first I did not see an obvious challenge here because the functional requirements, the user stories, and the diagrams all follow the same logic. They tell the same story. But when I actually started building the activity diagrams, I realised the challenge is not about contradiction — it is about completeness.

User stories are intentionally high-level. US-004 says "as a Librarian, I want to record a borrowing transaction so that member checkouts are tracked accurately." That sentence says nothing about what happens if the member is suspended, or has outstanding fines, or has already reached their borrowing limit. The activity diagram forced me to think through all of those edge cases — five eligibility checks in total — that the user story simply glossed over. The story describes what the Librarian wants to accomplish; the diagram exposes everything the system needs to handle to make that happen.


---

### State Diagrams vs Activity Diagrams


Activity diagrams are easier to follow because they read like a story. There is a start, a sequence of steps, some decisions, and an end. Anyone looking at the Librarian Login diagram can trace exactly what happens from the moment the system starts to the moment the librarian reaches the main menu. The flow is intuitive.

State diagrams are more abstract because they focus on a single object in isolation — not a process, but a thing and all the conditions it can be in. When I was building the LoanRecord diagram, I had to stop thinking about what the librarian does and think purely about what a loan record looks like at any given point in time: is it Active, Overdue, PendingFine, or Closed? That shift in thinking is harder, but it is also more connected to how the system is actually built. A class in Java has attributes and it behaves differently depending on its current state — the state diagram is essentially modeling that at a design level. In that sense, state diagrams are more technical and require a clearer understanding of the system's internals, while activity diagrams are more accessible and easier to validate against what a user actually experiences.

 The two complement each other, The state diagram tells you what is possible for an object. The activity diagram tells you how that possibility is triggered in practice. When they are consistent with each other, you have good evidence that the design holds together.

---


