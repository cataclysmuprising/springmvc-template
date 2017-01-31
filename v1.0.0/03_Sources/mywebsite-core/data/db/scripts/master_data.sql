/******      static content        ******/
SET IDENTITY_INSERT mjr_static_content ON;
INSERT INTO mjr_static_content 
(id,		file_name,				file_path,														file_size,		file_type,	record_reg_id,record_upd_id,record_reg_date,record_upd_date) 
VALUES 
(1,	   		'super_user.jpg',		'D:/web-resources/mywebsite/uploadFiles/avatar/super_user.jpg',	'10KB',			0,			1,1,'2017-01-01','2017-01-01');
SET IDENTITY_INSERT mjr_static_content OFF;


/******      user        ******/
SET IDENTITY_INSERT mjr_user ON;
INSERT INTO mjr_user 
(id,	login_id,		age,	name,				gender,		email,					password,															nrc,					phone,			 dob, 				address,			content_id,	record_reg_id,record_upd_id,record_reg_date,record_upd_date) 
VALUES 
(1,	    'super-user',	27,		'Super User',		0,			'superuser@gmail.com',	'ead91e63e08e8e0b9b98375ecd47587644b4380a67128b88f2175c548a7cde0e',	'12/KMY(N)123455',		'09-000000001',	'1990-04-20', 		'Yangon',			1,			1,1,'2017-01-01','2017-01-01');
SET IDENTITY_INSERT mjr_user OFF;


/******      role        ******/
SET IDENTITY_INSERT mjr_role ON;
INSERT INTO mjr_role 
(id,	name,			description,																							record_reg_id,record_upd_id,record_reg_date,record_upd_date) 
VALUES 
(1,	   'SUPER_USER',	'User who has special right, advantage, immunity granted or available all privileges and accesses.',	1,1,'2017-01-01','2017-01-01');
SET IDENTITY_INSERT mjr_role OFF;


/******      user_role        ******/
INSERT INTO mjr_user_role 
(user_id,	role_id,	record_reg_id,record_upd_id,record_reg_date,record_upd_date) 
VALUES 
(1,			1,			1,1,'2017-01-01','2017-01-01');


/******      action        ******/
SET IDENTITY_INSERT mjr_action ON;
INSERT INTO mjr_action 
(id,	 page,			action_name,					display_name,					action_type,	url,											  			description																																					,record_reg_id,record_upd_id,record_reg_date,record_upd_date) 
VALUES 
(1,		'User',			'userDetail',					'User detail',						1,			'/config/users/[0-9]{1,}',									'To view the detail informations of each users.'																											,1,1,'2017-01-01','2017-01-01'),
(2,		'User',			'userProfile',					'User profile',						0,			'/config/users/profile',									'Users can edit their personal informations by themselves.'																									,1,1,'2017-01-01','2017-01-01'),
(3,		'User',			'userAdd',						'User registeration',				1,			'/config/users/add',										'This action is for to create new User.'																													,1,1,'2017-01-01','2017-01-01'),
(4,		'User',			'userEdit',						'Edit users',						1,			'/config/users/[0-9]{1,}/edit$',							'This action can edit personal informations of specific user(can also edit informations other users including change or reset password).'					,1,1,'2017-01-01','2017-01-01'),
(5,		'User',			'userRemove',					'Remove users',						1,			'/config/users/[0-9]{1,}/delete$',							'To remove a specific user from application.'																												,1,1,'2017-01-01','2017-01-01'),
(6,		'User',			'changedPassword',				'Change password',					1,			'/config/users/[0-9]{1,}/changedPassword$',					'To change existing password with new one.(Note: Old password need to provide.)'																			,1,1,'2017-01-01','2017-01-01'),
(7,		'User',			'resetPassword',				'Reset password',					1,			'/config/users/[0-9]{1,}/resetPassword$',					'Forcely replace a user''s password with a new password.(Old password is not required to do this action.)'													,1,1,'2017-01-01','2017-01-01'),

