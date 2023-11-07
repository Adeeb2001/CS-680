Fan Control Application - State Design Pattern

This application demonstrates the State design pattern to control the behavior of a fan with multiple speed levels (Off, Low, Medium, and High). The application allows you to switch the fan between different speed levels and turn it off, utilizing the State design pattern to manage the fan's behavior.

Implementation of the State Design Pattern

State Interface (State.java):
The State interface defines a single method, pullChain(), which represents the action of changing the fan's state.
Concrete state classes implement this interface and provide their own pullChain() implementation.

Context Class (Fan.java):
The Fan class serves as the context in which the fan operates.
It maintains a reference to the current state and delegates the pullChain() operation to the current state.
The Fan class allows changing the current state by providing a setState() method.

Concrete State Classes:
OffState: Represents the state when the fan is turned off. When pullChain() is called in this state, the fan transitions to the LowState.
LowState: Represents the state when the fan is running at a low speed. When pullChain() is called in this state, the fan transitions to the MediumState.
MediumState: Represents the state when the fan is running at a medium speed. When pullChain() is called in this state, the fan transitions to the HighState.
HighState: Represents the state when the fan is running at a high speed. When pullChain() is called in this state, the fan transitions back to OffState.

Main Class (Main.java):
The Main class contains the main method and demonstrates the fan control behavior.
It creates a Fan object and toggles the fan's state using the pullChain() method to show transitions between Off, Low, Medium, High, and back to Off.

Test Class (FanTest.java):
The FanTest class contains JUnit tests to verify the fan's behavior in different states.
It ensures that the fan's state transitions occur as expected.

Building and Running the Application
Ensure you have Apache Ant and Ivy installed.
Navigate to the project directory containing the build.xml file.

Building the Application
Run ant compile: This compiles the main code.
Run ant test-compile: This compiles the test code.
Run ant run: This compiles both the main and test code and runs the application.

Running Tests
Run ant test: This executes JUnit tests.