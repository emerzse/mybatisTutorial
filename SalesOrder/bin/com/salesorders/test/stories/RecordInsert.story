Narrative: Inserting a record into h2database and test using jbehave

GivenStories: com/salesorders/test/stories/substory/InsertLocation.story#{id1:creat_Location1;id2:creat_Location2;id3:creat_Locations}
Scenario: Creating items

Given the name of item <itemname> and description <description>
When the create item is clicked, save
Then the item must be saved and should return <value>

Examples:     
|itemname|description|value|
|fish|Salmon|true|
|bycicle|red cycle|false|
|Keyboard|hungarian type|true|
|Bag|woman bag|true|
|brush|oralB|true|