(8,		'Role',			'roleList',						'Role home-page',					0,			'/config/roles',											'Overview informations of all roles provided by application.'																								,1,1,'2017-01-01','2017-01-01'),
(9,		'Role',			'roleAdd',						'Create Roles',						1,			'/config/roles/add',										'To create a new role for application use.'																													,1,1,'2017-01-01','2017-01-01'),
(10,	'Role',			'roleEdit',						'Edit roles',						1,			'/config/roles/[0-9]{1,}/edit$',            				'This action is for edit existing role''s information'																										,1,1,'2017-01-01','2017-01-01'),
(11,	'Role',			'roleRemove',					'Remove roles',						1,			'/config/roles/[0-9]{1,}/delete$',							'To remove a specific role from applcation'																													,1,1,'2017-01-01','2017-01-01'),

(12,	'Setting',		'settingList',					'Setting home-page',				0,			'/config/settings',											'All constant informations(ie. currency,unit,cities etc;) these are used within entire application.'														,1,1,'2017-01-01','2017-01-01'),
(13,	'Setting',		'settingAdd',					'Create settings',					1,			'/config/settings/add',										'To create a new constant(or setting) information.'																											,1,1,'2017-01-01','2017-01-01'),
(14,	'Setting',		'settingEdit',					'Edit settings',					1,			'/config/settings/[0-9]{1,}/edit$',							'To edit existing constant(or setting) information'																											,1,1,'2017-01-01','2017-01-01'),
(15,	'Setting',		'settingRemove',				'Remove settings',					1,			'/config/settings/[0-9]{1,}/delete$',						'Remove a specific application constant(or setting).'																										,1,1,'2017-01-01','2017-01-01');
SET IDENTITY_INSERT mjr_action OFF;


/******      role_action        ******/
INSERT INTO mjr_role_action 
(role_id,  action_id,	record_reg_id,record_upd_id,record_reg_date,record_upd_date) 
VALUES 
(1,			1,			1,1,'2017-01-01','2017-01-01'),	/*userDetail*/
(1,			2,			1,1,'2017-01-01','2017-01-01'),	/*userProfile*/
(1,			3,			1,1,'2017-01-01','2017-01-01'),	/*userAdd*/
(1,			4,			1,1,'2017-01-01','2017-01-01'),	/*userEdit*/
(1,			5,			1,1,'2017-01-01','2017-01-01'),	/*userRemove*/
(1,			6,			1,1,'2017-01-01','2017-01-01'),	/*changedPassword*/
(1,			7,			1,1,'2017-01-01','2017-01-01'),	/*resetPassword*/
(1,			8,			1,1,'2017-01-01','2017-01-01'),	/*roleList*/
(1,			9,			1,1,'2017-01-01','2017-01-01'),	/*roleAdd*/
(1,			10,			1,1,'2017-01-01','2017-01-01'),	/*roleEdit*/
(1,			11,			1,1,'2017-01-01','2017-01-01'),	/*roleRemove*/
(1,			12,			1,1,'2017-01-01','2017-01-01'),	/*settingList*/
(1,			13,			1,1,'2017-01-01','2017-01-01'),	/*settingAdd*/
(1,			14,			1,1,'2017-01-01','2017-01-01'),	/*settingEdit*/
(1,			15,			1,1,'2017-01-01','2017-01-01');	/*settingRemove*/

