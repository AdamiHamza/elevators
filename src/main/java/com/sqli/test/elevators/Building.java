package com.sqli.test.elevators;


import java.util.HashMap;
import java.util.Map;

/**
 * A Building has many elevators so it takes the responsibility
 * to create elevators.
 *
 * @author Adami Hamza
 */
public class Building {
    private Map<String, Elevator> elevators;
    private Dispatcher dispatcher;

    /**
     * @param numberOfFloors: the number of floors in the building
     * @param elevators: an array of descriptions of the elevators of the building. 
     *                   A description has the following format "[elevator_id]:[elevator_current_floor]".
     */
    public Building(int numberOfFloors, String... elevators) {
        this.elevators = new HashMap<>();
        dispatcher = Dispatcher.getInstance();
        for (String elevator : elevators) {
            String id = elevator.split(":")[0];
            int currentFloor = Integer.valueOf(elevator.split(":")[1]);
            Elevator e = new ElevatorContext(id, currentFloor,numberOfFloors);
            this.elevators.put(id, e);
        }
        dispatcher.init(this.elevators,numberOfFloors);
    }

    /**
     * Request an elevator at top floor.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator() {
        Elevator elevator = dispatcher.getClosestElevator();
        elevator.serve(dispatcher.getNumberOfFloors());
        return elevator.getId();
    }

    /**
     * Request an elevator at floor indicate by the {@code floor} param.
     * @param floor : the floor where the request is made.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator(int floor) {
        Elevator elevator = dispatcher.getClosestElevator(floor);
        elevator.serve(floor);
        return elevator.getId();
    }

    /**
     * Request the elevator with the id {@code elevatorId} to stop at the floor indicated by the {@code floor} param.
     * @param elevatorId : the id of the elevator to whom give the order.
     * @param floor : the floor at which the elevator should stop
     */
    public void stopAt(String elevatorId, int floor) {
        elevators.get(elevatorId).stop(floor);
    }

    /**
     * Move the elevator with the id {@code elevatorId} in the direction indicated by the {@code direction} param.
     * @param elevatorId : the id of the elevator to move.
     * @param direction : the direction to go. Can be "UP" or "DOWN".
     */
    public void move(String elevatorId, String direction) {
        Elevator elevator = elevators.get(elevatorId);
        switch (direction) {
            case "UP":
                elevator.getElevatorState().up(elevator, elevator.getCurrentFloor() + 1);
                break;
            case  "DOWN":
                elevator.getElevatorState().down(elevator, elevator.getCurrentFloor() - 1);
                break;
            default:
                throw new IllegalArgumentException("An elevator can move only UP or Down.");
        }
    }

}
