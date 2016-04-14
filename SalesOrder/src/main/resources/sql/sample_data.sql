INSERT INTO ASSETS(NAME,DESCRIPTION,SIZEX,SIZEY,COLOR, ASSETTYPE) VALUES
('Easter egg','simple red easter egg',5, 7,'red','PARRENTASSET'),
('Easter choclate bunny','simple choclate bunny',7, 15,'gold','PARRENTASSET'),
('Red wine','dry red wine',0, 0,'red','PARRENTASSET'),
('Potatos','simple potatos',5, 5,'brown','PARRENTASSET'),
('Egg','chicken egg',5, 7,'yellow','PARRENTASSET'),
('Ketchup','chilly ketchup',0, 0,'red','PARRENTASSET'),
('Table','small table',2, 3,'black','PARRENTASSET');

INSERT INTO LOCATIONS(NAME,ADDRESS) VALUES
('Big Meal Store','Elm street 13'),
('Big Furniture Store','Baker steet 18');

INSERT INTO SALESORDERTRANS(ASSETID,LOCATION_ID, QUANTITY,PRICE) VALUES
(2,2,100,25400);