/******      setting       ******/
INSERT INTO mjr_setting 
(setting_group,setting_name,setting_sub_group,setting_type,setting_value,record_reg_id,record_upd_id,record_reg_date,record_upd_date) 
VALUES 
/******      Country        ******/
('Application','Afghanistan','Country','String','AFG',1,1,'2017-01-01','2017-01-01'),
('Application','Albania','Country','String','ALB',1,1,'2017-01-01','2017-01-01'),
('Application','Algeria','Country','String','DZA',1,1,'2017-01-01','2017-01-01'),
('Application','American Samoa','Country','String','ASM',1,1,'2017-01-01','2017-01-01'),
('Application','Andorra','Country','String','AND',1,1,'2017-01-01','2017-01-01'),
('Application','Angola','Country','String','AGO',1,1,'2017-01-01','2017-01-01'),
('Application','Anguilla','Country','String','AIA',1,1,'2017-01-01','2017-01-01'),
('Application','Antarctica','Country','String','ATA',1,1,'2017-01-01','2017-01-01'),
('Application','Antigua and Barbuda','Country','String',' ATG',1,1,'2017-01-01','2017-01-01'),
('Application','Argentina','Country','String','ARG',1,1,'2017-01-01','2017-01-01'),
('Application','Armenia','Country','String','ARM',1,1,'2017-01-01','2017-01-01'),
('Application','Aruba','Country','String','ABW',1,1,'2017-01-01','2017-01-01'),
('Application','Australia','Country','String','AUS',1,1,'2017-01-01','2017-01-01'),
('Application','Austria','Country','String','AUT',1,1,'2017-01-01','2017-01-01'),
('Application','Azerbaijan','Country','String','AZE',1,1,'2017-01-01','2017-01-01'),
('Application','Bahamas','Country','String','BHS',1,1,'2017-01-01','2017-01-01'),
('Application','Bahrain','Country','String','BHR',1,1,'2017-01-01','2017-01-01'),
('Application','Bangladesh','Country','String','BGD',1,1,'2017-01-01','2017-01-01'),
('Application','Barbados','Country','String','BRB',1,1,'2017-01-01','2017-01-01'),
('Application','Belarus','Country','String','BLR',1,1,'2017-01-01','2017-01-01'),
('Application','Belgium','Country','String','BEL',1,1,'2017-01-01','2017-01-01'),
('Application','Belize','Country','String',' BLZ',1,1,'2017-01-01','2017-01-01'),
('Application','Benin','Country','String',' BEN',1,1,'2017-01-01','2017-01-01'),
('Application','Bermuda','Country','String',' BMU',1,1,'2017-01-01','2017-01-01'),
('Application','Bhutan','Country','String','BTN',1,1,'2017-01-01','2017-01-01'),
('Application','Bolivia','Country','String','BOL',1,1,'2017-01-01','2017-01-01'),
('Application','Bosnia and Herzegovina','Country','String','BIH',1,1,'2017-01-01','2017-01-01'),
('Application','Botswana','Country','String','BWA',1,1,'2017-01-01','2017-01-01'),
('Application','Brazil','Country','String','BRA',1,1,'2017-01-01','2017-01-01'),
('Application','British Indian Ocean Territory','Country','String','IOT',1,1,'2017-01-01','2017-01-01'),
('Application','British Virgin Islands','Country','String','VGB',1,1,'2017-01-01','2017-01-01'),
('Application','Brunei','Country','String','BRN',1,1,'2017-01-01','2017-01-01'),
('Application','Bulgaria','Country','String','BGR',1,1,'2017-01-01','2017-01-01'),
('Application','Burkina Faso','Country','String','BFA',1,1,'2017-01-01','2017-01-01'),
('Application','Burundi','Country','String','BDI',1,1,'2017-01-01','2017-01-01'),
('Application','Cambodia','Country','String','KHM',1,1,'2017-01-01','2017-01-01'),
('Application','Cameroon','Country','String','CMR',1,1,'2017-01-01','2017-01-01'),
('Application','Canada','Country','String','CAN',1,1,'2017-01-01','2017-01-01'),
('Application','Cape Verde','Country','String','CPV',1,1,'2017-01-01','2017-01-01'),
('Application','Cayman Islands','Country','String','CYM',1,1,'2017-01-01','2017-01-01'),
('Application','Central African Republic','Country','String','CAF',1,1,'2017-01-01','2017-01-01'),
('Application','Chad','Country','String','TCD',1,1,'2017-01-01','2017-01-01'),
('Application','Chile','Country','String','CHL',1,1,'2017-01-01','2017-01-01'),
('Application','China','Country','String','CHN',1,1,'2017-01-01','2017-01-01'),
('Application','Christmas Island','Country','String','CXR',1,1,'2017-01-01','2017-01-01'),
('Application','Cocos Islands','Country','String','CCK',1,1,'2017-01-01','2017-01-01'),
('Application','Colombia','Country','String','COL',1,1,'2017-01-01','2017-01-01'),
('Application','Comoros','Country','String','COM',1,1,'2017-01-01','2017-01-01'),
('Application','Cook Islands','Country','String','COK',1,1,'2017-01-01','2017-01-01'),
('Application','Costa Rica','Country','String','CRI',1,1,'2017-01-01','2017-01-01'),
('Application','Croatia','Country','String','HRV',1,1,'2017-01-01','2017-01-01'),
('Application','Cuba','Country','String','CUB',1,1,'2017-01-01','2017-01-01'),
('Application','Curacao','Country','String','CUW',1,1,'2017-01-01','2017-01-01'),
('Application','Cyprus','Country','String','CYP',1,1,'2017-01-01','2017-01-01'),
('Application','Czech Republic','Country','String','CZE',1,1,'2017-01-01','2017-01-01'),
('Application','Democratic Republic of the Congo','Country','String','COD',1,1,'2017-01-01','2017-01-01'),
('Application','Denmark','Country','String','DNK',1,1,'2017-01-01','2017-01-01'),
('Application','Djibouti','Country','String','DJI',1,1,'2017-01-01','2017-01-01'),
('Application','Dominica','Country','String','DMA',1,1,'2017-01-01','2017-01-01'),
('Application','Dominican Republic','Country','String','DOM',1,1,'2017-01-01','2017-01-01'),
('Application','East Timor','Country','String','TLS',1,1,'2017-01-01','2017-01-01'),
('Application','Ecuador','Country','String',' ECU',1,1,'2017-01-01','2017-01-01'),
('Application','Egypt','Country','String','EGY',1,1,'2017-01-01','2017-01-01'),
('Application','El Salvador','Country','String','SLV',1,1,'2017-01-01','2017-01-01'),
('Application','Equatorial Guinea','Country','String','GNQ',1,1,'2017-01-01','2017-01-01'),
('Application','Eritrea','Country','String','ERI',1,1,'2017-01-01','2017-01-01'),
('Application','Estonia','Country','String','EST',1,1,'2017-01-01','2017-01-01'),
('Application','Ethiopia','Country','String','ETH',1,1,'2017-01-01','2017-01-01'),
('Application','Falkland Islands','Country','String','FLK',1,1,'2017-01-01','2017-01-01'),
('Application','Faroe Islands','Country','String','FRO',1,1,'2017-01-01','2017-01-01'),
('Application','Fiji','Country','String','FJI',1,1,'2017-01-01','2017-01-01'),
('Application','Finland','Country','String','FIN',1,1,'2017-01-01','2017-01-01'),
('Application','France','Country','String','FRA',1,1,'2017-01-01','2017-01-01'),
('Application','French Polynesia','Country','String','PYF',1,1,'2017-01-01','2017-01-01'),
('Application','Gabon','Country','String','GAB',1,1,'2017-01-01','2017-01-01'),
('Application','Gambia','Country','String','GMB',1,1,'2017-01-01','2017-01-01'),
('Application','Georgia','Country','String','GEO',1,1,'2017-01-01','2017-01-01'),
('Application','Germany','Country','String','DEU',1,1,'2017-01-01','2017-01-01'),
('Application','Ghana','Country','String','GHA',1,1,'2017-01-01','2017-01-01'),
('Application','Gibraltar','Country','String','GIB',1,1,'2017-01-01','2017-01-01'),
('Application','Greece','Country','String','GRC',1,1,'2017-01-01','2017-01-01'),
('Application','Greenland','Country','String','GRL',1,1,'2017-01-01','2017-01-01'),
('Application','Grenada','Country','String','GRD',1,1,'2017-01-01','2017-01-01'),
('Application','Guam','Country','String','GUM',1,1,'2017-01-01','2017-01-01'),
('Application','Guatemala','Country','String','GTM',1,1,'2017-01-01','2017-01-01'),
('Application','Guernsey','Country','String','GGY',1,1,'2017-01-01','2017-01-01'),
('Application','Guinea','Country','String','GIN',1,1,'2017-01-01','2017-01-01'),
('Application','Guinea-Bissau','Country','String','GNB',1,1,'2017-01-01','2017-01-01'),
('Application','Guyana','Country','String','GUY',1,1,'2017-01-01','2017-01-01'),
('Application','Haiti','Country','String','HTI',1,1,'2017-01-01','2017-01-01'),
('Application','Honduras','Country','String','HND',1,1,'2017-01-01','2017-01-01'),
('Application','Hong Kong','Country','String','HKG',1,1,'2017-01-01','2017-01-01'),
('Application','Hungary','Country','String','HUN',1,1,'2017-01-01','2017-01-01'),
('Application','Iceland','Country','String','ISL',1,1,'2017-01-01','2017-01-01'),
('Application','India','Country','String',' IND',1,1,'2017-01-01','2017-01-01'),
('Application','Indonesia','Country','String','IDN',1,1,'2017-01-01','2017-01-01'),
('Application','Iran','Country','String','IRN',1,1,'2017-01-01','2017-01-01'),
('Application','Iraq','Country','String','IRQ',1,1,'2017-01-01','2017-01-01'),
('Application','Ireland','Country','String','IRL',1,1,'2017-01-01','2017-01-01'),
('Application','Isle of Man','Country','String','IMN',1,1,'2017-01-01','2017-01-01'),
('Application','Israel','Country','String','ISR',1,1,'2017-01-01','2017-01-01'),
('Application','Italy','Country','String','ITA',1,1,'2017-01-01','2017-01-01'),
('Application','Ivory Coast','Country','String','CIV',1,1,'2017-01-01','2017-01-01'),
('Application','Jamaica','Country','String','JAM',1,1,'2017-01-01','2017-01-01'),
('Application','Japan','Country','String',' JPN',1,1,'2017-01-01','2017-01-01'),
('Application','Jersey','Country','String','JEY',1,1,'2017-01-01','2017-01-01'),
('Application','Jordan','Country','String','JOR',1,1,'2017-01-01','2017-01-01'),
('Application','Kazakhstan','Country','String','KAZ',1,1,'2017-01-01','2017-01-01'),
('Application','Kenya','Country','String','KEN',1,1,'2017-01-01','2017-01-01'),
('Application','Kiribati','Country','String','KIR',1,1,'2017-01-01','2017-01-01'),
('Application','Kosovo','Country','String','XKX',1,1,'2017-01-01','2017-01-01'),
('Application','Kuwait','Country','String','KWT',1,1,'2017-01-01','2017-01-01'),
('Application','Kyrgyzstan','Country','String','KGZ',1,1,'2017-01-01','2017-01-01'),
('Application','Laos','Country','String','LAO',1,1,'2017-01-01','2017-01-01'),
('Application','Latvia','Country','String','LVA',1,1,'2017-01-01','2017-01-01'),
('Application','Lebanon','Country','String','LBN',1,1,'2017-01-01','2017-01-01'),
('Application','Lesotho','Country','String','LSO',1,1,'2017-01-01','2017-01-01'),
('Application','Liberia','Country','String','LBR',1,1,'2017-01-01','2017-01-01'),
('Application','Libya','Country','String','LBY',1,1,'2017-01-01','2017-01-01'),
('Application','Liechtenstein','Country','String','LIE',1,1,'2017-01-01','2017-01-01'),
('Application','Lithuania','Country','String','LTU',1,1,'2017-01-01','2017-01-01'),
('Application','Luxembourg','Country','String','LUX',1,1,'2017-01-01','2017-01-01'),
('Application','Macau','Country','String','MAC',1,1,'2017-01-01','2017-01-01'),
('Application','Macedonia','Country','String','MKD',1,1,'2017-01-01','2017-01-01'),
('Application','Madagascar','Country','String','MDG',1,1,'2017-01-01','2017-01-01'),
('Application','Malawi','Country','String','MWI',1,1,'2017-01-01','2017-01-01'),
('Application','Malaysia','Country','String','MYS',1,1,'2017-01-01','2017-01-01'),
('Application','Maldives','Country','String','MDV',1,1,'2017-01-01','2017-01-01'),
('Application','Mali','Country','String','MLI',1,1,'2017-01-01','2017-01-01'),
('Application','Malta','Country','String','MLT',1,1,'2017-01-01','2017-01-01'),
('Application','Marshall Islands','Country','String','MHL',1,1,'2017-01-01','2017-01-01'),
('Application','Mauritania','Country','String','MRT',1,1,'2017-01-01','2017-01-01'),
('Application','Mauritius','Country','String','MUS',1,1,'2017-01-01','2017-01-01'),
('Application','Mayotte','Country','String','MYT',1,1,'2017-01-01','2017-01-01'),
('Application','Mexico','Country','String','MEX',1,1,'2017-01-01','2017-01-01'),
('Application','Micronesia','Country','String','FSM',1,1,'2017-01-01','2017-01-01'),
('Application','Moldova','Country','String','MDA',1,1,'2017-01-01','2017-01-01'),
('Application','Monaco','Country','String','MCO',1,1,'2017-01-01','2017-01-01'),
('Application','Mongolia','Country','String','MNG',1,1,'2017-01-01','2017-01-01'),
('Application','Montenegro','Country','String','MNE',1,1,'2017-01-01','2017-01-01'),
('Application','Montserrat','Country','String','MSR',1,1,'2017-01-01','2017-01-01'),
('Application','Morocco','Country','String','MAR',1,1,'2017-01-01','2017-01-01'),
('Application','Mozambique','Country','String','MOZ',1,1,'2017-01-01','2017-01-01'),
('Application','Myanmar','Country','String','MMR',1,1,'2017-01-01','2017-01-01'),
('Application','Namibia','Country','String','NAM',1,1,'2017-01-01','2017-01-01'),
('Application','Nauru','Country','String','NRU',1,1,'2017-01-01','2017-01-01'),
('Application','Nepal','Country','String','NPL',1,1,'2017-01-01','2017-01-01'),
('Application','Netherlands','Country','String','NLD',1,1,'2017-01-01','2017-01-01'),
('Application','Netherlands Antilles','Country','String','ANT',1,1,'2017-01-01','2017-01-01'),
('Application','New Caledonia','Country','String','NCL',1,1,'2017-01-01','2017-01-01'),
('Application','New Zealand','Country','String','NZL',1,1,'2017-01-01','2017-01-01'),
('Application','Nicaragua','Country','String','NIC',1,1,'2017-01-01','2017-01-01'),
('Application','Niger','Country','String','NER',1,1,'2017-01-01','2017-01-01'),
('Application','Nigeria','Country','String','NGA',1,1,'2017-01-01','2017-01-01'),
('Application','Niue','Country','String','NIU',1,1,'2017-01-01','2017-01-01'),
('Application','North Korea','Country','String','PRK',1,1,'2017-01-01','2017-01-01'),
('Application','Northern Mariana Islands','Country','String','MNP',1,1,'2017-01-01','2017-01-01'),
('Application','Norway','Country','String','NOR',1,1,'2017-01-01','2017-01-01'),
('Application','Oman','Country','String','OMN',1,1,'2017-01-01','2017-01-01'),
('Application','Pakistan','Country','String','PAK',1,1,'2017-01-01','2017-01-01'),
('Application','Palau','Country','String','PLW',1,1,'2017-01-01','2017-01-01'),
('Application','Palestine','Country','String','PSE',1,1,'2017-01-01','2017-01-01'),
('Application','Panama','Country','String','PAN',1,1,'2017-01-01','2017-01-01'),
('Application','Papua New Guinea','Country','String','PNG',1,1,'2017-01-01','2017-01-01'),
('Application','Paraguay','Country','String','PRY',1,1,'2017-01-01','2017-01-01'),
('Application','Peru','Country','String','PER',1,1,'2017-01-01','2017-01-01'),
('Application','Philippines','Country','String','PHL',1,1,'2017-01-01','2017-01-01'),
('Application','Pitcairn','Country','String','PCN',1,1,'2017-01-01','2017-01-01'),
('Application','Poland','Country','String','POL',1,1,'2017-01-01','2017-01-01'),
('Application','Portugal','Country','String','PRT',1,1,'2017-01-01','2017-01-01'),
('Application','Puerto Rico','Country','String','PRI',1,1,'2017-01-01','2017-01-01'),
('Application','Qatar','Country','String','QAT',1,1,'2017-01-01','2017-01-01'),
('Application','Republic of the Congo','Country','String','COG',1,1,'2017-01-01','2017-01-01'),
('Application','Reunion','Country','String','REU',1,1,'2017-01-01','2017-01-01'),
('Application','Romania','Country','String','ROU',1,1,'2017-01-01','2017-01-01'),
('Application','Russia','Country','String','RUS',1,1,'2017-01-01','2017-01-01'),
('Application','Rwanda','Country','String','RWA',1,1,'2017-01-01','2017-01-01'),
('Application','Saint Barthelemy','Country','String','BLM',1,1,'2017-01-01','2017-01-01'),
('Application','Saint Helena','Country','String','SHN',1,1,'2017-01-01','2017-01-01'),
('Application','Saint Kitts and Nevis','Country','String','KNA',1,1,'2017-01-01','2017-01-01'),
('Application','Saint Lucia','Country','String','LCA',1,1,'2017-01-01','2017-01-01'),
('Application','Saint Martin','Country','String','MAF',1,1,'2017-01-01','2017-01-01'),
('Application','Saint Pierre and Miquelon','Country','String','SPM',1,1,'2017-01-01','2017-01-01'),
('Application','Saint Vincent and the Grenadines','Country','String','VCT',1,1,'2017-01-01','2017-01-01'),
('Application','Samoa','Country','String','WSM',1,1,'2017-01-01','2017-01-01'),
('Application','San Marino','Country','String','SMR',1,1,'2017-01-01','2017-01-01'),
('Application','Sao Tome and Principe','Country','String','STP',1,1,'2017-01-01','2017-01-01'),
('Application','Saudi Arabia','Country','String','SAU',1,1,'2017-01-01','2017-01-01'),
('Application','Senegal','Country','String','SEN',1,1,'2017-01-01','2017-01-01'),
('Application','Serbia','Country','String','SRB',1,1,'2017-01-01','2017-01-01'),
('Application','Seychelles','Country','String','SYC',1,1,'2017-01-01','2017-01-01'),
('Application','Sierra Leone','Country','String','SLE',1,1,'2017-01-01','2017-01-01'),
('Application','Singapore','Country','String','SGP',1,1,'2017-01-01','2017-01-01'),
('Application','Sint Maarten','Country','String','SXM',1,1,'2017-01-01','2017-01-01'),
('Application','Slovakia','Country','String','SVK',1,1,'2017-01-01','2017-01-01'),
('Application','Slovenia','Country','String','SVN',1,1,'2017-01-01','2017-01-01'),
('Application','Solomon Islands','Country','String','SLB',1,1,'2017-01-01','2017-01-01'),
('Application','Somalia','Country','String','SOM',1,1,'2017-01-01','2017-01-01'),
('Application','South Africa','Country','String','ZAF',1,1,'2017-01-01','2017-01-01'),
('Application','South Korea','Country','String','KOR',1,1,'2017-01-01','2017-01-01'),
('Application','South Sudan','Country','String','SSD',1,1,'2017-01-01','2017-01-01'),
('Application','Spain','Country','String','ESP',1,1,'2017-01-01','2017-01-01'),
('Application','Sri Lanka','Country','String','LKA',1,1,'2017-01-01','2017-01-01'),
('Application','Sudan','Country','String','SDN',1,1,'2017-01-01','2017-01-01'),
('Application','Suriname','Country','String','SUR',1,1,'2017-01-01','2017-01-01'),
('Application','Svalbard and Jan Mayen','Country','String','SJM',1,1,'2017-01-01','2017-01-01'),
('Application','Swaziland','Country','String','SWZ',1,1,'2017-01-01','2017-01-01'),
('Application','Sweden','Country','String','SWE',1,1,'2017-01-01','2017-01-01'),
('Application','Switzerland','Country','String','CHE',1,1,'2017-01-01','2017-01-01'),
('Application','Syria','Country','String','SYR',1,1,'2017-01-01','2017-01-01'),
('Application','Taiwan','Country','String','TWN',1,1,'2017-01-01','2017-01-01'),
('Application','Tajikistan','Country','String','TJK',1,1,'2017-01-01','2017-01-01'),
('Application','Tanzania','Country','String','TZA',1,1,'2017-01-01','2017-01-01'),
('Application','Thailand','Country','String','THA',1,1,'2017-01-01','2017-01-01'),
('Application','Togo','Country','String','TGO',1,1,'2017-01-01','2017-01-01'),
('Application','Tokelau','Country','String','TKL',1,1,'2017-01-01','2017-01-01'),
('Application','Tonga','Country','String','TON',1,1,'2017-01-01','2017-01-01'),
('Application','Trinidad and Tobago','Country','String','TTO',1,1,'2017-01-01','2017-01-01'),
('Application','Tunisia','Country','String','TUN',1,1,'2017-01-01','2017-01-01'),
('Application','Turkey','Country','String','TUR',1,1,'2017-01-01','2017-01-01'),
('Application','Turkmenistan','Country','String','TKM',1,1,'2017-01-01','2017-01-01'),
('Application','Turks and Caicos Islands','Country','String','TCA',1,1,'2017-01-01','2017-01-01'),
('Application','Tuvalu','Country','String','TUV',1,1,'2017-01-01','2017-01-01'),
('Application','U.S. Virgin Islands','Country','String','VIR',1,1,'2017-01-01','2017-01-01'),
('Application','Uganda','Country','String','UGA',1,1,'2017-01-01','2017-01-01'),
('Application','Ukraine','Country','String','UKR',1,1,'2017-01-01','2017-01-01'),
('Application','United Arab Emirates','Country','String','ARE',1,1,'2017-01-01','2017-01-01'),
('Application','United Kingdom','Country','String','GBR',1,1,'2017-01-01','2017-01-01'),
('Application','United States','Country','String','USA',1,1,'2017-01-01','2017-01-01'),
('Application','Uruguay','Country','String','URY',1,1,'2017-01-01','2017-01-01'),
('Application','Uzbekistan','Country','String','UZB',1,1,'2017-01-01','2017-01-01'),
('Application','Vanuatu','Country','String','VUT',1,1,'2017-01-01','2017-01-01'),
('Application','Vatican','Country','String','VAT',1,1,'2017-01-01','2017-01-01'),
('Application','Venezuela','Country','String','VEN',1,1,'2017-01-01','2017-01-01'),
('Application','Vietnam','Country','String','VNM',1,1,'2017-01-01','2017-01-01'),
('Application','Wallis and Futuna','Country','String','WLF',1,1,'2017-01-01','2017-01-01'),
('Application','Western Sahara','Country','String','ESH',1,1,'2017-01-01','2017-01-01'),
('Application','Yemen','Country','String','YEM',1,1,'2017-01-01','2017-01-01'),
('Application','Zambia','Country','String','ZMB',1,1,'2017-01-01','2017-01-01'),
('Application','Zimbabwe','Country','String','ZWE',1,1,'2017-01-01','2017-01-01'),

