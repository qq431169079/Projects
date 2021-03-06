-- Inserting Races
Insert into faolandb.Races(race_id, race_name) values (1, 'Aquilonian');
Insert into faolandb.Races(race_id, race_name) values (2, 'Cimmerian');
Insert into faolandb.Races(race_id, race_name) values (3, 'Stygian');

-- Inserting Archetypes
Insert into faolandb.Archetypes(arche_id, arche_name) values (1, 'Priest');
Insert into faolandb.Archetypes(arche_id, arche_name) values (2, 'Soldier');
Insert into faolandb.Archetypes(arche_id, arche_name) values (3, 'Rogue');
Insert into faolandb.Archetypes(arche_id, arche_name) values (4, 'Mage');

-- Inserting Classes
Insert into faolandb.Classes(class_id, class_name) values (1, 'Priest of Mitra');
Insert into faolandb.Classes(class_id, class_name) values (2, 'Tempest of Set');
Insert into faolandb.Classes(class_id, class_name) values (3, 'Bear Shaman');
Insert into faolandb.Classes(class_id, class_name) values (4, 'Conqueror');
Insert into faolandb.Classes(class_id, class_name) values (5, 'Dark Templar');
Insert into faolandb.Classes(class_id, class_name) values (6, 'Guardian');
Insert into faolandb.Classes(class_id, class_name) values (7, 'Barbarian');
Insert into faolandb.Classes(class_id, class_name) values (8, 'Ranger');
Insert into faolandb.Classes(class_id, class_name) values (9, 'Assassin');
Insert into faolandb.Classes(class_id, class_name) values (10, 'Herald of Xotli');
Insert into faolandb.Classes(class_id, class_name) values (11, 'Demonologist');
Insert into faolandb.Classes(class_id, class_name) values (12, 'Necromancer');

-- Inserting link between races/archetypes/classes
-- Aquilonians archetypes/classes
Insert into faolandb.Race_Arche_Class values(1,1,1);
Insert into faolandb.Race_Arche_Class values(1,2,4);
Insert into faolandb.Race_Arche_Class values(1,2,5);
Insert into faolandb.Race_Arche_Class values(1,2,6);
Insert into faolandb.Race_Arche_Class values(1,3,7);
Insert into faolandb.Race_Arche_Class values(1,3,8);
Insert into faolandb.Race_Arche_Class values(1,3,9);

-- Cimmerians archetypes/classes
Insert into faolandb.Race_Arche_Class values(2,1,3);
Insert into faolandb.Race_Arche_Class values(2,2,4);
Insert into faolandb.Race_Arche_Class values(2,2,5);
Insert into faolandb.Race_Arche_Class values(2,2,6);
Insert into faolandb.Race_Arche_Class values(2,3,7);
Insert into faolandb.Race_Arche_Class values(2,3,8);

-- Stygians archetypes/classes
Insert into faolandb.Race_Arche_Class values(3,1,2);
Insert into faolandb.Race_Arche_Class values(3,3,8);
Insert into faolandb.Race_Arche_Class values(3,3,9);
Insert into faolandb.Race_Arche_Class values(3,4,10);
Insert into faolandb.Race_Arche_Class values(3,4,11);
Insert into faolandb.Race_Arche_Class values(3,4,12);

