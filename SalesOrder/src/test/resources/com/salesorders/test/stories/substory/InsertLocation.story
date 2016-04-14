Scenario: Creating location 1
Meta: @id1 creat_Location1

Given the name of location BigStore and id is Lakatos utca
When the create loaction is clicked, save
Then the Location must be saved and should return 1

Scenario: Creating location 2
Meta: @id2 creat_Location2

Given the name of location BigMall and id is Gabor utca
When the create loaction is clicked, save
Then the Location must be saved and should return 1

Scenario: Creating locations 3
Meta: @id3 creat_Locations

Given the name of location <location> and id is <adress>
When the create loaction is clicked, save
Then the Location must be saved and should return 1

Examples: 
|location|adress|
|Spar|Kaposvar utca|
|Tesco|lapos volgy|