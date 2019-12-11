INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('userBuildClientIdPassword', '$2a$10$/C4MRI8fzMGUS4E.f.xc7uSR5LIpShyvxV3ESfUEg3gzhLUpLE3Gq', 'userbuild,read,write',
	'password,authorization_code,refresh_token,client_credentials', null, null, 36000, 36000, null, true);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('sampleClientId', '$2a$10$/C4MRI8fzMGUS4E.f.xc7uSR5LIpShyvxV3ESfUEg3gzhLUpLE3Gq', 'read,write,userbuild',
	'implicit', null, null, 36000, 36000, null, false);


INSERT INTO userapp (id, name, password, is_valid) values(1,'tom','$2a$10$QdIhD0MoPvh.bFH8YktRu.NYdv0n178h//f5T44laKWpZgHPweBQi', true) ON CONFLICT (id) DO update set password = '$2a$10$QdIhD0MoPvh.bFH8YktRu.NYdv0n178h//f5T44laKWpZgHPweBQi';




