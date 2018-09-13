INSERT INTO `oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `access_token_validity`, `additional_information`) VALUES ('organization-service', '{noop}secret', 'write', 'authorization_code,password,refresh_token,implicit', '9000', '{}');
INSERT INTO `oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `access_token_validity`, `additional_information`) VALUES ('department-service', '{noop}secret', 'write', 'authorization_code,password,refresh_token,implicit', '9000', '{}');
INSERT INTO `oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `access_token_validity`, `additional_information`) VALUES ('employee-service-write', '{noop}secret', 'write', 'authorization_code,password,refresh_token,implicit', '9000', '{}');

TRUNCATE users;
INSERT INTO `users` (`username`,`password`) VALUES ('organization', '{noop}111');
INSERT INTO `users` (`username`,`password`) VALUES ('department', '{noop}111');
INSERT INTO `users` (`username`,`password`) VALUES ('employee', '{noop}111');

TRUNCATE roles;
INSERT INTO `roles` (`name`) VALUES ('ORGANIZATION_CREATE');
INSERT INTO `roles` (`name`) VALUES ('ORGANIZATION_READ');
INSERT INTO `roles` (`name`) VALUES ('ORGANIZATION_UPDATE');
INSERT INTO `roles` (`name`) VALUES ('ORGANIZATION_DELETE');
INSERT INTO `roles` (`name`) VALUES ('DEPARTMENT_CREATE');
INSERT INTO `roles` (`name`) VALUES ('DEPARTMENT_READ');
INSERT INTO `roles` (`name`) VALUES ('DEPARTMENT_UPDATE');
INSERT INTO `roles` (`name`) VALUES ('DEPARTMENT_DELETE');
INSERT INTO `roles` (`name`) VALUES ('EMPLOYEE_CREATE');
INSERT INTO `roles` (`name`) VALUES ('EMPLOYEE_READ');
INSERT INTO `roles` (`name`) VALUES ('EMPLOYEE_UPDATE');
INSERT INTO `roles` (`name`) VALUES ('EMPLOYEE_DELETE');

TRUNCATE users_roles;
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,2);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,3);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,4);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,5);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,6);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,7);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,8);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,9);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,10);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,11);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,12);

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,5);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,6);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,7);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,8);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,9);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,10);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,11);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2,12);

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3,9);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3,10);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3,11);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3,11);











