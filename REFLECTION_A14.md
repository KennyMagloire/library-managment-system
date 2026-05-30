# Reflection — Assignment 14: Open-Source Collaboration

## Improving the Repository Based on Peer Feedback

Before this assignment, the repository was functional but not welcoming to outsiders. Documentation was scattered — markdown files from different assignments lived at the root with no structure, image links were broken in several files, and there was no clear entry point for someone encountering the project for the first time. Preparing for peer review forced me to look at the repository the way a contributor would, not the way a developer who already knows the codebase does.

The first change was structural. All assignment markdown files were moved into a dedicated docs/assignments/ folder, separating documentation from root-level project files like README.md, pom.xml, and the new open-source files. This alone made a visible difference — the root now clearly communicates what the project is rather than dumping every document in one place.

The second change was fixing broken image links. Three files had references using relative paths that would break once the files were moved, and one file had a literal typo in the image filename. These are the kinds of things you only notice when you approach the repository fresh, which is exactly what peer review simulates. Switching to absolute raw.githubusercontent.com URLs eliminated the path dependency entirely, so images render correctly regardless of where the file lives in the folder structure.

The third change was adding the open-source infrastructure: a CONTRIBUTING.md with setup instructions, coding standards, and a PR submission guide; a ROADMAP.md outlining future features by version; a MIT LICENSE; and labelled issues so contributors know where to start.

## Challenges in Onboarding Contributors

The most honest challenge is that this is a solo project, and open-source onboarding is designed for teams. Writing a CONTRIBUTING.md for a project where you are the only contributor requires imagining what a stranger would need to know — which is a different kind of thinking than writing code or documentation for yourself. You have to articulate things that feel obvious to you: why the project is structured the way it is, which patterns are non-negotiable, what a good commit message looks like.

A second challenge was issue labelling. The system already had 17 open issues, most of them assignment-related tasks rather than contribution-ready work. Identifying which ones were genuinely accessible to a newcomer — small enough to be approachable, well-scoped enough to not require deep system knowledge — required revisiting each issue with a contributor's eye. Issues labelled good-first-issue need to be genuinely doable without a long ramp-up, which is a higher bar than it sounds.

The branch protection rules also added friction. Because main requires a reviewed PR, every new file created for this assignment had to go through a branch and a pull request. In a real open-source project this is exactly the right constraint — it protects main from unreviewed changes. For a solo student project it means approving your own work, which highlights a real limitation of free GitHub accounts for simulating collaborative workflows.

## Lessons Learned About Open-Source Collaboration

The biggest lesson is that open-source readiness is a deliberate act, not a byproduct of writing good code. A well-structured codebase with no CONTRIBUTING.md, no labelled issues, and no roadmap is still a closed project in practice — even if the repository is technically public. The difference between a public repository and an open-source project is the investment in making contribution possible.

The second lesson is that documentation debt accumulates fast. Every assignment added files to the root without a plan for how they would relate to each other over time. By Assignment 14, the repository had grown into something that needed significant cleanup before it could be shared with confidence. In a professional setting, this kind of drift would slow down onboarding and erode trust in the project's maintenance. Starting with a clear folder structure and documentation conventions from the beginning would have prevented most of the cleanup required here.

Finally, this assignment reinforced that peer review is not just about catching bugs — it is about testing whether your project communicates its own intent. Code that works is necessary but not sufficient. A repository that someone else can understand, run, and contribute to within a reasonable amount of time is the actual standard open-source projects are held to, and it is a meaningfully higher bar than passing tests. Preparing for that standard, even in a simulated classroom setting, was a genuinely useful exercise.
