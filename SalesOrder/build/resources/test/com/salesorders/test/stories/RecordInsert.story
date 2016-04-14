Narrative: Inserting a record into h2database and test using jbehave

Scenario: Creating a location

Given the name of location BigStore and id is Karinti Frigyes u 7
When the create loaction is clicked, save location BigStore and Karinti Frigyes u 7
Then the Location must be saved and should return 1

