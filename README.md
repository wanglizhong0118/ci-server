# ci-server
Compilation: the CI server supports compiling the group project, a static syntax check is to be performed for languages without compiler. Compilation is triggered as webhook, the CI server compiles the branch where the change has been made, as specified in the HTTP payload.

Preparation: the students prepare a specific branch called "assessment" (not "master"). The students document in the README how compilation has been implemented and unit-tested.

Assessment: The grader does a commit in a README in a specific branch, and observes on the server's console that compilation is run (observation can also be made through P3 and P6). Optionally, the grader has a look at the implementation or the tests of this feature.


Testing: the CI server supports executing the automated tests of the group project. Testing is triggered as webhook, on the branch where the change has been made, as specified in the HTTP payload.

Preparation: the students prepare a specific branch called "assessment" (not "master"). The students document in the README how test execution has been implemented and unit-tested.

Assessment: The grader changes the oracle of an assertion in one test, and observes that tests are executed and at least one fails (the one with the changed assertion). Optionally, the grader has a look at the implementation or the tests of this feature.


Notification: the CI server supports notification of CI results. At least one notification mechanism of the following list is implemented:

-   Commit status: the CI server sets the commit status on the repository.
-   Email: the CI server sends an email to the project member about the build result.

Preparation: The students document in the README how notification has been implemented and unit-tested.

Assessment: The grader observes the status of the change made while assessing P2. Optionally, the grader may look at the implementation or the tests of this feature.
