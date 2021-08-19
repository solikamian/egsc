create table cgsc.users
(
    id                  bigserial not null
        constraint users_pkey primary key,
    github_id           bigint    not null
        constraint users_github_id unique,
    create_date         timestamp not null,
    last_update_date    timestamp not null,
    avatar_url          varchar(255),
    events_url          varchar(255),
    followers_url       varchar(255),
    following_url       varchar(255),
    gists_url           varchar(255),
    gravatar_id         varchar(255),
    html_url            varchar(255),
    login               varchar(255)
        constraint uk_users_login unique,
    node_id             varchar(255),
    organizations_url   varchar(255),
    received_events_url varchar(255),
    repos_url           varchar(255),
    site_admin          boolean   not null,
    starred_url         varchar(255),
    subscriptions_url   varchar(255),
    type                varchar(255),
    url                 varchar(255)
);

create table cgsc.verifications
(
    id               bigserial not null
        constraint verifications_pkey primary key,
    create_date      timestamp not null,
    last_update_date timestamp not null,
    payload          varchar(255),
    reason           varchar(255),
    signature        varchar(255),
    verified         boolean   not null
);
create table cgsc.licenses
(
    id               bigserial not null
        constraint licenses_pkey primary key,
    create_date      timestamp not null,
    last_update_date timestamp not null,
    html_url         varchar(255),
    key              varchar(255),
    name             varchar(255),
    node_id          varchar(255),
    spdx_id          varchar(255),
    url              varchar(255)
);
create table cgsc.person_commits
(
    id               bigserial not null
        constraint person_commits_pkey primary key,
    create_date      timestamp not null,
    last_update_date timestamp not null,
    date             timestamp,
    email            varchar(255),
    name             varchar(255)
);
create table cgsc.commits
(
    id               bigserial not null
        constraint commits_pkey primary key,
    create_date      timestamp not null,
    last_update_date timestamp not null,
    comment_count    int4,
    message          varchar(255),
    url              varchar(255),
    author_id        bigint
        constraint commits_author_users_id_fk references cgsc.person_commits,
    committer_id     bigint
        constraint commits_committer_users_id_fk references cgsc.person_commits,
    verification_id  bigint
        constraint commits_verifications_id_fk references cgsc.verifications
);
create table cgsc.projects
(
    id                bigserial not null
        constraint projects_pkey primary key,
    github_id         bigint    not null
        constraint projects_github_id unique,
    create_date       timestamp not null,
    last_update_date  timestamp not null,
    archive_url       varchar(255),
    archived          boolean   not null,
    assignees_url     varchar(255),
    blobs_url         varchar(255),
    branches_url      varchar(255),
    clone_url         varchar(255),
    collaborators_url varchar(255),
    comments_url      varchar(255),
    commits_url       varchar(255),
    compare_url       varchar(255),
    contributors_url  varchar(255),
    created_at        timestamp,
    default_branch    varchar(255),
    deployments_url   varchar(255),
    description       varchar(255),
    disabled          boolean   not null,
    downloads_url     varchar(255),
    events_url        varchar(255),
    fork              boolean   not null,
    forks             int4,
    forks_count       int4,
    forks_url         varchar(255),
    full_name         varchar(255),
    git_commits_url   varchar(255),
    git_refs_url      varchar(255),
    git_tags_url      varchar(255),
    git_url           varchar(255),
    has_downloads     boolean   not null,
    has_issues        boolean   not null,
    has_pages         boolean   not null,
    has_projects      boolean   not null,
    has_wiki          boolean   not null,
    homepage          varchar(255),
    hooks_url         varchar(255),
    html_url          varchar(255),
    issue_comment_url varchar(255),
    issue_events_url  varchar(255),
    issues_url        varchar(255),
    keys_url          varchar(255),
    labels_url        varchar(255),
    language          varchar(255),
    languages_url     varchar(255),
    master_branch     varchar(255),
    merges_url        varchar(255),
    milestones_url    varchar(255),
    mirror_url        varchar(255),
    name              varchar(255)
        constraint uk_projects_name unique,
    node_id           varchar(255),
    notifications_url varchar(255),
    open_issues       int4,
    open_issues_count int4,
    private_value     boolean   not null,
    pulls_url         varchar(255),
    pushed_at         timestamp,
    releases_url      varchar(255),
    score             int4,
    size              int4,
    ssh_url           varchar(255),
    stargazers_count  int4,
    stargazers_url    varchar(255),
    statuses_url      varchar(255),
    subscribers_url   varchar(255),
    subscription_url  varchar(255),
    svn_url           varchar(255),
    tags_url          varchar(255),
    teams_url         varchar(255),
    trees_url         varchar(255),
    updated_at        timestamp,
    url               varchar(255),
    watchers          int4,
    watchers_count    int4,
    license_id        bigint
        constraint projects_licenses_id_fk references cgsc.licenses,
    owner_id          bigint
        constraint projects_owner_user_id_fk references cgsc.users
);
create table cgsc.contributors
(
    id               bigserial not null
        constraint contributors_pkey primary key,
    create_date      timestamp not null,
    last_update_date timestamp not null,
    total            int8,
    author_id        bigint
        constraint contributors_author_users_id_fk references cgsc.users,
    project_id       bigint
        constraint contributors_projects_id_fk references cgsc.projects
);

create table cgsc.project_commits
(
    id               bigserial not null
        constraint project_commits_pkey primary key,
    create_date      timestamp not null,
    last_update_date timestamp not null,
    comments_url     varchar(255),
    html_url         varchar(255),
    node_id          varchar(255),
    sha              varchar(255),
    url              varchar(255),
    author_id        bigint
        constraint contributors_author_users_id_fk references cgsc.users,
    commit_id        bigint
        constraint contributors_commits_id_fk references cgsc.commits on update cascade on delete cascade,
    committer_id     bigint
        constraint contributors_committer_users_id_fk references cgsc.users,
    project_id       bigint
        constraint project_commits_projects_id_fk references cgsc.projects
);


create table cgsc.weeks
(
    id                 bigserial not null
        constraint weeks_pkey primary key,
    create_date        timestamp not null,
    last_update_date   timestamp not null,
    number_of_addition int8,
    number_of_commit   int8,
    number_of_deletion int8,
    start_of_week      int8
);

create table cgsc.contributors_weeks
(
    contributor_id bigint
        constraint contributors_weeks_contributors_id_fk references cgsc.contributors,
    weeks_id       bigint
        constraint contributors_weeks_weeks_id_fk references cgsc.weeks
)