/******      Currency        ******/

('Application',	'Myanmar Kyats',			'Currency',		'String',		'MMK',		1,1,'2017-01-01','2017-01-01'),
('Application',	'United States Dollar',		'Currency',		'String',		'USD',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Euro',						'Currency',		'String',		'EUR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Singapore Dollar',			'Currency',		'String',		'SGD',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Pound Sterling',			'Currency',		'String',		'GBP',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Swiss Franc',				'Currency',		'String',		'CHF',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Japanese Yen',				'Currency',		'String',		'JPY',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Australian Dollar',		'Currency',		'String',		'AUD',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Bangladesh Taka',			'Currency',		'String',		'BDT',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Brazilian Real',			'Currency',		'String',		'BRL',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Brunei Dollar',			'Currency',		'String',		'BND',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Cambodian Riel',			'Currency',		'String',		'KHR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Canadian Dollar',			'Currency',		'String',		'CAD',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Chinese Yuan',				'Currency',		'String',		'CNY',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Czech Koruna',				'Currency',		'String',		'CZK',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Danish Kroner',			'Currency',		'String',		'DKK',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Egyptian Pound',			'Currency',		'String',		'EGP',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Hong Kong Dollar',			'Currency',		'String',		'HKD',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Indian Rupee',				'Currency',		'String',		'INR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Indonesian Rupiah',		'Currency',		'String',		'IDR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Israeli Shekel',			'Currency',		'String',		'ILS',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Kenya Shilling',			'Currency',		'String',		'KES',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Korea Won',				'Currency',		'String',		'KRW',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Kuwaiti Dinar',			'Currency',		'String',		'KRW',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Lao Kip',					'Currency',		'String',		'LAK',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Malaysian Ringgit',		'Currency',		'String',		'MYR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Napalese Rupee',			'Currency',		'String',		'NPR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'New Zealand Dollar',		'Currency',		'String',		'NZD',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Norwegian Kroner',			'Currency',		'String',		'NOK',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Pakstani Rupee',			'Currency',		'String',		'PKR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Philippines Peso',			'Currency',		'String',		'PHP',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Russian Rouble',			'Currency',		'String',		'RUB',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Saudi Arabian Riyal',		'Currency',		'String',		'SAR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Serbian Dinar',			'Currency',		'String',		'RSD',		1,1,'2017-01-01','2017-01-01'),
('Application',	'South Africa Rand',		'Currency',		'String',		'ZAR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Sri Lankan Rupee',			'Currency',		'String',		'LKR',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Swedish Kroner',			'Currency',		'String',		'SEK',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Thai Bhat',				'Currency',		'String',		'THB',		1,1,'2017-01-01','2017-01-01'),
('Application',	'Vietnamese Dong',			'Currency',		'String',		'VND',		1,1,'2017-01-01','2017-01-01'),
/******      File upload directory        ******/
('Application',	'UploadPath',			'File Directory',	'String',	'D:/web-resources/fams/uploadFiles',		1,1,'2017-01-01','2017-01-01');