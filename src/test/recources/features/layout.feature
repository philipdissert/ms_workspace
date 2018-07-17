Feature: Layout
	As a Guest
	I want to know where stand which WorkspaceElement

Background:
	Given I am on the “CurrentState” page


	Scenario: there are WorkspaceElements in the Workspace
		Given there are WorkspaceElements in the Workspace
		Then then icon of the device type is shon on they Position

	Scenario: there are no WorkspaceElements in the Workspace
		Given there are no WorkspaceElements in the Workspace
		Then an Emty room plan is on the screen