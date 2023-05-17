## [REST API](http://localhost:8080/doc)

## Concept:
- Spring Modulith
  - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
  - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
  - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```
- There are 2 common tables on which there is no fk
- _Reference_ - directory. We make the connection by _code_ (it is impossible by id, because the id is tied to the environment-a specific database)
- _- _User Be long_ - binding of users with the type (owner, read, ...) to the object (longing, project, sprint, ...). We will manually check the FK

## Analogs
- https://java-source.net/open-source/issue-trackers

## Testing
- https://habr.com/ru/articles/259055/

List of completed tasks:
1. Understand the structure of the project (onboarding).
2. Delete social networks: vk, yandex. Easy task
3. Put sensitive information (login, DB password, identifiers for OAuth registration/authorization, mail settings) in a separate property file.
   The values of these properties should be read at server startup from the machine environment variables. Easy task.
   Done, now the data is stored in environment variables 
(db_password=JiraRush;db_url=jdbc:postgresql://localhost:5432/jira;db_username=jira;github_id=3d0d8738e65881fff266; 
github_secret=0f97031ce6178b7dfb67a6af587f37e222a16120;gitlab_id=b8520a3266089063c0d8261cce36971defa513f5ffd9f9b7a3d16728fc83a494;
gitlab_secret=e72c65320cf9d6495984a37b0f9cc03ec46be0bb6f071feaebbfe75168117004;google_id=329113642700-f8if6pu68j2repq3ef6umd5jgiliup60.apps.googleusercontent.com;
google_secret=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;mail_password=zdfzsrqvgimldzyj;mail_username=jira4jr@gmail.com)
4. Redo the tests so that the in memory database (H2) is used during the tests, and not PostgreSQL.
   To do this, you need to define 2 beans, and the selection of which one to use should be determined by the active Spring profile.